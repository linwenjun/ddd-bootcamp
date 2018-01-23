package com.dmall.demo.order.apis;


import com.dmall.demo.order.apis.dtos.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {


    List<OrderItemDTO> items = Arrays.asList(new OrderItemDTO("book", 1, 20));
    private List<OrderDTO> orders = Arrays.asList(new OrderDTO("o001", items, "1" ));

    public OrderController() throws ParseException {

    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDTO> getOrders() {
        return orders;
    }

    @RequestMapping(value = "{oId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OrderDTO> getOrdersByUser(@PathVariable("oId") String oId){
        return orders.stream().filter(o -> o.getoId().toString().equals(oId)).collect(Collectors.toList());
    }
}
