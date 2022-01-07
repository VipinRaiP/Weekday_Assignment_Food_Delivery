package com.company.service.impl;

import com.company.models.PickedOrder;
import com.company.models.QueuedOrder;
import com.company.models.Restaurant;
import com.company.repository.impl.PickedOrderRepositoryImpl;
import com.company.service.OrderService;
import com.company.repository.PickedOrderRepository;
import com.company.service.SlotService;
import com.company.service.TimeService;
import com.company.service.ValidationService;
import com.company.util.Logger;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private SlotService slotService;
    private ValidationService validationService;
    private TimeService timeService;

    public OrderServiceImpl(){
        this.slotService = new SlotServiceImpl();
        this.validationService = new ValidationServiceImpl();
        this.timeService = new TimeServiceImpl();
    }

    @Override
    public void estimateDeliveryTime(QueuedOrder queuedOrder, Restaurant restaurant) {
        // Check if meal is served by restaurant
        if(!this.validationService.isMealValid(queuedOrder.getMeals(), restaurant)){
            Logger.logDeniedOrder(queuedOrder);
            return;
        }

        Integer requiredSlots = this.slotService.getRequiredSlots(queuedOrder, restaurant);

        // Check if required slots are within max slots available in restaurant
        if(!validationService.isSlotRequestValid(requiredSlots, restaurant)){
            Logger.logDeniedOrder(queuedOrder);
            return;
        }

        timeService.calculateEstimatedTime(queuedOrder, requiredSlots, restaurant);
    }
}
