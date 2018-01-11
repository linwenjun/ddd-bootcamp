package com.dmall.demo.order.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderPaidEvent {
    private final UUID orderId;
    private final UUID paymentId;
    private final ZonedDateTime eventCreatedTime;

    public OrderPaidEvent(UUID orderId, UUID paymentId) {
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.eventCreatedTime = ZonedDateTime.now();
    }
}
