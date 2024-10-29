package ru.ibs.appline.steps;

import io.qameta.allure.Step;

import ru.ibs.appline.pages.MainPage;


public class MainPageSteps {
    private final MainPage mainPage;
    public MainPageSteps() {
        this.mainPage = new MainPage();
    }

    @Step("Проверяем, что заголовок страницы {text}")
    public MainPageSteps checkTitle(String text){
        mainPage.checkTitle(text);
        return this;
    }

    @Step("Переходим на страницу Командировки")
    public TripPageSteps filterByTrip(){
        mainPage.costClick();
        mainPage.tripClick();
        return new TripPageSteps();
    }
}
