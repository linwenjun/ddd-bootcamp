package com.dmall.demo.order;

import com.dmall.demo.order.domain.DmallOrder;
import com.dmall.demo.order.infrastructure.OrderInMemoryRepositoryImpl;
import com.dmall.demo.order.domain.OrderStatus;
import com.dmall.demo.order.domain.exception.TooManyItemsException;
import com.dmall.demo.order.event.PaymentCommand;
import com.dmall.demo.order.repository.OrderRepository;
import com.dmall.demo.order.service.OrderService;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderServiceTest {

    OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
        orderRepository = new OrderInMemoryRepositoryImpl();
    }

    @Test
    public void should_move_status_lock_inventory_and_record_payment_when_order_is_paid() throws TooManyItemsException { //request for good name
        SampleOrderCreator sampleOrderCreator = new SampleOrderCreator();
        DmallOrder dmallOrder = sampleOrderCreator.createDmallOrder();
        orderRepository.add(dmallOrder);

        UUID paymentId = UUID.randomUUID();
        PaymentCommand paymentCommand = new PaymentCommand(dmallOrder.getId(), paymentId,200);
        OrderService orderService = new OrderService(orderRepository);

        orderService.receivePayment(paymentCommand);

        DmallOrder actualOrder = orderRepository.get(dmallOrder.getId());
        assertEquals(actualOrder.getStatus(), OrderStatus.PAID);
    }
}
