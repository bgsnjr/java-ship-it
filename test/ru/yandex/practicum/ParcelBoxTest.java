package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class ParcelBoxTest {

    @Test
    public void shouldBeAddedWhenNotMaxWeight() {
        ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(50);
        StandardParcel standardParcel =
                new StandardParcel(50, "standard", "address", 1);
        standardParcelBox.addParcel(standardParcel);

        Assertions.assertEquals(
                50,
                standardParcelBox.getBoxWeight(),
                "Вес коробки должен быть равен весу посылки"
        );
    }

    @Test
    public void shouldNotBeAddedWhenMaxWeight() {
        ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(50);
        StandardParcel standardParcel =
                new StandardParcel(51, "standard", "address", 1);
        standardParcelBox.addParcel(standardParcel);

        Assertions.assertEquals(
                0,
                standardParcelBox.getBoxWeight(),
                "Вес коробки должен быть равен нулю"
        );
    }
}
