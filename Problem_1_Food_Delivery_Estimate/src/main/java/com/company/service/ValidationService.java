package com.company.service;

import com.company.models.Restaurant;

import java.util.List;

public interface ValidationService {
    public  Boolean isMealValid(List<String> meals, Restaurant restaurant);
    public Boolean isSlotRequestValid(Integer requiredSlots, Restaurant restaurant);
}
