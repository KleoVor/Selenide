package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class DeliveryFormCard {

    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }


    @Test
    void testingPositiveDeliveryFormCard() {

        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        form.$("[data-test-id=city] input").setValue("Казань");
        String planningDate = generateDate(8, "dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Наталья Иванова-Петрова");
        $("[data-test-id=phone] input").setValue("+79670000000");
        $("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}