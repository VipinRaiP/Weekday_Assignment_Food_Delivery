package com.company.util;

import com.company.models.QueuedOrder;

public class Logger {
    public static void logDeniedOrder(QueuedOrder queuedOrder){
        System.out.println("Order "+queuedOrder.getOrderId()+" is denied because the restaurant cannot accommodate it.");
    }

    public static void logOrderEstimatedTime(QueuedOrder queuedOrder,Float estimatedTime){
        System.out.println("Order "+queuedOrder.getOrderId()+" will get delivered in "+estimatedTime+" minutes");
    }
}
