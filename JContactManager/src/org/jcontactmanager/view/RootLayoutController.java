package org.jcontactmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jcontactmanager.JavaFxMain;

public class RootLayoutController {
    @FXML
    private Label usernameLabel;

    @FXML
    private Label pathLabel;

    private JavaFxMain javaFxMain;

    public void setJavaFxMain (JavaFxMain javaFxMain) {this.javaFxMain=javaFxMain;}

    public void setUsername(String username){
        usernameLabel.setText(username);
    }

    public void setPathLabel(String path){
        pathLabel.setText(path);
    }



    @FXML
    private void handleSettings(){javaFxMain.showSettings();}

    @FXML
    private void handleContactOverview(){javaFxMain.showContactOverview();}

    @FXML
    private void handleHome(){ javaFxMain.showHome();}

    @FXML
    private void handleStatistics(){ javaFxMain.showStatistics();}
}
