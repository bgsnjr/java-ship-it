package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    private static final int BASE_COST = 2;

    public StandardParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }
}
