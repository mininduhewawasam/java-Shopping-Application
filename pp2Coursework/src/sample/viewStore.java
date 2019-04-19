package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class viewStore implements Initializable {

    @FXML
    private TableView<adminStoreTable> table;
    @FXML
    private TableColumn<adminStoreTable, String> col_name;
    @FXML
    private TableColumn<adminStoreTable, String> col_code;
    @FXML
    private TableColumn<adminStoreTable, String> col_size;
    @FXML
    private TableColumn<adminStoreTable, String> col_price;
    @FXML
    private TableColumn<adminStoreTable, String> col_stock;
    @FXML
    private AnchorPane viewstore;

    private ObservableList<adminStoreTable> observerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        connectDatabase connectDatabase4 = new connectDatabase();
        connectDatabase4.dbName = "STORE";
        Connection connection = connectDatabase4.getConnection();

        try{

            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM products");

            while(rs.next()){

                observerList.add(new adminStoreTable(rs.getString("productName"), rs.getString("productCode"), rs.getString("productSize"), rs.getString("productPrice"), rs.getString("stockQ")));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        col_name.setCellValueFactory(new PropertyValueFactory<>("productName"));
        col_code.setCellValueFactory(new PropertyValueFactory<>("productCode"));
        col_size.setCellValueFactory(new PropertyValueFactory<>("productSize"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stockQ"));

        table.setItems(observerList);
    }

    public void switchtoStaffMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffManageStore.fxml"));
        viewstore.getChildren().setAll(pane);
    }

    public void switchtoJeffMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("jeffManageStore.fxml"));
        viewstore.getChildren().setAll(pane);
    }
}


