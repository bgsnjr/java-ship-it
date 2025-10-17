package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class ExpiredTest {

    @Test
    public void shouldBeExpiredWhenDaysSinceSendExceedTimeToLive() {
        PerishableParcel perishableParcel =
                new PerishableParcel(10, "perishable", "address", 1, 1);

        Assertions.assertTrue(perishableParcel.isExpired(2), "Посылка должна быть просроченной");
    }

    @Test
    public void shouldNotBeExpiredWhenDaysSinceSendNotExceedTimeToLive() {
        PerishableParcel perishableParcel =
                new PerishableParcel(10, "perishable", "address", 1, 2);

        Assertions.assertFalse(perishableParcel.isExpired(2), "Посылка должна быть просроченной");
    }
}
