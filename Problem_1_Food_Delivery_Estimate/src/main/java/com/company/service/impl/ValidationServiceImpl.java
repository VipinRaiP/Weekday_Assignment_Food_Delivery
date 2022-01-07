package com.company.service.impl;

import com.company.models.Restaurant;
import com.company.service.ValidationService;

import java.util.List;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public Boolean isMealValid(List<String> meals, Restaurant restaurant) {
        // Check if a meal is served by restaurant
        for(String meal:meals){
            if(!restaurant.getItemSlotMap().containsKey(meal)){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean isSlotRequestValid(Integer requiredSlots, Restaurant restaurant) {
        // Check if required slots don't exceed max slots in restaurant
        return restaurant.getTotalSlots() >= requiredSlots;
    }
}
