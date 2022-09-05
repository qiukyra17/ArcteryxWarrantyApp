package DAO;

import Model.CustomerInformation;
import Model.WarrantyInformation;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestRepo {

    Connection conn = ConnectionUtil.getConnection();

    public void addCustomerInformation(CustomerInformation ci) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into CustomerInformation(name, email, phone) " +
                    "values " +
                    "(?," +
                    "?," +
                    "?)");
            statement.setString(1, ci.getName());
            statement.setString(2, ci.getEmail());
            statement.setString(3, (ci.getPhone()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CustomerInformation getCustomerByEmail(String email) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from CustomerInformation where email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CustomerInformation ci = new CustomerInformation(rs.getString("name"), rs.getString("email"),
                        rs.getString("phone"));
                return ci;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Retrieve CustomerID and Auto Insert

    public int getCustomerIdByEmail(String email) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT ID from customerinformation WHERE Email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int customerID = rs.getInt("ID");
                return customerID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addWarrantyInformation(WarrantyInformation wi) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement("insert into warrantyinformation (customerID,brandID,productType,productIssue,status) values (?,?,?,?,?)");
            statement.setInt(1, wi.customerID);
            statement.setInt(2, wi.brandID);
            statement.setString(3, wi.productType);
            statement.setString(4, wi.productIssue);
            statement.setString(5, wi.status);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getWarrantyIDFromWarrantyInfo(int customerID, int brandID, String productType, String productIssue,
                                             String status) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement("SELECT warrantyID FROM warrantyinformation WHERE customerID = ? AND " +
                            "brandID = ? AND productType = ? AND productIssue =? AND status =?");
            statement.setInt(1, customerID);
            statement.setInt(2, brandID);
            statement.setString(3, productType);
            statement.setString(4, productIssue);
            statement.setString(5, status);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int warrantyID = rs.getInt("warrantyID");
                return warrantyID;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

