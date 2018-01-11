package com.dmall.demo.order.domain;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Invoice {
    private final String head;
    private final String tfn;
    private final String drawer;

    public Invoice(String head, String tfn, String drawer) {
        this.head = head;
        this.tfn = tfn;
        this.drawer = drawer;
    }
}
