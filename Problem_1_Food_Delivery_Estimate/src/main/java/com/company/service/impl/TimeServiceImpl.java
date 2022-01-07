package com.company.service.impl;

import com.company.models.PickedOrder;
import com.company.models.QueuedOrder;
import com.company.models.Restaurant;
import com.company.repository.PickedOrderRepository;
import com.company.repository.impl.PickedOrderRepositoryImpl;
import com.company.service.SlotService;
import com.company.service.TimeService;
import com.company.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class TimeServiceImpl implements TimeService {

    private SlotService slotService;
    private PickedOrderRepository pickedOrderRepository;

    TimeServiceImpl(){
        this.slotService = new SlotServiceImpl();
        this.pickedOrderRepository = new PickedOrderRepositoryImpl();
    }

    @Override
    public void calculateEstimatedTime(QueuedOrder queuedOrder, Integer requiredSlots, Restaurant restaurant) {

        Float totalEstimatedTime = 0f;

        // Calculate wait time
        List<PickedOrder> tempPickedOrder = new ArrayList<>();
        Float waitTime = 0f;
        if(!this.slotService.isSlotAvailable(requiredSlots,restaurant)){
            Integer requiredSlotsToBeFreed = requiredSlots - restaurant.getAvailableSlots();
            Integer freedSlots = 0;

            while(freedSlots < requiredSlotsToBeFreed && !this.pickedOrderRepository.isPickedOrdersEmpty()){
                PickedOrder pickedOrder = this.pickedOrderRepository.removePickedOrder();
                freedSlots += pickedOrder.getOccupiedSlots();
                this.slotService.releaseSlots(pickedOrder.getOccupiedSlots(),restaurant);
                tempPickedOrder.add(pickedOrder);
                waitTime = Math.max(waitTime,pickedOrder.getEstimatedTime());
            }
        }

        totalEstimatedTime += waitTime;

        // Calculate time required to prepare order
        totalEstimatedTime += getExecutionTime(queuedOrder,restaurant);

        // Calculate time to deliver the order
        totalEstimatedTime += getDeliveryTime(queuedOrder,restaurant);

        if(totalEstimatedTime > restaurant.getMaxEstimatedTimeInMinutes()){
            // If Estimated time greater than 2h 30 min
            for(PickedOrder pickedOrder:tempPickedOrder) {
                this.pickedOrderRepository.addPickedOrder(pickedOrder);
                this.slotService.occupySlots(pickedOrder.getOccupiedSlots(),restaurant);
            }
            Logger.logDeniedOrder(queuedOrder);
            return;
        }
        else{
            // Pick the order
            PickedOrder pickedOrder = new PickedOrder();
            pickedOrder.setEstimatedTime(totalEstimatedTime);
            pickedOrder.setQueuedOrder(queuedOrder);
            pickedOrder.setOccupiedSlots(requiredSlots);
            this.slotService.occupySlots(requiredSlots,restaurant);
            this.pickedOrderRepository.addPickedOrder(pickedOrder);
        }

        Logger.logOrderEstimatedTime(queuedOrder, totalEstimatedTime);
    }

    @Override
    public Float getExecutionTime(QueuedOrder queuedOrder, Restaurant restaurant) {
        Float requiredExecutionTime = 0f;
        // Required time to execute an order will be time required to cook the item with max time
        for(String meal: queuedOrder.getMeals()){
            requiredExecutionTime = Math.max(requiredExecutionTime,restaurant.getItemTimeMap().getOrDefault(meal,0));
        }
        return requiredExecutionTime;
    }

    @Override
    public Float getDeliveryTime(QueuedOrder queuedOrder, Restaurant restaurant) {
        return queuedOrder.getDistance() * restaurant.getDeliveryTimeInMinutesPerKM();
    }
}
