package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {

    private static final int BASE_COST = 3;
    private int timeToLive;

    public PerishableParcel(int weight, String description, String deliveryAddress, int sendDay, int timeToLive) {
        super(weight, description, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }

    public boolean isExpired(int currentDay) {
        return currentDay - sendDay >= timeToLive;
    }
}
