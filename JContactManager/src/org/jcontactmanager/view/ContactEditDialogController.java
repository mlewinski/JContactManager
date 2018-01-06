package org.jcontactmanager.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.jcontactmanager.model.*;

import javax.swing.text.html.ListView;
import java.awt.*;

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
    private TextField homePhoneNumberField;
    @FXML
    private TextField businessPhoneNumberField;
    @FXML
    private TextField privatePhoneNumberField;
    @FXML
    private TextField networkField;
    @FXML
    private TextField privateEmailAddressField;
    @FXML
    private TextField businessEmailAddressField;
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

        nameField.setText(contact.getContactInformation().getName());
        nicknameField.setText(contact.getContactInformation().getNickname());
        addressField.setText(contact.getContactInformation().getAddress());
        cityField.setText(contact.getContactInformation().getCity());
        websiteField.setText(contact.getContactInformation().getWebsite());
        privatePhoneNumberField.setText(contact.getPhoneNumbers().toString());
        noteField.setText(contact.getContactInformation().getNote());

    }

    public boolean isOkClicekd() {
        return okClicekd;
    }

    @FXML
    private void handleOK(){
//        if(isInputValid()){ //TODO: uzupełnić przekazywane parametry
//            contact.setContactInformation(new ContactInformation(1,nameField.getText(),nicknameField.getText(),genderField.getText(),addressField.getText(),
//                    cityField.getText(), countryField.getText(),noteField.getText(),websiteField.getText()));
//            contact.setEmailAddresses(new Email());
//            contact.setPhoneNumbers(new PhoneNumber());
//            contact.setId(); //ID
//            contact.setOtherCommunicators(new Communicator());
//
//            okClicekd = true;
//            dialogStage.close();
//        }
    }

    @FXML
    private void handleCancel(){}
}
