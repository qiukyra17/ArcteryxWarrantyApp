package Service;

import DAO.StatusRepo;
import org.apache.log4j.Logger;

public class Status {

    StatusRepo sr;

    public Status(){
        sr = new StatusRepo();
        Logger logger = Logger.getLogger(Status.class);
        logger.info("Status Search");
    }

    public String getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
        return sr.getAllWarrantyInfoByWarrantyNo(warrantyNo);
    }
}



