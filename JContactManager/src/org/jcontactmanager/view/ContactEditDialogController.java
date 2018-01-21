package org.jcontactmanager.view;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jcontactmanager.JavaFxMain;
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
    private TextArea noteField;

    private Stage dialogStage;
    private JavaFxMain javaFxMain;
    private Contact contact;
    private boolean isClicked = false;
    private boolean isEditClicked = false;


    public void setJavaFxMain(JavaFxMain javaFxMain) {
        this.javaFxMain = javaFxMain;
    }

    private void initialize() {
    }

    /**
     * Set dialog Stage
     * @param dialogStage
     */

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    /**
     * Load contact to edit dialog or create new contact
     * @param contact
     */
    public void setContact(Contact contact) {

        this.contact = contact;
        if (this.contact != null) {
            nameField.setText(contact.getContactInformation().getName());
            nicknameField.setText(contact.getContactInformation().getNickname());
            genderField.setText(contact.getContactInformation().getGender());
            addressField.setText(contact.getContactInformation().getAddress());
            countryField.setText(contact.getContactInformation().getCountry());
            privateEmailAddressField.setText(contact.getMessengers().getEmails().getPrivateEmailAddress());
            workEmailAddressField.setText(contact.getMessengers().getEmails().getWorkEmailAddress());
            cityField.setText(contact.getContactInformation().getCity());
            websiteField.setText(contact.getContactInformation().getWebsite());
            privatePhoneNumberField.setText(contact.getMessengers().getPhoneNumbers().getPrivateNumber());
            workPhoneNumberField.setText(contact.getMessengers().getPhoneNumbers().getWorkNumber());
            privateNetworkField.setText(contact.getMessengers().getPhoneNumbers().getPrivateNetwork());
            workNetworkField.setText(contact.getMessengers().getPhoneNumbers().getWorkNetwork());
            noteField.setText(contact.getContactInformation().getNote());

            isEditClicked = true;
        }
        else
            isEditClicked = false;
    }

    public boolean isClicked() {
        return isClicked;
    }

    /**
     * Add new contact to DB and table after click OK
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    private void handleOK() throws SQLException, IOException {

        Random random = new Random();
        int contactId = random.nextInt();

        Contact contact = new Contact();
        contact.setId(contactId);
        contact.setContactInformation(new ContactInformation(contactId,nameField.getText(), nicknameField.getText(), genderField.getText(), addressField.getText(),
                cityField.getText(), countryField.getText(), noteField.getText(), websiteField.getText()));
        contact.setMessengers(new Messengers(contactId,"0",new Email(contactId, privateEmailAddressField.getText(), workEmailAddressField.getText()),
                                new PhoneNumber(contactId, workPhoneNumberField.getText(), privatePhoneNumberField.getText(), workNetworkField.getText(), privateNetworkField.getText())));

        String contactInformationSQL = contact.getContactInformation().saveQuery();
        String phoneNumberSQL = contact.getMessengers().getPhoneNumbers().saveQuery();
        String emailSQL = contact.getMessengers().getEmails().saveQuery();
        String contactSQL = contact.saveQuery();
        String messengerSQL = contact.getMessengers().saveQuery();

        javaFxMain.performRepositoryOperation(contactSQL,contactInformationSQL,messengerSQL,emailSQL,phoneNumberSQL);
        javaFxMain.getContactInformationData().add(contact);
        if(isEditClicked){
            javaFxMain.performRepositoryOperation(this.contact.deleteQuery(),this.contact.getContactInformation().deleteQuery()
                    ,this.contact.getMessengers().deleteQuery()
                    ,this.contact.getMessengers().getEmails().deleteQuery()
                    ,this.contact.getMessengers().getPhoneNumbers().deleteQuery());
            javaFxMain.getContactInformationData().remove(this.contact);
        }
        isClicked = true;
        dialogStage.close();

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
