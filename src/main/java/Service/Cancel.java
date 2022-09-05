package Service;

import DAO.CancelRepo;

public class Cancel {
    CancelRepo cr;

    public Cancel(){
        cr = new CancelRepo();
    }

    public void deleteWarrantyInformation(int warrantyNo) {
        cr.deleteWarrantyRequestByWarrantyNo(warrantyNo);
    }

}
