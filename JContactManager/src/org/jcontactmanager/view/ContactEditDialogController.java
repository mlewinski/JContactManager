package org.jcontactmanager.view;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jcontactmanager.model.*;

import java.io.IOException;
import java.sql.SQLException;
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
    private boolean isClicked = false;

    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


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

    public boolean isClicked() {
        return isClicked;
    }

    //dodawanie
    @FXML
    private void handleOK() throws SQLException,IOException{
         //TODO: uzupełnić przekazywane parametry
            Random random = new Random();
            int contactId = random.nextInt();
            int communicatorId = random.nextInt();

            Contact contact = new Contact();
            contact.setId(contactId);
            contact.setContactInformation(new ContactInformation(contactId,nameField.getText(),nicknameField.getText(),genderField.getText(),addressField.getText(),
                    cityField.getText(), countryField.getText(),noteField.getText(),websiteField.getText()));
            contact.setEmailAddress(new Email(communicatorId,privateEmailAddressField.getText(),workEmailAddressField.getText(),noteField.getText()));
            contact.setPhoneNumber(new PhoneNumber(communicatorId, workPhoneNumberField.getText(),privatePhoneNumberField.getText(),workNetworkField.getText(),privateNetworkField.getText()));

            ContactRepository contactRepository = new ContactRepository();
            contactRepository.save(contact.getContactInformation().saveQuery());
            contactRepository.save(contact.getPhoneNumber().saveQuery());
            contactRepository.save(contact.getEmailAddress().saveQuery());
            contactRepository.save(contact.saveQuery());


            isClicked = true;
            dialogStage.close();
        }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }
}
