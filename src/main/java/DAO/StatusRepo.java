package DAO;

import Model.WarrantyInformation;
import Service.Status;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepo {
    Connection conn = ConnectionUtil.getConnection();

//    public List<WarrantyInformation> getStatusByWarrantyNo(int warrantyNo) {
//        List<WarrantyInformation> status = new ArrayList<>();
//        try{
//            PreparedStatement statement = conn.prepareStatement(" Select * from WarrantyInformation where " +
//                    "warrantyID=?");
//            statement.setInt(1,warrantyNo);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                WarrantyInformation loadStatus = new WarrantyInformation(rs.getInt("customerID"), rs.getInt("brandID")
//                        ,rs.getString("productType"),rs.getString("productIssue"));
//                status.add(loadStatus);
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return status;
//    }
}
