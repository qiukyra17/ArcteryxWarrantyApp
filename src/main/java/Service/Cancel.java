package Service;

import DAO.CancelRepo;

public class Cancel {
    CancelRepo cr;

    public void deleteWarrantyInformation(int warrantyNo) {
        cr.deleteWarrantyRequestByWarrantyNo(warrantyNo);
    }

}
