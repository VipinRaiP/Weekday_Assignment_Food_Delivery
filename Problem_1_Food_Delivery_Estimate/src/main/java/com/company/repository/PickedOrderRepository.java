package com.company.repository;

import com.company.models.PickedOrder;
import com.company.models.QueuedOrder;

public interface PickedOrderRepository {
    public void  addPickedOrder(PickedOrder pickedOrder);
    public PickedOrder removePickedOrder();
    public Boolean isPickedOrdersEmpty();
}
