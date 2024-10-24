package ru.ibs.appline.steps;

import ru.ibs.appline.pages.CreationTripPage;

import java.util.List;

public class CreationTripPageSteps {
    private CreationTripPage creationPage;

    // Конструктор
    public CreationTripPageSteps() {
        this.creationPage = new CreationTripPage();
    }

    public CreationTripPageSteps checkTitle(String text) {
        creationPage.checkTitle(text);
        return this;
    }

    public CreationTripPageSteps selectSubdivision(String subdivision) {
        creationPage.enterSubdivision(subdivision);
        return this;
    }

    public CreationTripPageSteps selectHostOrganization(String hostOrganization) {
        creationPage.enterHostOrganization(hostOrganization);
        return this;
    }

    public CreationTripPageSteps selectTask(String task) {
        creationPage.selectTaskInCheckBox(task);
        return this;
    }

    public CreationTripPageSteps selectDepartureCity(String departureCity) {
        creationPage.enterDepartureCity(departureCity);
        return this;
    }

    public CreationTripPageSteps selectArrivalCity(String arrivalCity) {
        creationPage.enterArrivalCity(arrivalCity);
        return this;
    }

    public CreationTripPageSteps selectDepartureDatePlan(String departureDate) {
        creationPage.enterDepartureDatePlan(departureDate);
        return this;
    }

    public CreationTripPageSteps selectReturnDatePlan(String returnDate) {
        creationPage.enterReturnDatePlan(returnDate);
        return this;
    }

    public CreationTripPageSteps saveAndCloseTripClick() {
        creationPage.saveAndCloseBtnClick();
        return this;
    }

    public CreationTripPageSteps checkTasksInCheckBox(List<String> tasks) {
        creationPage.checkTasksCheckBox(tasks);
        return this;
    }

    public CreationTripPageSteps checkSubdivision(String subdivision) {
        creationPage.checkSubdivisionDropDown(subdivision);
        return this;
    }

    public CreationTripPageSteps checkHostOrganization(String hostOrganization) {
        creationPage.checkHostOrganization(hostOrganization);
        return this;
    }

    public CreationTripPageSteps checkDepartureCity(String departureCity) {
        creationPage.checkDepartureCity(departureCity);
        return this;
    }

    public CreationTripPageSteps checkArrivalCity(String arrivalCity) {
        creationPage.checkArrivalCity(arrivalCity);
        return this;
    }

    public CreationTripPageSteps checkDepartureDatePlan(String departureDate) {
        creationPage.checkDepartureDatePlan(departureDate);
        return this;
    }

    public CreationTripPageSteps checkReturnDatePlan(String returnDate) {
        creationPage.checkReturnDatePlan(returnDate);
        return this;
    }

    public CreationTripPageSteps checkErrorMessage(String errorMessage) {
        creationPage.checkErrorMessage(errorMessage);
        return this;
    }
}
