package com.dmall.demo.order.repository;

import com.dmall.demo.order.domain.DmallOrder;

import java.util.UUID;

/**
 * Created by xianjing on 11/01/2018.
 */
public interface OrderRepository {
    void add(DmallOrder dmallOrder);
    DmallOrder get(UUID id);
}
