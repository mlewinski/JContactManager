package org.jcontactmanager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jcontactmanager.model.*;
import org.jcontactmanager.view.*;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
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

    /**
     * Set application properties and start primary Stage
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JContactManager");


        initRootLayout();
        if(applicationProperties!=null && (!applicationProperties.containsKey("env.first_run") || applicationProperties.getProperty("env.first_run").equals("true"))){
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

    /**
     * Return list with information about Contact
     * @return contactInformationData
     */
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

            primaryStage.show();
        }catch (IOException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Load stage with contact information
     */
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


    /**
     * Get selected contact and return with current values
     * @param contact
     * @return boolean value
     */
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
            controller.setJavaFxMain(this);

            //Show the dialog
            dialogStage.showAndWait();
            return controller.isClicked();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Load new stage with setting
     */
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

    /**
     * Load new stage with home
     */
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
            statisticsController.showStatistics();
            rootLayoutController.setPathLabel("Statistics");
            rootLayout.setCenter(statisticsOverview);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Perform operation on database
     * @param contact
     * @param contactInformation
     * @param messenger
     * @param email
     * @param phoneNumber
     */
    public void performRepositoryOperation(String contact, String contactInformation, String messenger, String email, String phoneNumber){
        try{
            repository.execute(contact);
            repository.execute(contactInformation);
            repository.execute(messenger);
            repository.execute(email);
            repository.execute(phoneNumber);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem with the database");
            alert.setHeaderText("The application has encountered error with the database. It is not possible for the application to continue. Please refer to the information below.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("The database config file cannot be accessed");
            alert.setHeaderText("The application cannot find the database.properties file or it is inaccessible. Please generate a new config file using Settings.");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }
}