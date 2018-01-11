package com.dmall.demo.order.domain;

import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Customer {
    private final UUID uuid;

    public Customer(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return uuid.equals(customer.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
