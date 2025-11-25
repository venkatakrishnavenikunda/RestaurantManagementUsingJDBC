package interfaces;

import models.MenuItem;

import java.util.List;

public interface IMenuService {
    void addMenuItem(MenuItem item);
    List<MenuItem> getAllMenuItems();
}
