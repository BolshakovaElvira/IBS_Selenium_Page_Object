package ru.ibs.appline.steps;

import ru.ibs.appline.pages.LoginPage;
import ru.ibs.appline.pages.MainPage;
import ru.ibs.appline.pages.TripPage;

public class TripPageSteps {
    private TripPage tripPage;
    public TripPageSteps() {
        this.tripPage = new TripPage();
    }
    public CreationTripPageSteps createTripClick(){
        tripPage.createTripBtnClick();
        return new CreationTripPageSteps();
    }
}
