package com.dmall.demo.order.domain;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderItem {
    public static int Maximum_Limit = 200;
    private final Product product;
    private final int amout;

    public OrderItem(Product product, int amout) {
        this.product = product;
        this.amout = amout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (amout != orderItem.amout) return false;
        return product.equals(orderItem.product);
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + amout;
        return result;
    }
}
