package Service;

import DAO.StatusRepo;

public class Status {

    //lets try to get warranty information back
    StatusRepo sr;

    public String getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
        return sr.getAllWarrantyInfoByWarrantyNo(warrantyNo);
    }
}



