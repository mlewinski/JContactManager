package org.jcontactmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jcontactmanager.JavaFxMain;
import org.jcontactmanager.model.ContactInformation;


public class ContactOverviewController {

    @FXML
    private TableView<ContactInformation> contactTable;
    @FXML
    private TableColumn<ContactInformation, Integer> idColumn;
    @FXML
    private TableColumn<ContactInformation, String> nicknameColumn;
    @FXML
    private TableColumn<ContactInformation, String> nameColumn;
    @FXML
    private TableColumn<ContactInformation, String> genderColumn;
    @FXML
    private TableColumn<ContactInformation, String> cityColumn;
    @FXML
    private TableColumn<ContactInformation, String> countryColumn;
    @FXML
    private TableColumn<ContactInformation, String> websiteColumn;

    private JavaFxMain javaFxMain;

    public ContactOverviewController(){

    };


    @FXML
    private void initialize(){
        //idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty()); //parse to other
        nicknameColumn.setCellValueFactory(cellData -> cellData.getValue().getNicknameProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().getGenderProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().getCityProperty());
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().getCountryProperty());
        websiteColumn.setCellValueFactory(cellData -> cellData.getValue().getWebsiteProperty());

    }

    public void setJavaFxMain(JavaFxMain javaFxMain){
        this.javaFxMain=javaFxMain;

        contactTable.setItems(javaFxMain.getContactInformationData());
    }

}
