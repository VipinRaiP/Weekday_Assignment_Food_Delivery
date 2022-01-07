package com.company.models;

public class PickedOrder {
    private QueuedOrder queuedOrder;
    private Float estimatedTime;
    private Integer occupiedSlots;

    public QueuedOrder getQueuedOrder() {
        return queuedOrder;
    }

    public void setQueuedOrder(QueuedOrder queuedOrder) {
        this.queuedOrder = queuedOrder;
    }

    public Float getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Float estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Integer getOccupiedSlots() {
        return occupiedSlots;
    }

    public void setOccupiedSlots(Integer occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }
}