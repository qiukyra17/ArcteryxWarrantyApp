package DAO;

import Model.CustomerInformation;
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
            PreparedStatement statement = conn.prepareStatement("insert into Request(name, email, phone) values (?,?," +
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

}
