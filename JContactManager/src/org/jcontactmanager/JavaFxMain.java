package org.jcontactmanager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jcontactmanager.model.Contact;
import org.jcontactmanager.model.ContactInformation;
import org.jcontactmanager.model.ContactRepository;

import java.io.IOException;

public class JavaFxMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

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
    }

    public ObservableList<Contact> getContactInformationData() {
        return contactInformationData;
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

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