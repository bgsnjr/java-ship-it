package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(30);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateAllTrackableParcels(trackableParcels);
                    break;
                case 5:
                    showParcelsInBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус отслеживаемых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
        int parcelType = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите вес посылки:");
        int parcelWeight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите описание посылки:");
        String parcelDescription = scanner.nextLine();

        System.out.println("Введите адрес доставки:");
        String parcelDeliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки:");
        int parcelSendDay = Integer.parseInt(scanner.nextLine());

        switch (parcelType) {
            case 1:
                StandardParcel standardParcel =
                        new StandardParcel(parcelWeight, parcelDescription, parcelDeliveryAddress, parcelSendDay);
                allParcels.add(standardParcel);
                standardParcelBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel =
                        new FragileParcel(parcelWeight, parcelDescription, parcelDeliveryAddress, parcelSendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Введите срок хранения посылки:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel =
                        new PerishableParcel(parcelWeight, parcelDescription, parcelDeliveryAddress, parcelSendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Некорректный тип посылки");
                break;
        }
    }

    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст");
        } else {
            for (Parcel parcel : allParcels) {
                parcel.packageItem();
                parcel.deliver();
            }
        }
    }

    private static void calculateCosts() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст");
        } else {
            int deliveryCost = 0;
            for (Parcel parcel : allParcels) {
                deliveryCost += parcel.calculateDeliveryCost();
            }
            System.out.printf("Общая стоимость всех доставок: %d\n", deliveryCost);
        }
    }

    private static void showParcelsInBox() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 — Стандарт");
        System.out.println("2 — Хрупкое");
        System.out.println("3 — Скоропортящееся");
        int boxType = Integer.parseInt(scanner.nextLine());

        switch (boxType) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                fragileParcelBox.getAllParcels();
                break;
            case 3:
                perishableParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Некорректный тип коробки");
        }
    }

    private static <T extends Trackable> void updateAllTrackableParcels(List<T> parcels) {
        if (parcels.isEmpty()) {
            System.out.println("Нет отслеживаемых посылок");
        } else {
            System.out.println("Введите новое местоположение посылки:");
            String newLocation = scanner.nextLine();

            for (T parcel : parcels) {
                parcel.reportStatus(newLocation);
            }
        }
    }
}

