package Service;

import DAO.UpdateRepo;

public class Update {
    UpdateRepo ur;

    public Update() {
        ur = new UpdateRepo();
    }

    public void updateWarrantyInformation(String status,int warrantyNo){
        ur.updateWarrantyInformation(status,warrantyNo);
    }

}
