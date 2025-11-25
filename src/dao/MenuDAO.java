package dao;

import models.MenuItem;

import java.util.List;

public interface MenuDAO {
    void addMenuItem(MenuItem item);
    List<MenuItem> getAllMenuItems();
}
