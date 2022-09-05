package Service;

import DAO.RequestRepo;
import Model.CustomerInformation;
import Model.WarrantyInformation;

import java.math.BigInteger;

public class Request {
    RequestRepo rr;
    Status s;

    public Request() {
        rr = new RequestRepo();
        s = new Status();
    }

    ;

    public void addCustomerInformation(String name, String email, String phone) {
        CustomerInformation exisitingInformation = rr.getCustomerByEmail(email);
        if (exisitingInformation == null) {
            CustomerInformation newCustomerInformation = new CustomerInformation(name, email, phone);
            rr.addCustomerInformation(newCustomerInformation);
        } else {

            //do nothing
        }
    }

    //now ADD brand
    public void addWarrantyInformation(int customerID, int brandID, String productType, String productIssue,
                                       String status) {
        WarrantyInformation existingInformation = rr.getWarrantyByCustomerID(customerID);
        if (existingInformation == null) {
            WarrantyInformation newWarrantyInformation = new WarrantyInformation(customerID, brandID, productType,
                    productIssue,status);
            rr.addWarrantyInformation(newWarrantyInformation);
        } else {
            //do nothing
        }
    }

//    public List<WarrantyInformation> getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
//
//        return rr.getAllWarrantyInfoByWarrantyNo(warrantyNo);
//
//    }
}
