package Model;

public class ProductInformation {
    public int warrantyNo;
    public int customerID;
    public int brandID;
    public String productType;
    public String productIssue;

    public ProductInformation(int warrantyNo, int customerID, int brandID, String productType, String productIssue) {
        this.warrantyNo = warrantyNo;
        this.customerID = customerID;
        this.brandID = brandID;
        this.productType = productType;
        this.productIssue = productIssue;
    }

    @Override
    public String toString() {
        return "ProductInformation{" +
                "warrantyNo=" + warrantyNo +
                ", customerID=" + customerID +
                ", brandID=" + brandID +
                ", productType='" + productType + '\'' +
                ", productIssue='" + productIssue + '\'' +
                '}';
    }

    public int getWarrantyNo() {
        return warrantyNo;
    }

    public void setWarrantyNo(int warrantyNo) {
        this.warrantyNo = warrantyNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductIssue() {
        return productIssue;
    }

    public void setProductIssue(String productIssue) {
        this.productIssue = productIssue;
    }
}
