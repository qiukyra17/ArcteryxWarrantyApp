package Service;

import DAO.RequestRepo;
import Model.CustomerInformation;

public class Request {
    RequestRepo rr;
    Status s;

    public Request(){
        rr = new RequestRepo();
        s = new Status();
    };

    public void addCustomerInformation (String name, String email, int phone){
        CustomerInformation exisitingInformation = rr.getCustomerByEmail(email);
        if(exisitingInformation == null){
            CustomerInformation newCustomerInformation = new CustomerInformation(name,email,phone);
            rr.addCustomerInformation(newCustomerInformation);
        } else {

            //do nothing
        }
    }


}
