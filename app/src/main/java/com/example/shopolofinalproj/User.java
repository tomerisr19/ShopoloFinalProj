package com.example.shopolofinalproj;

import java.util.ArrayList;

public class User {

    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private ArrayList<Integer> orderIds = new ArrayList<>();

    public User(){}

    public String getUserId() {
        return userId;
    }

    public User(String userId, String email, String password, String firstName, String lastName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderIds = new ArrayList<Integer>();
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(ArrayList<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public void addOrder(int orderId){
        this.orderIds.add(orderId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
