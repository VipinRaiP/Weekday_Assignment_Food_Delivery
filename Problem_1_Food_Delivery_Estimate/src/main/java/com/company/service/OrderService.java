package com.company.service;

import com.company.models.QueuedOrder;
import com.company.models.Restaurant;

public interface OrderService {
    public void estimateDeliveryTime(QueuedOrder queuedOrder, Restaurant restaurant);
}
