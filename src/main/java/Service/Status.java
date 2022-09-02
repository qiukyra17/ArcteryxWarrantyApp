package Service;

import DAO.RequestRepo;
import DAO.StatusRepo;
import Model.WarrantyInformation;

import java.util.List;

public class Status {

    //lets try to get warranty information back
    Request r;
    StatusRepo sr;
    public List<WarrantyInformation> getAllWarrantyInfoByWarrantyNo(int warrantyNo) {

        return sr.getAllWarrantyInfoByWarrantyNo(warrantyNo);

    }
//public List<WarrantyInformation> getAllWarrantyInfoByWarrantyNo(warrantyNo){
//    return r.getAllWarrantyInfoByWarrantyNo(warrantyNo);
}
//    StatusRepo sr;
//    Request r;
//    public Status (){
//        sr = new StatusRepo();
//        r = new Request();
//    };
//
//    public List<WarrantyInformation> getStatus(int warrantyNo) {
//      return sr.getStatusByWarrantyNo(warrantyNo);
//    };




