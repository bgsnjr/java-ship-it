package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    private static final int BASE_COST = 4;

    public FragileParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка <<%s>> обёрнута в защитную плёнку\n", description);
        super.packageItem();
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.printf("Хрупкая посылка <<%s>> изменила местоположение на %s\n", description, newLocation);
    }
}
