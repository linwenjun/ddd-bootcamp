package com.dmall.demo.order.domain;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Recipient {
    private final String name;
    private final String contactNumber;
    private final Address deliveryAddress;

    public Recipient(String name, String contactNumber, Address deliveryAddress) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipient recipient = (Recipient) o;

        if (!name.equals(recipient.name)) return false;
        if (!contactNumber.equals(recipient.contactNumber)) return false;
        return deliveryAddress.equals(recipient.deliveryAddress);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + contactNumber.hashCode();
        result = 31 * result + deliveryAddress.hashCode();
        return result;
    }
}
