package com.dmall.demo.order.domain.delivery;

import java.time.ZonedDateTime;

/**
 * Created by xianjing on 11/01/2018.
 */
public class DeliveryInfo {
    private final DeliveryMethod deliveryMethod;
    private final ZonedDateTime deliveryTime;

    public DeliveryInfo(DeliveryMethod deliveryMethod, ZonedDateTime deliveryTime) {
        this.deliveryMethod = deliveryMethod;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryInfo that = (DeliveryInfo) o;

        if (deliveryMethod != that.deliveryMethod) return false;
        return deliveryTime.equals(that.deliveryTime);
    }

    @Override
    public int hashCode() {
        int result = deliveryMethod.hashCode();
        result = 31 * result + deliveryTime.hashCode();
        return result;
    }
}
