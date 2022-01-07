package com.company;

import com.company.models.QueuedOrder;
import com.company.models.Restaurant;
import com.company.service.OrderService;
import com.company.service.impl.OrderServiceImpl;
import com.company.util.InputParser;

import java.util.HashMap;
import java.util.List;

public class Main {
    private static OrderService orderService;

    public static void main(String[] args) throws Exception{
	// write your code here
        orderService = new OrderServiceImpl();

        Restaurant restaurant = new Restaurant();
        restaurant.setAvailableSlots(7);
        restaurant.setTotalSlots(7);
        restaurant.setDeliveryTimeInMinutesPerKM(8);
        restaurant.setMaxEstimatedTimeInMinutes(150);

        restaurant.addToItemSlotMap("M",2);
        restaurant.addToItemSlotMap("A",1);

        restaurant.addToItemTimeMap("M",29);
        restaurant.addToItemTimeMap("A",17);

        List<QueuedOrder> queuedOrderList = InputParser.parseOrdersFromFile("/home/vipin/Documents/Weekday_Assignment_Food_Delivery/Problem_1_Food_Delivery_Estimate/input.txt");
        for(QueuedOrder queuedOrder:queuedOrderList) {
            orderService.estimateDeliveryTime(queuedOrder,restaurant);
        }
    }
}
