package com.dmall.demo.order.domain;

import com.dmall.demo.order.domain.PaymentType;

import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Payment {
    private final PaymentType paymentType;
    private UUID paymentId;

    public Payment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void record(UUID paymentId) {
        this.paymentId = paymentId;
    }
}
