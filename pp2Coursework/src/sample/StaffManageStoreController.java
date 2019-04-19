package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffManageStoreController extends Staff{

    @FXML
    public TextField itemName;
    @FXML
    private TextField itemCode;
    @FXML
    private TextField itemSize;
    @FXML
    private TextField itemPrice;
    @FXML
    private Label promptStoreError;
    @FXML
    private TextField pid;
    @FXML
    private Label deleteErroeMsg;
    @FXML
    private AnchorPane staffManageStore;
    @FXML
    private TextField StockQuantity;
    @FXML
    private TextField prdctID;
    @FXML
    private TextField updatedQuantity;
    @FXML
    private Label updateEror;

    public void addStoreItemsValidate() {

        promptStoreError.setText(null);
        if(itemName.getText().isEmpty()||itemCode.getText().isEmpty()||itemPrice.getText().isEmpty()||itemSize.getText().isEmpty()||StockQuantity.getText().isEmpty()){
            promptStoreError.setText("Please fill all the fields before adding to store");
        }

        else {
            try {
                addStoreItems(itemName.getText(),itemCode.getText(),itemSize.getText(),itemPrice.getText(),StockQuantity.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            itemName.clear();
            itemCode.clear();
            itemSize.clear();
            itemPrice.clear();
            StockQuantity.clear();
        }
    }
    public void removeStoreItems() throws SQLException {
        if(pid.getText().isEmpty()){
            deleteErroeMsg.setText("Please enter the product ID to romove");
        }
        else {
            try {
                removeItemsFromStore(pid.getText());
                deleteErroeMsg.setText("Item Removed");
            }catch (SQLException e){
                e.printStackTrace();
            }
            pid.clear();

        }
    }

    public void updateStore() {

        connectDatabase connectDatabase1 = new connectDatabase();
        connectDatabase1.dbName = "STORE";
        Connection connection6 = connectDatabase1.getConnection();

        if (prdctID.getText().isEmpty() || updatedQuantity.getText().isEmpty()) {
            updateEror.setText("Please fill all the fields");
        } else {

            try {
                String sql1 = "UPDATE products SET stockQ =? WHERE productCode in('" + prdctID.getText() + "')";
                PreparedStatement ps = connection6.prepareStatement(sql1);

                ps.setString(1, updatedQuantity.getText());
                ps.execute();
            } catch (Exception e) {
            }
        }
        updateEror.setText("Stock Updated");
        prdctID.clear();
        updatedQuantity.clear();
    }


    public void switchStaffMain()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffMain.fxml"));
        staffManageStore.getChildren().setAll(pane);
    }

    public void switchJeffMainFromStore()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Jeffsmain.fxml"));
        staffManageStore.getChildren().setAll(pane);
    }


    public void switchviewStore()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffViewStore.fxml"));
        staffManageStore.getChildren().setAll(pane);
    }

    public void switchViewstore()throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("jeffViewStore.fxml"));
        staffManageStore.getChildren().setAll(pane);
    }
}
