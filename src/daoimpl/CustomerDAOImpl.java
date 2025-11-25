package daoimpl;

import dao.CustomerDAO;
import dbconnection.DBConnection;
import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void addCustomer(Customer c) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO customers(id, name, phone) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());

            ps.executeUpdate();
            System.out.println("Customer added!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM customers";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone")
                ));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
