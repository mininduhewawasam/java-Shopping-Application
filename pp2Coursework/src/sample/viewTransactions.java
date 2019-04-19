package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewTransactions {
    private ObservableList<Transactions> obList = FXCollections.observableArrayList();


    @FXML
    private TableView<Transactions> transactionTable;
    @FXML
    private TableColumn<Transactions, String> col_CustomerName;
    @FXML
    private TableColumn<Transactions, String> col_ProductName;
    @FXML
    private TableColumn<Transactions, String> col_quantity;
    @FXML
    private TableColumn<Transactions, String> col_subTotal;
    @FXML
    private TableColumn<Transactions, String> col_date;
    @FXML
    private TextField custmerName;
    @FXML
    private TextField Date;
    @FXML
    private TextField Month;
    @FXML
    private TextField Year;
    @FXML
    private AnchorPane viewstranactions;


    public void viewcustomerTransactions(){
        removeAllRows();
        connectDatabase connectDatabase7 = new connectDatabase();
        connectDatabase7.dbName = "STORE";//specifing the name of dataBase
        Connection connection = connectDatabase7.getConnection();

        try{

            ResultSet rs6 = connection.createStatement().executeQuery("SELECT customerName,productName,quantity,subTotal,date FROM purchasehistory WHERE customerName='" +custmerName.getText()+ "'");

            while(rs6.next()){
                obList.add(new Transactions(rs6.getString("customerName"), rs6.getString("productName"), rs6.getString("quantity"), rs6.getString("subTotal"), rs6.getString("date")));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        col_CustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        col_ProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_subTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        transactionTable.setItems(obList);
        custmerName.clear();



    }

    public void viewTransactionsFromDate(){
        removeAllRows();
        connectDatabase connectDatabase7 = new connectDatabase();
        connectDatabase7.dbName = "STORE";//specifing the name of dataBase
        Connection connection = connectDatabase7.getConnection();


        try{

            ResultSet rs6 = connection.createStatement().executeQuery("SELECT customerName,productName,quantity,subTotal,date FROM purchasehistory WHERE date='" +Year.getText()+ "-" +Month.getText()+ "-" +Date.getText()+ "'");

            while(rs6.next()){

                obList.add(new Transactions(rs6.getString("customerName"), rs6.getString("productName"), rs6.getString("quantity"), rs6.getString("subTotal"), rs6.getString("date")));

            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        col_CustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        col_ProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_subTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        transactionTable.setItems(obList);
        Date.clear();
        Month.clear();
        Year.clear();
    }

    public void customerPurchaseHistory(){
        removeAllRows();
        connectDatabase connectDatabase7 = new connectDatabase();
        connectDatabase7.dbName = "STORE";//specifing the name of dataBase
        Connection connection = connectDatabase7.getConnection();

        try{

            ResultSet rs6 = connection.createStatement().executeQuery("SELECT productName,quantity,subTotal,date FROM purchasehistory WHERE customerName='" +loginParent.curentCustomerEmail+ "'");

            while(rs6.next()){
                obList.add(new Transactions( rs6.getString("productName"), rs6.getString("quantity"), rs6.getString("subTotal"), rs6.getString("date")));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        col_ProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_subTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        transactionTable.setItems(obList);

    }

    public void removeAllRows(){
        for ( int i = 0; i<transactionTable.getItems().size(); i++) {
            transactionTable.getItems().clear();
        }
    }
    public void switchtoStaffMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("staffMain.fxml"));
        viewstranactions.getChildren().setAll(pane);
    }

    public void switchtoJeffMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Jeffsmain.fxml"));
        viewstranactions.getChildren().setAll(pane);
    }

    public void switchtoCustomerMain() throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("customerMain.fxml"));
        viewstranactions.getChildren().setAll(pane);
    }

}
