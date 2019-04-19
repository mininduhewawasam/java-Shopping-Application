package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewCustomers implements Initializable {
    @FXML
    private TableView<adminCustomerTable> allCustomers;
    @FXML
    private TableColumn<adminCustomerTable,String> CustomerName;
    @FXML
    private TableColumn<adminCustomerTable,String> customerAddress;
    @FXML
    private TableColumn<adminCustomerTable, String> customerEmail;
    @FXML
    private AnchorPane viewCustomers;

    private ObservableList<adminCustomerTable> CustomerobserverList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectDatabase connectDatabase4 = new connectDatabase();
        connectDatabase4.dbName = "JEFF";
        Connection connection = connectDatabase4.getConnection();

        try{

            ResultSet rs = connection.createStatement().executeQuery("SELECT Name,email,address FROM USER");

            while(rs.next()){

                CustomerobserverList.add(new adminCustomerTable(rs.getString("Name"), rs.getString("address"), rs.getString("email")));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        CustomerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));


        allCustomers.setItems(CustomerobserverList);

    }
    public void switchtoStaffMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffMain.fxml"));
        viewCustomers.getChildren().setAll(pane);
    }

    public void switchtoJeffMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Jeffsmain.fxml"));
        viewCustomers.getChildren().setAll(pane);
    }

}
