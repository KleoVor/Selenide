package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


class SelectionFromListAndCalendar {

    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }


    @Test
    void shouldSelectionFromListAndCalendar() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        //    SelenideElement form = $(".form_theme_alfa-on-white");
        $("[data-test-id=city] input").setValue("Ка");
        $$(".menu-item__control").findBy(text("Казань")).click();

        String planningDate = generateDate(20, "dd.MM.yyyy");

        $("[data-test-id=date] input").click();
        if (!generateDate(3, "MM").equals((generateDate(20, "MM")))) {
            $(".calendar__arrow.calendar__arrow_direction_right[data-step='1']").click();
        }

        $$(".calendar__day").findBy(text(generateDate(20, "dd"))).click();

        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Наталья Иванова-Петрова");
        $("[data-test-id=phone] input").setValue("+79670000000");
        $("[data-test-id=agreement]").click();
        $(".button_theme_alfa-on-white").click();


        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}




