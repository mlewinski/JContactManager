package org.jcontactmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class SettingsController {

    private Properties globalApplicationProperties;
    private Properties globalDatabaseProperties;

    @FXML
    private TextField textDisplayName;
    @FXML
    private TextField textBackgroundImage;
    @FXML
    private TextField textJdbcUrl;
    @FXML
    private TextField textJdbcUsername;
    @FXML
    private PasswordField textJdbcPassword;

    public void setGlobalApplicationProperties(Properties props){
        globalApplicationProperties = props;
    }

    public void setGlobalDatabaseProperties(Properties props){
        globalDatabaseProperties = props;
    }

    @FXML
    private void handleSave(){
        try {
            if(!textDisplayName.getText().isEmpty()) globalApplicationProperties.setProperty("env.username", textDisplayName.getText());
            if(!textBackgroundImage.getText().isEmpty()) globalApplicationProperties.setProperty("view.background", textBackgroundImage.getText());
            if(!textJdbcUrl.getText().isEmpty()) globalDatabaseProperties.setProperty("jdbc.url", textJdbcUrl.getText());
            if(!textJdbcUsername.getText().isEmpty()) globalDatabaseProperties.setProperty("jdbc.username", textJdbcUsername.getText());
            if(!textJdbcPassword.getText().isEmpty()) globalDatabaseProperties.setProperty("jdbc.password", textJdbcPassword.getText());

            globalApplicationProperties.store(new FileOutputStream(Paths.get(".", "/", "app.properties").normalize().toFile()), null);
            globalDatabaseProperties.store(new FileOutputStream(Paths.get(".", "/", "database.properties").normalize().toFile()), null);
        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Warning - properties");
            alert.setContentText("Application has encountered a problem while trying to save resources/app.properties file. Application will run using the default config.");
            alert.showAndWait();
        }
    }

}
