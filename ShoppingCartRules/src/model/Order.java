package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String orderId;
    private List<Item> items;

    private double totalPrice;

    private User user;

    private String shippingOption;

    public Order(User user) {
        this.orderId= UUID.randomUUID().toString();
        items= new ArrayList<>();
        totalPrice=0;
        this.user=user;
    }

    public void addItem(Item item) {
        items.add(item);
        totalPrice+=item.getPrice();
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public String getShippingOption() {
        return shippingOption;
    }

    public void setShippingOption(String shippingOption) {
        this.shippingOption = shippingOption;
    }
}
