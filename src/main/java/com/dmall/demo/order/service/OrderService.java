package com.dmall.demo.order.service;

import com.dmall.demo.order.domain.DmallOrder;
import com.dmall.demo.order.event.PaymentCommand;
import com.dmall.demo.order.repository.OrderRepository;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void receivePayment(PaymentCommand paymentCommand) { //request for good name
        DmallOrder dmallOrder = orderRepository.get(paymentCommand.getOrderId());
        dmallOrder.onPaid(paymentCommand);
    }

}
