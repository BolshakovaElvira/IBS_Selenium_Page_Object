package ru.ibs.appline.steps;

import io.qameta.allure.Step;
import ru.ibs.appline.pages.CreationTripPage;

import java.util.List;

public class CreationTripPageSteps {
    private final CreationTripPage creationPage;

    // Конструктор
    public CreationTripPageSteps() {
        this.creationPage = new CreationTripPage();
    }

    @Step("Проверяем, что заголовок страницы {text}")
    public CreationTripPageSteps checkTitle(String text) {
        creationPage.checkTitle(text);
        return this;
    }

    @Step("Выбираем Подразделение: {subdivision}")
    public CreationTripPageSteps selectSubdivision(String subdivision) {
        creationPage.enterSubdivision(subdivision);
        return this;
    }

    @Step("Выбираем Принимающую организацию: {hostOrganization}")
    public CreationTripPageSteps selectHostOrganization(String hostOrganization) {
        creationPage.enterHostOrganization(hostOrganization);
        return this;
    }

    @Step("Выбираем Задачу: {task}")
    public CreationTripPageSteps selectTask(String task) {
        creationPage.selectTaskInCheckBox(task);
        return this;
    }

    @Step("Выбираем Город Выбытия: {departureCity}")
    public CreationTripPageSteps selectDepartureCity(String departureCity) {
        creationPage.enterDepartureCity(departureCity);
        return this;
    }

    @Step("Выбираем Город Прибытия: {arrivalCity}")
    public CreationTripPageSteps selectArrivalCity(String arrivalCity) {
        creationPage.enterArrivalCity(arrivalCity);
        return this;
    }

    @Step("Выбираем Дату Выбытия: {departureDate}")
    public CreationTripPageSteps selectDepartureDatePlan(String departureDate) {
        creationPage.enterDepartureDatePlan(departureDate);
        return this;
    }

    @Step("Выбираем Дату Прибытия: {returnDate}")
    public CreationTripPageSteps selectReturnDatePlan(String returnDate) {
        creationPage.enterReturnDatePlan(returnDate);
        return this;
    }

    @Step("Нажимаем на кнопку 'Сохранить и закрыть'")
    public CreationTripPageSteps saveAndCloseTripClick() {
        creationPage.saveAndCloseBtnClick();
        return this;
    }

    @Step("Проверяем, что выбраны задачи: {tasks}")
    public CreationTripPageSteps checkTasksInCheckBox(List<String> tasks) {
        creationPage.checkTasksCheckBox(tasks);
        return this;
    }

    @Step("Проверяем, что выбрано Подразделение: {subdivision}")
    public CreationTripPageSteps checkSubdivision(String subdivision) {
        creationPage.checkSubdivisionDropDown(subdivision);
        return this;
    }

    @Step("Проверяем, что выбрана Принимающая организация: {hostOrganization}")
    public CreationTripPageSteps checkHostOrganization(String hostOrganization) {
        creationPage.checkHostOrganization(hostOrganization);
        return this;
    }

    @Step("Проверяем, что выбран Город Выбытия: {departureCity}")
    public CreationTripPageSteps checkDepartureCity(String departureCity) {
        creationPage.checkDepartureCity(departureCity);
        return this;
    }

    @Step("Проверяем, что выбран Город Прибытия: {arrivalCity}")
    public CreationTripPageSteps checkArrivalCity(String arrivalCity) {
        creationPage.checkArrivalCity(arrivalCity);
        return this;
    }

    @Step("Проверяем, что выбрана Дата Выбытия: {departureDate}")
    public CreationTripPageSteps checkDepartureDatePlan(String departureDate) {
        creationPage.checkDepartureDatePlan(departureDate);
        return this;
    }

    @Step("Проверяем, что выбрана Дата Прибытия: {returnDate}")
    public CreationTripPageSteps checkReturnDatePlan(String returnDate) {
        creationPage.checkReturnDatePlan(returnDate);
        return this;
    }

    @Step("Проверяем, что появилось сообщение об ошибке на странице: {errorMessage}")
    public void checkErrorMessage(String errorMessage) {
        creationPage.checkErrorMessage(errorMessage);
    }
}
