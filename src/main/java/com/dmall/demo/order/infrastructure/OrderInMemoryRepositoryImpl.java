package com.dmall.demo.order.infrastructure;

import com.dmall.demo.order.domain.DmallOrder;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public class OrderInMemoryRepositoryImpl implements OrderRepository{
    private ArrayList<DmallOrder> orders = new ArrayList<DmallOrder>();

    public void add(DmallOrder dmallOrder) {
        orders.add(dmallOrder);
    }

    public DmallOrder get(UUID id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findAny().orElse(null);
    }
}
