package models;

public class MenuItem {
    private int id;
    private String name;
    private double price;
    private String category;

    public MenuItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }

    public void setName(String n) {
        this.name = n;
    }
    public void setPrice(double p) {
        this.price = p;
    }
    public void setCategory(String c) {
        this.category = c;
    }

    @Override
    public String toString() {
        return "[ID:" + id + "] " + name + " | Rs " + price + " | " + category;
    }
}
