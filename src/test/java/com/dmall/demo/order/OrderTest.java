package com.dmall.demo.order;

import com.dmall.demo.order.domain.*;
import com.dmall.demo.order.domain.exception.TooManyItemsException;
import com.dmall.demo.order.infrastructure.OrderInMemoryRepositoryImpl;
import com.dmall.demo.order.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by xianjing on 10/01/2018.
 */
public class OrderTest {

    OrderRepository orderRepository;
    @Before
    public void setUp() throws Exception {
        orderRepository = new OrderInMemoryRepositoryImpl();
    }

    @Test
    public void should_create_order() throws TooManyItemsException {

        SampleOrderCreator sampleOrderCreator = new SampleOrderCreator();
        DmallOrder dmallOrder = sampleOrderCreator.createDmallOrder();

        orderRepository.add(dmallOrder);
        DmallOrder acutalOrder = orderRepository.get(dmallOrder.getId());

        assertEquals(dmallOrder, acutalOrder);
        assertEquals(dmallOrder.getCustomer(), acutalOrder.getCustomer());
        assertEquals(dmallOrder.getInvoice(), acutalOrder.getInvoice());
        assertEquals(dmallOrder.getDeliveryInfo(), acutalOrder.getDeliveryInfo());
    }

    @Test(expected = TooManyItemsException.class)
    public void should_not_create_order_given_total_items_exceeds_limit() throws TooManyItemsException {

        OrderItem orderItem = new OrderItem(null, 1);
        ArrayList<OrderItem> orderItems = GivenMaximumOrderItems(orderItem);

        DmallOrder dmallOrder = new DmallOrder(null, orderItems,
                null, null, null, null );
    }

    private ArrayList<OrderItem> GivenMaximumOrderItems(OrderItem orderItem) {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for(int i =0; i<= OrderItem.Maximum_Limit; i++){
            orderItems.add(orderItem);
        }
        return orderItems;
    }

}
