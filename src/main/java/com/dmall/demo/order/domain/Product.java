package com.dmall.demo.order.domain;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Product {
    private final String name;
    private final ProductType book;
    private final Price price;

    public Product(String name, ProductType book, Price price) {
        this.name = name;
        this.book = book;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (book != product.book) return false;
        return price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + book.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
