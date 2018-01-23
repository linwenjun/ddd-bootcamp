package com.dmall.demo.order.apis.dtos;


import java.util.List;
import java.util.UUID;

public  class OrderDTO {
    private  UUID oId;
    private String contact;
    private  List<OrderItemDTO> items;
    private  String userId;

    public OrderDTO(String contact, List<OrderItemDTO> items, String userId) {
        this.contact = contact;
        this.items = items;
        this.userId = userId;
        this.oId = UUID.randomUUID();
    }

    public String getUserId() {
        return userId;
    }

    public String getContact(){
        return contact;
    }

    public List<OrderItemDTO> getItems(){
        return this.items;
    }

    public UUID getoId() {
        return oId;
    }
}
