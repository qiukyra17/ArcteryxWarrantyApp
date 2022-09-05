package Service;

import DAO.RequestRepo;
import Model.CustomerInformation;
import Model.WarrantyInformation;

public class Request {
    RequestRepo rr;
    public Request() {
        rr = new RequestRepo();
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

    }}

