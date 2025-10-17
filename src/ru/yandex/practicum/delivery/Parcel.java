package ru.yandex.practicum.delivery;

abstract class Parcel {
    protected int weight;
    protected String description;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(int weight, String description, String deliveryAddress, int sendDay) {
        this.weight = weight;
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected abstract int getBaseCost();

    protected int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int calculateDeliveryCost() {
        return getBaseCost() * weight;
    }

    public void packageItem() {
        System.out.printf("Посылка <<%s>> упакована\n", description);
    }

    public void deliver() {
        System.out.printf("Посылка <<%s>> доставлена по адресу %s\n", description, deliveryAddress);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "description='" + description + '\'' +
                '}';
    }
}
