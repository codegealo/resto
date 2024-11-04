package com.sample.resto.model.constant;

public class Constants {

    public static String ORDER_NOT_FOUND = "order not found";
    public static String CUSTOMER_NOT_FOUND = "customer not found";

    public enum OrderStatus{
        NEW,
        DONE,
        CANCELED
    }
}
