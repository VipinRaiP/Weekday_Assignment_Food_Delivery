package com.company.repository.impl;

import com.company.models.PickedOrder;
import com.company.repository.PickedOrderRepository;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PickedOrderRepositoryImpl implements PickedOrderRepository {
    private PriorityQueue<PickedOrder> pickedOrderPriorityQueue;

    // Order with low estimated time will be completed first
    private class Sort implements Comparator<PickedOrder>{
        public int compare(PickedOrder p1,PickedOrder p2){
            Float diff = p1.getEstimatedTime()-p2.getEstimatedTime();
            return diff==0?0:diff<0?-1:1;
        }
    }

    public PickedOrderRepositoryImpl(){
        this.pickedOrderPriorityQueue = new PriorityQueue<>(new Sort());
    }


    @Override
    public void addPickedOrder(PickedOrder pickedOrder) {
        this.pickedOrderPriorityQueue.add(pickedOrder);
    }

    @Override
    public PickedOrder removePickedOrder() {
        return this.pickedOrderPriorityQueue.poll();
    }

    @Override
    public Boolean isPickedOrdersEmpty() {
        return this.pickedOrderPriorityQueue.isEmpty();
    }


}
