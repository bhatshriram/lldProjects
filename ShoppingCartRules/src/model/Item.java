package model;

import java.util.UUID;

public class Item {

    private String itemId;
    private String name;
    private ItemType itemType;
    private double price;

    public Item(String name, ItemType itemType, double price) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        this.itemType = itemType;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public double getPrice() {
        return price;
    }
}
