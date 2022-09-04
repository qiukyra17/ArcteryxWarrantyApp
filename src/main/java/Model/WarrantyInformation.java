package Model;

public class WarrantyInformation {

    public int customerID;
    public int brandID;
    public String productType;
    public String productIssue;

    public String status;

    public WarrantyInformation(int customerID, int brandID, String productType, String productIssue, String status) {
        this.customerID = customerID;
        this.brandID = brandID;
        this.productType = productType;
        this.productIssue = productIssue;
        this.status = status;
    }

    @Override
    public String toString() {
        return "WarrantyInformation{" +
                "customerID=" + customerID +
                ", brandID=" + brandID +
                ", productType='" + productType + '\'' +
                ", productIssue='" + productIssue + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

