package org.jcontactmanager.view;

import javafx.fxml.FXML;
import org.jcontactmanager.JavaFxMain;

public class RootLayoutController {
    private JavaFxMain javaFxMain;

    public void setJavaFxMain (JavaFxMain javaFxMain) {this.javaFxMain=javaFxMain;}

    @FXML
    private void handleNew()
    {
        javaFxMain.getContactInformationData().clear();
    }
}
