package org.jcontactmanager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jcontactmanager.model.Contact;
import org.jcontactmanager.model.ContactInformation;
import org.jcontactmanager.model.ContactRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JavaFxMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Properties applicationProperties;

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ContactRepository repository;
    private ObservableList<Contact> contactInformationData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JContactManager");


        initRootLayout();

        showPersonOverview();

    }

    public JavaFxMain(){
        //contactInformationData.add(new ContactInformation(1,"name","nickname","gender","addres","city","contry","note","website"));
        repository = new ContactRepository();
        contactInformationData = repository.getRepositoryReference();
        try {
            applicationProperties = new Properties();
            applicationProperties.load(new FileInputStream("resources/app.properties"));
        }
        catch(IOException ex){
            applicationProperties = null;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Warning - properties");
            alert.setContentText("Application has encountered a problem while trying to access resources/app.properties file. Application will run using the default config.");
            alert.showAndWait();
        }
    }

    public ObservableList<Contact> getContactInformationData() {
        return contactInformationData;
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            if(applicationProperties.containsKey("view.background")) {
                File f = new File("resources/" + applicationProperties.getProperty("view.background"));
                if (f.exists()) {
                    BackgroundImage backgroundImage = new BackgroundImage(new Image(applicationProperties.getProperty("view.background"), primaryStage.getWidth(), primaryStage.getHeight(), false, true),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                    rootLayout.setBackground(new Background(backgroundImage));
                }
            }

            //Show the scene containing root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            //TODO: Controller to RootLayout

            primaryStage.show();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showPersonOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/ContactOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }
}