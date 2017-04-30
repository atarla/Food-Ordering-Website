/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodItem;

import java.io.Serializable;

/**
 *
 * @author Pooja
 */
public class fooditem implements Serializable{
    private String item_id ;
    private String item_name;
    private String description;
    private String posted_by;
    private String address;
    private Integer item_price;


    public fooditem() {
    }

    public fooditem(String item_id, String item_name, String description, String posted_by, String address, Integer item_price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.description = description;
        this.posted_by = posted_by;
        this.address = address;
        this.item_price = item_price;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(String posted_by) {
        this.posted_by = posted_by;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getItem_price() {
        return item_price;
    }

    public void setItem_price(Integer item_price) {
        this.item_price = item_price;
    }
}
