package com.company.service;

import com.company.models.QueuedOrder;
import com.company.models.Restaurant;

public interface TimeService {
    public void calculateEstimatedTime(QueuedOrder queuedOrder, Integer requiredSlots, Restaurant restaurant);
    public Float getExecutionTime(QueuedOrder queuedOrder, Restaurant restaurant);
    public  Float getDeliveryTime(QueuedOrder queuedOrder, Restaurant restaurant);
}
