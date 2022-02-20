package com.example.shopolofinalproj;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private int price;
    private boolean isAvailable;
    private String Url;

    public Product(String id, String name, int price, boolean isAvailable,String Url){

        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.Url = Url;
    }

    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getUrl() {
        return Url;
    }

    public Product setUrl(String url) {
        Url = url;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Product setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", Url='" + Url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() && isAvailable() == product.isAvailable() && getId().equals(product.getId()) && getName().equals(product.getName());
    }


    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }
    };
}
