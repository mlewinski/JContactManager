package org.jcontactmanager.view;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.jcontactmanager.JavaFxMain;
import org.jcontactmanager.model.Contact;
import org.jcontactmanager.model.ContactRepository;

import java.io.IOException;
import java.sql.SQLException;


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

    @FXML
    private TextField searchContact;

    private JavaFxMain javaFxMain;


    @FXML
    private void initialize() {
        //idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty()); //parse to other
        nicknameColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getNicknameProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getNameProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getGenderProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getCityProperty());
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getCountryProperty());
        websiteColumn.setCellValueFactory(cellData -> cellData.getValue().getContactInformation().getWebsiteProperty());

    }


    @FXML
    private void handleNewContact() {
        boolean okClicked = javaFxMain.showContactEditingDialog(null); //TODO: Zmienic nulla na tempcontact
    }

    @FXML
    private void handleEditContact() {
        Contact selectedContact = contactTable.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            boolean okClicked = javaFxMain.showContactEditingDialog(selectedContact);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(javaFxMain.getPrimaryStage());
            alert.setTitle("No selection");
            alert.setHeaderText("No contact selected");
            alert.setContentText("Please select a contact in the table.");

        }
    }

    @FXML
    public void handleDeletePerson() {
        int selectedIndex = contactTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Contact deletedContact = contactTable.getSelectionModel().getSelectedItem();
            contactTable.getItems().remove(selectedIndex);
            this.javaFxMain.performRepositoryOperation(deletedContact.deleteQuery(),
                    deletedContact.getContactInformation().deleteQuery(),
                    deletedContact.getMessengers().deleteQuery(),
                    deletedContact.getMessengers().getEmails().deleteQuery(),
                    deletedContact.getMessengers().getPhoneNumbers().deleteQuery()
            );

        } else {
            //Nothings selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(javaFxMain.getPrimaryStage());
            alert.setTitle("No selection");
            alert.setHeaderText("No Contact selected");
            alert.setContentText("Please select a person in the table");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleSearchContact() {
        contactTable.getSelectionModel().clearSelection();
        contactTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (int i = 0; i < contactTable.getItems().size(); i++) {
            String searchField = searchContact.getText();
            Contact contact = javaFxMain.getContactInformationData().get(i);
            if (contact.getContactInformation().getName().equals(searchField)) {
                contactTable.getSelectionModel().select(i);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            }
        }

    }


    public void deleteSelectedContact() {
        handleDeletePerson();
    }

    public void setJavaFxMain(JavaFxMain javaFxMain) {
        this.javaFxMain = javaFxMain;

        contactTable.setItems(javaFxMain.getContactInformationData());
    }

}
