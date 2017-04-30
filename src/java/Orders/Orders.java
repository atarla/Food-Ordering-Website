/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import java.io.Serializable;

/**
 *
 * @author anusha
 */
public class Orders implements Serializable {
    private String item_name;
    private String user_address;
    private String email;
    private Integer item_count;
    private Integer price;

    public Orders() {
    }

    public Orders(String item_name, String user_address, String email, Integer item_count, Integer price) {
        this.item_name = item_name;
        this.user_address = user_address;
        this.email = email;
        this.item_count = item_count;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
