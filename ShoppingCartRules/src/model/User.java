package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class User {

    private String userId;
    private String userName;
    private final List<Item> subscribedItems;
    private UserType userType;

    public User(String userName, UserType userType) {
        this.userId= UUID.randomUUID().toString();
        subscribedItems= new ArrayList<>();
        this.userName= userName;
        this.userType= userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Item> getSubscribedItems() {
        return subscribedItems;
    }

    public void addSubscribedItem(Item subscribedItem) {
        this.subscribedItems.add(subscribedItem);
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
