package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private int maxWeight;
    private int boxWeight;
    private final List<T> parcels = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getBoxWeight() {
        return boxWeight;
    }

    public void addParcel(T parcel) {
        if (boxWeight + parcel.getWeight() > maxWeight) {
            System.out.println("Добавление данной посылки невозможно - превышен лимит по весу");
        } else {
            parcels.add(parcel);
            boxWeight += parcel.getWeight();
            System.out.printf("Посылка добавлена в коробку. Текущий вес коробки %d\n", boxWeight);
        }
    }

    public void getAllParcels() {
        if (parcels.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            for (T parcel : parcels) {
                System.out.println(parcel);
            }
        }
    }
}
