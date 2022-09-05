package DAO;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public String getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM warrantyStatusLog WHERE warrantyID =?");
            statement.setInt(1, warrantyNo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String customerName = rs.getString("name");
                int warrantyID = rs.getInt("warrantyid");
                String brand_name = rs.getString("brand_name");
                String productTpe = rs.getString("productType");
                String productIssue = rs.getString(
                        "productIssue");
                String status = rs.getString("status");
                return "Customer's Name: "+ customerName +" - Warranty Number: " + warrantyID + " = Brand: " + brand_name +
                        " - Product Type: " + productTpe + " - Product Issue: " + productIssue + " - Current Status: " + status;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
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

