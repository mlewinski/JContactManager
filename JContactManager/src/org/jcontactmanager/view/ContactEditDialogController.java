package org.jcontactmanager.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.jcontactmanager.model.*;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactEditDialogController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField nicknameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField workPhoneNumberField;
    @FXML
    private TextField privatePhoneNumberField;
    @FXML
    private TextField privateNetworkField;
    @FXML
    private TextField workNetworkField;
    @FXML
    private TextField privateEmailAddressField;
    @FXML
    private TextField workEmailAddressField;
    @FXML
    private TextField noteField;

    private Stage dialogStage;
    private Contact contact;
    private boolean okClicekd = false;

    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    //TODO: Dorobic pola w fxmlu i dopisac pola w Controllerze oraz zaimplementować logikę dodawania do bazy
    //TODO: SET contact jest źle zaimplementowane, trzeba przekazać podobnie jak w HandleOK()


    public void setContact(Contact contact) {

        this.contact = contact;
        if(this.contact != null){
            nameField.setText(contact.getContactInformation().getName());
            nicknameField.setText(contact.getContactInformation().getNickname());
            genderField.setText(contact.getContactInformation().getGender());
            addressField.setText(contact.getContactInformation().getAddress());
            countryField.setText(contact.getContactInformation().getCountry());
            privateEmailAddressField.setText(contact.getEmailAddress().getPrivateEmailAddress());
            workEmailAddressField.setText(contact.getEmailAddress().getWorkEmailAddress());
            cityField.setText(contact.getContactInformation().getCity());
            websiteField.setText(contact.getContactInformation().getWebsite());
            privatePhoneNumberField.setText(contact.getPhoneNumber().getPrivateNumber());
            workPhoneNumberField.setText(contact.getPhoneNumber().getWorkNumber());
            privateNetworkField.setText(contact.getPhoneNumber().getPrivateNetwork());
            workNetworkField.setText(contact.getPhoneNumber().getWorkNetwork());
            noteField.setText(contact.getContactInformation().getNote());
        }
    }

    public boolean isOkClicekd() {
        return okClicekd;
    }

    //dodawanie
    @FXML
    private void handleOK(){
        if(this.contact == null){ //TODO: uzupełnić przekazywane parametry
            Random random = new Random();
            int contactID = random.nextInt();

            Contact contact = new Contact();
            contact.setContactInformation(new ContactInformation(contactID,nameField.getText(),nicknameField.getText(),genderField.getText(),addressField.getText(),
                    cityField.getText(), countryField.getText(),noteField.getText(),websiteField.getText()));
            contact.setEmailAddress(new Email(1,privateEmailAddressField.getText(),workEmailAddressField.getText(),noteField.getText()));
            contact.setPhoneNumber(new PhoneNumber(1, workPhoneNumberField.getText(),privatePhoneNumberField.getText(),workNetworkField.getText(),privateNetworkField.getText()));

            okClicekd = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }
}
