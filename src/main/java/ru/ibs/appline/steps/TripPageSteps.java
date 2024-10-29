package ru.ibs.appline.steps;

import io.qameta.allure.Step;

import ru.ibs.appline.pages.TripPage;

public class TripPageSteps {
    private final TripPage tripPage;
    public TripPageSteps() {
        this.tripPage = new TripPage();
    }

    @Step("Нажимаем на кнопку Создать командировку")
    public CreationTripPageSteps createTripClick(){
        tripPage.createTripBtnClick();
        return new CreationTripPageSteps();
    }
}
