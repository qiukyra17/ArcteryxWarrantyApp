package Service;

import DAO.RequestRepo;
import Model.CustomerInformation;
import Model.WarrantyInformation;
import org.apache.log4j.Logger;

public class Request {
    RequestRepo rr;

    public Request() {
        rr = new RequestRepo();
        Logger logger = Logger.getLogger(Request.class);
        logger.info("New Warranty Created");
    }

    public void addCustomerInformation(String name, String email, String phone) {
        CustomerInformation exisitingInformation = rr.getCustomerByEmail(email);
        if (exisitingInformation == null) {
            CustomerInformation newCustomerInformation = new CustomerInformation(name, email, phone);
            rr.addCustomerInformation(newCustomerInformation);
        } else {

            //do nothing
        }
    }

    public WarrantyInformation addWarrantyInformation(int customerID, int brandID, String productType, String productIssue,
                                                      String status) {
        WarrantyInformation newWarrantyInformation = new WarrantyInformation(customerID, brandID, productType,
                productIssue, status);
        rr.addWarrantyInformation(newWarrantyInformation);
        return newWarrantyInformation;

    }

    public int getCustomerIdByEmail(String String) {
        return rr.getCustomerIdByEmail(String);
    }

    public int getWarrantyIDFromWarrantyInfo(int customerID, int brandID, String productType, String productIssue,
                                             String status) {
        return rr.getWarrantyIDFromWarrantyInfo(customerID, brandID, productType, productIssue, status);
    }
}



