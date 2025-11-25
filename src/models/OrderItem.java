package models;

public class OrderItem {
    private int menuId;
    private String name;
    private double price;
    private int qty;

    public OrderItem(int menuId, String name, double price, int qty) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getMenuId() {
        return menuId;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int q) {
        this.qty = q;
    }

    public double getTotal() {
        return price * qty;
    }
}
