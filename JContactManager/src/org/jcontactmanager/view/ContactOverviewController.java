package org.jcontactmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.jcontactmanager.JavaFxMain;
import org.jcontactmanager.model.Contact;
import org.jcontactmanager.model.ContactInformation;


public class ContactOverviewController {

    @FXML
    private TableView<Contact> contactTable;
    @FXML
    private TableColumn<Contact, Integer> idColumn;
    @FXML
    private TableColumn<Contact, String> nicknameColumn;
    @FXML
    private TableColumn<Contact, String> nameColumn;
    @FXML
    private TableColumn<Contact, String> genderColumn;
    @FXML
    private TableColumn<Contact, String> cityColumn;
    @FXML
    private TableColumn<Contact, String> countryColumn;
    @FXML
    private TableColumn<Contact, String> websiteColumn;

    private JavaFxMain javaFxMain;

    public ContactOverviewController(){

    };


    @FXML
    private void initialize(){
        //idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty()); //parse to other
        nicknameColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getNicknameProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getNameProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getGenderProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getCityProperty());
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getCountryProperty());
        websiteColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getWebsiteProperty());

    }

    public void setJavaFxMain(JavaFxMain javaFxMain){
        this.javaFxMain=javaFxMain;

        contactTable.setItems(javaFxMain.getContactInformationData());
    }

}
