package com.dmall.demo.order.infrastructure;

import com.dmall.demo.order.domain.DmallOrder;
import com.dmall.demo.order.repository.OrderRepository;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderInMemoryRepositoryImpl implements OrderRepository {
    private ArrayList<DmallOrder> orders = new ArrayList<DmallOrder>();

    @Override
    public void add(DmallOrder dmallOrder) {
        orders.add(dmallOrder);
    }

    @Override
    public DmallOrder get(UUID id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findAny().orElse(null);
    }
}
