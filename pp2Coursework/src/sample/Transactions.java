package sample;

public class Transactions {
    private String customerName;
    private String productName;
    private String quantity;
    private String subTotal;
    private String date;

    public Transactions(String productName, String quantity, String subTotal, String date) {
        this.productName = productName;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public Transactions(String customerName, String productName, String quantity, String subTotal, String date) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.date = date;
    }





}
