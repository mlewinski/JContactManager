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

    private ObservableMap<String, Integer> cityCount = FXCollections.observableHashMap();
    private ObservableMap<String, Integer> countryCount = FXCollections.observableHashMap();

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
        contactInformationData = javaFxMain.getContactInformationData();
        for(Contact c : contactInformationData){
            cityCount.put(c.getContactInformation().getCity(), cityCount.getOrDefault(c.getContactInformation().getCity(), 0)+1);
            countryCount.put(c.getContactInformation().getCountry(), cityCount.getOrDefault(c.getContactInformation().getCountry(), 0)+1);
        }
        Set<String> cities = cityCount.keySet();
        cityChartXAxis.setCategories(FXCollections.observableArrayList(cityCount.keySet().toArray(new String[cities.size()])));
        Set<String> countries = countryCount.keySet();
        countryChartXAxis.setCategories(FXCollections.observableArrayList(countryCount.keySet().toArray(new String[countries.size()])));
        XYChart.Series<String, Integer> citiesSeries = new XYChart.Series<>();
        for(String city : cities){
            citiesSeries.getData().add(new XYChart.Data<>(city, cityCount.get(city)));
        }
        cityChart.getData().add(citiesSeries);
        XYChart.Series<String, Integer> countriesSeries = new XYChart.Series<>();
        for(String country : countries){
            countriesSeries.getData().add(new XYChart.Data<>(country, countryCount.get(country)));
        }
        countryChart.getData().add(countriesSeries);
        //todo: gender chart, mobile network chart

    }
}
