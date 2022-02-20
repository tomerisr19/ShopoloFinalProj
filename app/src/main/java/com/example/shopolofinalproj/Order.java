package com.example.shopolofinalproj;

import java.util.ArrayList;

public class Order {
    private String date;
    private ArrayList<String> orderList = new ArrayList<>();


    public Order() {
    }

    public String getDate() {
        return date;
    }

    public Order setDate(String date) {
        this.date = date;
        return this;
    }

    public ArrayList<String> getOrderList() {
        return orderList;
    }

    public Order setOrderList(ArrayList<String> orderList) {
        this.orderList = orderList;
        return this;
    }
}
