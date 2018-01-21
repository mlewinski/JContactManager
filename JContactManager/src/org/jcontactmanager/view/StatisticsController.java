package org.jcontactmanager.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import org.jcontactmanager.JavaFxMain;
import org.jcontactmanager.model.Contact;
import org.jcontactmanager.model.ContactRepository;

import java.util.Set;

public class StatisticsController {
    private JavaFxMain javaFxMain;
    private ObservableList<Contact> contactInformationData;

    @FXML
    private BarChart<String, Integer> cityChart;

    @FXML
    private CategoryAxis cityChartXAxis;

    @FXML
    private BarChart<String, Integer> countryChart;

    @FXML
    private CategoryAxis countryChartXAxis;

    @FXML
    private PieChart genderChart;

    @FXML
    private PieChart networkChart;


    public void setJavaFxMain(JavaFxMain javaFxMain) {
        this.javaFxMain = javaFxMain;
    }

    @FXML
    private void initialize() {

    }

    /**
     * Show statistic (Gender, Network, City, Coutry)
     */
    public void showStatistics(){

        ObservableMap<String, Integer> cityCount = FXCollections.observableHashMap();
        ObservableMap<String, Integer> countryCount = FXCollections.observableHashMap();
        ObservableMap<String, Integer> networkCount = FXCollections.observableHashMap();
        contactInformationData = javaFxMain.getContactInformationData();
        for(Contact c : contactInformationData){
            cityCount.put(c.getContactInformation().getCity(), cityCount.getOrDefault(c.getContactInformation().getCity(), 0)+1);
            countryCount.put(c.getContactInformation().getCountry(), cityCount.getOrDefault(c.getContactInformation().getCountry(), 0)+1);
            networkCount.put(c.getMessengers().getPhoneNumbers().getPrivateNetwork(), networkCount.getOrDefault(c.getMessengers().getPhoneNumbers().getPrivateNetwork(),0)+1);
        }
        Set<String> cities = cityCount.keySet();
        cityChartXAxis.setCategories(FXCollections.observableArrayList(cityCount.keySet().toArray(new String[cities.size()])));
        Set<String> countries = countryCount.keySet();
        countryChartXAxis.setCategories(FXCollections.observableArrayList(countryCount.keySet().toArray(new String[countries.size()])));
        for(String city : cities){
            XYChart.Series<String, Integer> tmp = new XYChart.Series<>();
            tmp.getData().add(new XYChart.Data<>(city, cityCount.get(city)));
            cityChart.getData().add(tmp);
        }
        XYChart.Series<String, Integer> countriesSeries = new XYChart.Series<>();
        for(String country : countries){
            XYChart.Series<String, Integer> tmp = new XYChart.Series<>();
            tmp.getData().add(new XYChart.Data<>(country, countryCount.get(country)));
            countryChart.getData().add(tmp);
        }
        //todo: gender chart, mobile network chart
        int femaleCount =0, maleCount = 0, other = 0;
        for(Contact c : contactInformationData){
            if(c.getContactInformation().getGender().equals("female")){
                femaleCount++;
                continue;
            }
            if(c.getContactInformation().getGender().equals("male")){
                maleCount++;
                continue;
            }
            other++;
        }
        ObservableList<PieChart.Data> genders = FXCollections.observableArrayList(
                new PieChart.Data("male", maleCount),
                new PieChart.Data("female", femaleCount),
                new PieChart.Data("other", other)
        );
        for(PieChart.Data d : genders)
            genderChart.getData().add(d);

        Set<String> networks = networkCount.keySet();
        for(String n : networks){
            networkChart.getData().add(new PieChart.Data(n, networkCount.get(n)));
        }
    }
}
