package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class StaffMainController  {
    @FXML
    private AnchorPane staffMain;


    public void Switchlogout()throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        staffMain.getChildren().setAll(pane);
    }

    public void SwitchAccountSettings()throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("StaffAccountSettings.fxml"));
        staffMain.getChildren().setAll(pane);
    }

    public void switchManageStore()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffManageStore.fxml"));
        staffMain.getChildren().setAll(pane);
    }

    public void switchViewCustomTransactions()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffViewTransaction.fxml"));
        staffMain.getChildren().setAll(pane);
    }

    public void switchsendNewsLetters()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffNewsLeters.fxml"));
        staffMain.getChildren().setAll(pane);
    }

    public void switchmanagecustomers()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffViewCustomers.fxml"));
        staffMain.getChildren().setAll(pane);
    }
}
