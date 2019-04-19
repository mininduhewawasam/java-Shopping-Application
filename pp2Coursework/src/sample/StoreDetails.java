package sample;


public class StoreDetails {


    private String productName;
    private String productCode;
    private String productSize;
    private String productPrice;

    public StoreDetails(String productName) {
        this.productName=productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public StoreDetails(String productName, String productCode, String productSize, String productPrice) {
        this.productName = productName;
        this.productCode = productCode;
        this.productSize = productSize;
        this.productPrice = productPrice;
    }

    public String getItemName() {
        return productName;
    }

}