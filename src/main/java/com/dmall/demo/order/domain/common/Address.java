package com.dmall.demo.order.domain.common;

/**
 * Created by xianjing on 11/01/2018.
 */
public class Address {
    private final String province;
    private final String city;
    private final String district;
    private final String building;

    public Address(String province, String city, String district, String building) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.building = building;
    }
}
