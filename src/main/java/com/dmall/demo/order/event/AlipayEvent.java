package com.dmall.demo.order.event;

import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class AlipayEvent extends DmallDomainEvent {
    private final UUID orderId;
    private final UUID paymentId;
    private final double amount;

    public AlipayEvent(UUID orderId, UUID paymentId, double amount) {
        super();
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getPaymentId() {
        return paymentId;
    }
}
