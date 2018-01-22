package com.dmall.demo.order.domain;

import com.dmall.demo.order.domain.delivery.DeliveryInfo;
import com.dmall.demo.order.domain.delivery.Recipient;
import com.dmall.demo.order.domain.exception.TooManyItemsException;
import com.dmall.demo.order.event.PaymentCommand;

import java.util.List;
import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class DmallOrder {
    private final Customer customer;
    private final List<OrderItem> orderItems;
    private final DeliveryInfo deliveryInfo;
    private final Recipient recipient;
    private final Payment payment;
    private final Invoice invoice;
    private final UUID id;
    private OrderStatus status;

    public DmallOrder(Customer customer, List<OrderItem> orderItems, DeliveryInfo deliveryInfo, Recipient recipient, Payment payment, Invoice invoice) throws TooManyItemsException {
        if(orderItems.size() > OrderItem.Maximum_Limit){
            throw new TooManyItemsException();
        }
        this.customer = customer;
        this.orderItems = orderItems;
        this.deliveryInfo = deliveryInfo;
        this.recipient = recipient;
        this.payment = payment;
        this.invoice = invoice;
        this.id = UUID.randomUUID();
        this.status = OrderStatus.CREATED;
    }

    public UUID getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public DeliveryInfo getDeliveryInfo() {
        return this.deliveryInfo;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void onPaid(PaymentCommand event) {
        this.status = OrderStatus.PAID;
        this.payment.record(event.getPaymentId());
    }
}
