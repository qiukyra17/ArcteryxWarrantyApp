package DAO;

import Model.CustomerInformation;
import Model.WarrantyInformation;
import Service.Request;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestRepo {

    Connection conn = ConnectionUtil.getConnection();

    // function to add aka INSERT

    public void addCustomerInformation (CustomerInformation ci){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into CustomerInformation(name, email, phone) " +
                    "values " +
                    "(?," +
                    "?," +
                    "?)");
            statement.setString(1,ci.getName());
            statement.setString(2,ci.getEmail());
            statement.setInt(3,ci.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public CustomerInformation getCustomerByEmail(String email){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from CustomerInformation where email = ?");
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                CustomerInformation ci = new CustomerInformation(rs.getString("name"), rs.getString("email"),
                        rs.getInt("phone"));
                return ci;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addWarrantyInformation(WarrantyInformation wi) {
        try {
            PreparedStatement statement =
                    conn.prepareStatement("insert into WarrantyInformation (insert into WarrantyInformation " +
                            "(customerID, brandID, productType, productIssue)values(?,?,?,?)");
            statement.setInt(1, wi.customerID);
            statement.setInt(2, wi.brandID);
            statement.setString(3, wi.productType);
            statement.setString(4, wi.productIssue);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public WarrantyInformation getWarrantyByCustomerID(int customerID) {
        try {
            PreparedStatement statement = conn.prepareStatement("select * from WarrantyInformation where customerID " +
                    "=?");
            statement.setInt(1, customerID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                WarrantyInformation wi = new WarrantyInformation(rs.getInt("customerID"),rs.getInt("brandID"),
                        rs.getString("productType"),rs.getString("productIssue"));
                return wi;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
