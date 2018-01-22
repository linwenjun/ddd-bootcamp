package com.dmall.demo.order.domain.product;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Price {
    private final String currency;
    private final double amount;

    public Price(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (Double.compare(price.amount, amount) != 0) return false;
        return currency.equals(price.currency);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
