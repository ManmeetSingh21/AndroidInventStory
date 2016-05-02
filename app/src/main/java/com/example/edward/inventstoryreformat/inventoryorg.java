package com.example.edward.inventstoryreformat;

/**
 * Created by Andrew on 5/2/2016.
 */
public class inventoryorg {
    int id;
    String itemname, item_price, item_quantity, item_description;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setItemname(String itemname) { this.itemname = itemname;}
    public String getItemname() {
        return itemname;
    }

    public void setPrice(String pricestr) {item_price = pricestr;}
    public String getPrice() {return this.item_price;}

    public void setQuantity(String quantitystr) {item_quantity = quantitystr;}
    public String getQuantity() {return this.item_quantity;}

    public void setDescription(String descriptionstr) {item_description = descriptionstr;}
    public String getDescription() {return this.item_description;}
}
