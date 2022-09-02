package DAO;

import Model.WarrantyInformation;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepo {
    Connection conn = ConnectionUtil.getConnection();
    // get warranty info

//    public List<WarrantyInformation> getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
//        List<WarrantyInformation> WarrantyInfo = new ArrayList<>();
//        try{
//            PreparedStatement statement = conn.prepareStatement("Select* from warrantyinformation where warrantyID=?");
//            statement.setInt(1,warrantyNo);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                WarrantyInformation loadWarranty = new WarrantyInformation(rs.getInt("customerID"),rs.getInt("brandID"),rs.getString("productType"),rs.getString("productIssue"));
//                WarrantyInfo.add(loadWarranty);
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        if (WarrantyInfo.size()==0){
//            return null;
//        } else return WarrantyInfo;
//    }
public List<WarrantyInformation> getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
    List<WarrantyInformation> WarrantyInfo = new ArrayList<>();
    try{
        PreparedStatement statement = conn.prepareStatement("Select* from warrantyinformation where warrantyID=?");
        statement.setInt(1,warrantyNo);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            WarrantyInformation loadWarranty = new WarrantyInformation(rs.getInt("customerID"),rs.getInt("brandID"),rs.getString("productType"),rs.getString("productIssue"));
            WarrantyInfo.add(loadWarranty);
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    if (WarrantyInfo.size()==0){
        return null;
    } else return WarrantyInfo;
}


}


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

