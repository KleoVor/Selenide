package ru.netology.selenide;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class DeliveryFormCard {

    @Test
    void testingPositiveDeliveryFormCard() throws InterruptedException {
        LocalDate currentDate = LocalDate.now();  // получение экземпляра класса LocalDate с текущей датой
        LocalDate incrementedDate = currentDate.plusDays(3);  // увеличение даты на 3 дня
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = incrementedDate.format(formatter);


        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        form.$("[data-test-id=city] input").setValue("Казань");

        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(" ");
        $("[data-test-id=date] input").setValue(formattedDate);
        $("[data-test-id=name] input").setValue("Наталья Иванова-Петрова");
        $("[data-test-id=phone] input").setValue("+79670000000");
        $("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(12));

    }
}