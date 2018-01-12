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
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jcontactmanager.model.*;
import org.jcontactmanager.view.*;
import sun.plugin.javascript.navig.Anchor;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JavaFxMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public Properties applicationProperties;
    private Properties databaseProperties;

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ContactRepository repository;
    private ObservableList<Contact> contactInformationData = FXCollections.observableArrayList();

    private RootLayoutController rootLayoutController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JContactManager");


        initRootLayout();
        if(applicationProperties!=null && (!applicationProperties.containsKey("env.first_run") || applicationProperties.getProperty("env.first_run")=="true")){
            showSettings();
            try {
                applicationProperties.setProperty("env.first_run", "false");
                applicationProperties.store(new FileOutputStream(Paths.get(".", "/", "JContactManager/app.properties").normalize().toFile()), null);
            }
            catch (IOException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Warning - properties");
                alert.setContentText("Application has encountered a problem while trying to save resources/app.properties file. Application will run using the default config.");
                alert.showAndWait();
            }
        }
        else {
            showHome();
        }
    }

    public JavaFxMain(){

                //contactInformationData.add(new ContactInformation(1,"name","nickname","gender","addres","city","contry","note","website"));
        repository = new ContactRepository();
        contactInformationData = repository.getRepositoryReference();
        try {
            databaseProperties = new Properties();
            databaseProperties.load(new FileInputStream(Paths.get(".", "/", "JContactManager/database.properties").normalize().toFile()));
        }
        catch(IOException ex){
            applicationProperties = null;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Warning - properties");
            alert.setContentText("Application has encountered a problem while trying to access resources/database.properties file. Application will run using the zero-config.");
            alert.showAndWait();
        }
        try {
            applicationProperties = new Properties();
            applicationProperties.load(new FileInputStream(Paths.get(".", "/", "JContactManager/app.properties").normalize().toFile()));
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
            rootLayoutController = loader.getController();
            rootLayoutController.setJavaFxMain(this);
            if(applicationProperties == null || !applicationProperties.containsKey("env.username")) {
                rootLayoutController.setUsername("---");
            }
            else{
                rootLayoutController.setUsername(applicationProperties.getProperty("env.username"));
            }

            if(applicationProperties!=null && applicationProperties.containsKey("view.background") && !applicationProperties.getProperty("view.background").isEmpty()) {
                File f = new File(applicationProperties.getProperty("view.background"));
                if (f.exists()) {
                    BackgroundImage backgroundImage = new BackgroundImage(
                            new Image("file:///"+applicationProperties.getProperty("view.background"),
                                    primaryStage.getWidth(), primaryStage.getHeight(), false, true),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                    rootLayout.setBackground(new Background(backgroundImage));
                }
            }

            this.primaryStage.getIcons().add(new Image(Paths.get(".", "/", "icons/app_icon.png").normalize().toFile().toURI().toString()));

            //Show the scene containing root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            //TODO: Controller to RootLayout

            primaryStage.show();
        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    public void showContactOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/ContactOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            ContactOverviewController overviewController = loader.getController();
            overviewController.setJavaFxMain(this);
            rootLayoutController.setPathLabel("Contacts");
            rootLayout.setCenter(personOverview);
        }catch(IOException e){
            e.printStackTrace();
        }
    }



    public boolean showContactEditingDialog(Contact contact)
    {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/ContactEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            //DialogStage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Contact");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            //Contact into controller
            ContactEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setContact(contact);

            //Show the dialog
            dialogStage.showAndWait();

            return controller.isClicked();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }

    public void showSettings(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/Settings.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            SettingsController stcl = loader.getController();
            stcl.setGlobalApplicationProperties(applicationProperties);
            stcl.setGlobalDatabaseProperties(databaseProperties);
            stcl.init();
            rootLayoutController.setPathLabel("Settings");

            rootLayout.setCenter(personOverview);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showHome() {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(JavaFxMain.class.getResource("view/Home.fxml"));
                AnchorPane homeOverview = (AnchorPane) loader.load();
                HomeController homeController = loader.getController();
                homeController.setJavaFxMain(this);
                rootLayoutController.setPathLabel("Home");
                rootLayout.setCenter(homeOverview);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void showStatistics(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxMain.class.getResource("view/Statistics.fxml"));
            Pane statisticsOverview = (Pane) loader.load();
            StatisticsController statisticsController = loader.getController();
            statisticsController.setJavaFxMain(this);
            rootLayoutController.setPathLabel("Statistics");
            rootLayout.setCenter(statisticsOverview);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setContactRepository(String contact, String contactInformation, String email, String phoneNumber){
        try{
            repository.save(contact);
            repository.save(contactInformation);
            repository.save(email);
            repository.save(phoneNumber);
        }catch (SQLException e)
        {

        }catch (IOException e){

        }

    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }
}