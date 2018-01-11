package com.dmall.demo.order.service;

import com.dmall.demo.order.domain.DmallOrder;
import com.dmall.demo.order.event.AlipayEvent;
import com.dmall.demo.order.infrastructure.OrderInMemoryRepositoryImpl;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderService {
    private final OrderInMemoryRepositoryImpl orderRepository;

    public OrderService(OrderInMemoryRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void onAlipay(AlipayEvent alipayEvent) {
        DmallOrder dmallOrder = orderRepository.get(alipayEvent.getOrderId());
        dmallOrder.onPaid(alipayEvent);
    }
}
