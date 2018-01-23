package com.dmall.demo.order.apis.dtos;

/**
 * Created by xianjing on 23/01/2018.
 */
public class OrderItemDTO {

    private  String product;
    private int number;
    private int price;

    public OrderItemDTO(String product, int number, int price) {

        this.product = product;
        this.number = number;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }
}
