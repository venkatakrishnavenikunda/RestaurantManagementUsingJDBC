package daoimpl;

import dao.MenuDAO;
import dbconnection.DBConnection;
import models.MenuItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {
    @Override

    public void addMenuItem(MenuItem item) {
        String sql = "INSERT INTO menu_items(id, item_name, price, category) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getCategory());

            ps.executeUpdate();
            System.out.println("Menu item added!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new MenuItem(
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getDouble("price"),
                        rs.getString("category")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
