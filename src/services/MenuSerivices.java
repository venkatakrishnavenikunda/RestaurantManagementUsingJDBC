package services;

import dao.MenuDAO;
import daoimpl.MenuDAOImpl;
import interfaces.IMenuService;
import models.MenuItem;

import java.util.List;

public class MenuSerivices implements IMenuService {
    private final MenuDAO dao = new MenuDAOImpl();

    @Override
    public void addMenuItem(MenuItem item) {
        dao.addMenuItem(item);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return dao.getAllMenuItems();
    }
}
