package DAO;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusRepo {
    Connection conn = ConnectionUtil.getConnection();
    // get warranty info

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
                return "Customer's Name: " + customerName + " - Warranty Number: " + warrantyID + " = Brand: " + brand_name +
                        " - Product Type: " + productTpe + " - Product Issue: " + productIssue + " - Current Status: " + status;
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

