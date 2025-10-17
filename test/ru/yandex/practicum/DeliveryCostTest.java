package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {

    @Test
    public void shouldBe20WhenStandardAnd10kg() {
        StandardParcel standardParcel =
                new StandardParcel(10, "standard", "address", 1);

        Assertions.assertEquals(
                20,
                standardParcel.calculateDeliveryCost(),
                "Стоимость доставки должна быть равна 20"
        );
    }

    @Test
    public void shouldBe40WhenStandardAnd10kg() {
        FragileParcel fragileParcel =
                new FragileParcel(10, "fragile", "address", 1);

        Assertions.assertEquals(
                40,
                fragileParcel.calculateDeliveryCost(),
                "Стоимость доставки должна быть равна 40"
        );
    }

    @Test
    public void shouldBe30WhenPerishableAnd10kg() {
        PerishableParcel perishableParcel =
                new PerishableParcel(10, "perishable", "address", 1, 1);

        Assertions.assertEquals(
                30,
                perishableParcel.calculateDeliveryCost(),
                "Стоимость доставки должна быть равна 30"
        );
    }
}
