package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;

import ru.ibs.appline.pages.TripPage;

public class TripPageSteps {
    private final TripPage tripPage;

    public TripPageSteps() {
        this.tripPage = new TripPage();
    }

    @Допустим("Нажать на кнопку Создать командировку")
    public void нажатьНаКнопкуСоздатьКомандировку() {
        tripPage.createTripBtnClick();
    }
}
