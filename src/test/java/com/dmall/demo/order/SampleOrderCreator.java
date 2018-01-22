package com.dmall.demo.order;

import com.dmall.demo.order.domain.*;
import com.dmall.demo.order.domain.common.Address;
import com.dmall.demo.order.domain.delivery.DeliveryInfo;
import com.dmall.demo.order.domain.delivery.DeliveryMethod;
import com.dmall.demo.order.domain.delivery.Recipient;
import com.dmall.demo.order.domain.exception.TooManyItemsException;
import com.dmall.demo.order.domain.product.Price;
import com.dmall.demo.order.domain.product.Product;
import com.dmall.demo.order.domain.product.ProductType;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class SampleOrderCreator {

    public DmallOrder createDmallOrder() throws TooManyItemsException {
        Product product = new Product("DDD", ProductType.Book, new Price("Currency", 56.5));
        Customer customer = new Customer(UUID.randomUUID());
        DeliveryInfo deliveryInfo = new DeliveryInfo(DeliveryMethod.Fast, ZonedDateTime.now());
        Recipient recipient = new Recipient("Li Lei", "19090990000", new Address("Beijing", "Beijing", "Haidian", "huayuan1-1-1"));

        OrderItem orderItem = new OrderItem(product, 2);

        Payment payment = new Payment(PaymentType.ALIPAY);
        Invoice invoice = new Invoice("head", "tfn", "company full name");

        return new DmallOrder(customer, Arrays.asList(orderItem), deliveryInfo, recipient, payment, invoice);
    }
}
