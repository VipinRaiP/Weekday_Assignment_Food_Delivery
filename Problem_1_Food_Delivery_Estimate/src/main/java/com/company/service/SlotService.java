package com.company.service;

import com.company.models.QueuedOrder;
import com.company.models.Restaurant;

public interface SlotService {
    public Integer getRequiredSlots(QueuedOrder queuedOrder, Restaurant restaurant);
    public  Boolean occupySlots(Integer slots, Restaurant restaurant);
    public  Boolean releaseSlots(Integer freeSlots, Restaurant restaurant);
    public  Boolean isSlotAvailable(Integer requiredSlots, Restaurant restaurant);
}
