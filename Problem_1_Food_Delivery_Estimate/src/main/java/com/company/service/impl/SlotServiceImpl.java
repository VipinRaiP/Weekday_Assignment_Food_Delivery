package com.company.service.impl;

import com.company.models.QueuedOrder;
import com.company.models.Restaurant;
import com.company.service.SlotService;

public class SlotServiceImpl implements SlotService {

    @Override
    public Integer getRequiredSlots(QueuedOrder queuedOrder, Restaurant restaurant) {
        Integer requiredSlots = 0;

        for (String meal: queuedOrder.getMeals()){
            requiredSlots += restaurant.getItemSlotMap().getOrDefault(meal,0);
        }
        return requiredSlots;
    }

    @Override
    public Boolean occupySlots(Integer slots, Restaurant restaurant) {
        if(slots > restaurant.getAvailableSlots())
            return Boolean.FALSE;
        restaurant.setAvailableSlots(restaurant.getAvailableSlots()-slots);
        return Boolean.TRUE;
    }

    @Override
    public Boolean releaseSlots(Integer freeSlots, Restaurant restaurant) {
        restaurant.setAvailableSlots(restaurant.getAvailableSlots()+freeSlots);
        return Boolean.TRUE;
    }

    @Override
    public Boolean isSlotAvailable(Integer requiredSlots, Restaurant restaurant) {
        return requiredSlots <= restaurant.getAvailableSlots();
    }
}
