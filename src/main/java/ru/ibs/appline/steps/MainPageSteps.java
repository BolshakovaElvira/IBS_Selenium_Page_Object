package ru.ibs.appline.steps;

import ru.ibs.appline.pages.LoginPage;
import ru.ibs.appline.pages.MainPage;
import ru.ibs.appline.pages.TripPage;

public class MainPageSteps {
    private MainPage mainPage;
    public MainPageSteps() {
        this.mainPage = new MainPage();
    }
    public MainPageSteps checkTitle(String text){
        mainPage.checkTitle(text);
        return this;
    }

    public TripPageSteps filterByTrip(){
        mainPage.costClick();
        mainPage.tripClick();
        return new TripPageSteps();
    }
}
