package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;
import ru.ibs.appline.pages.CreationTripPage;

import java.util.Arrays;
import java.util.List;

public class CreationTripPageSteps {
    private final CreationTripPage creationPage;

    // Конструктор
    public CreationTripPageSteps() {
        this.creationPage = new CreationTripPage();
    }

    @Допустим("Проверить, что текст заголовка страницы Создание командировки {string}")
    public void проверить_текст_заголовка_страницы_создание_командировки(String text) {
        creationPage.checkCreationTripPageTitle(text);
    }

    @Допустим("Выбрать Подразделение: {string}")
    public void выбрать_подразделение(String subdivision) {
        creationPage.enterSubdivision(subdivision);
    }

    @Допустим("Выбрать Принимающую организацию: {string}")
    public void выбрать_принимающую_организацию(String hostOrganization) {
        creationPage.enterHostOrganization(hostOrganization);
    }

    @Допустим("Выбрать Задачу: {string}")
    public void выбрать_задачу(String task) {
        creationPage.selectTaskInCheckBox(task);

    }

    @Допустим("Выбрать Город Выбытия: {string}")
    public void выбрать_город_выбытия(String departureCity) {
        creationPage.enterDepartureCity(departureCity);

    }

    @Допустим("Выбрать Город Прибытия: {string}")
    public void выбрать_город_прибытия(String arrivalCity) {
        creationPage.enterArrivalCity(arrivalCity);

    }

    @Допустим("Выбрать Дату Выбытия: {string}")
    public void выбрать_дату_выбытия(String departureDate) {
        creationPage.enterDepartureDatePlan(departureDate);

    }

    @Допустим("Выбрать Дату Прибытия: {string}")
    public void выбрать_дату_прибытия(String returnDate) {
        creationPage.enterReturnDatePlan(returnDate);

    }

    @Допустим("Нажать на кнопку 'Сохранить и закрыть'")
    public void нажать_на_кнопку_сохранить_и_закрыть() {
        creationPage.saveAndCloseBtnClick();

    }

    @Допустим("Проверить, что выбраны задачи: {string}")
    public void проверить_что_выбраны_задачи(String tasksString) {
        List<String> tasks = Arrays.asList(tasksString.split(","));
        creationPage.checkTasksCheckBox(tasks);

    }

    @Допустим("Проверить, что выбрано Подразделение: {string}")
    public void проверить_выбранное_подразделение(String subdivision) {
        creationPage.checkSubdivisionDropDown(subdivision);

    }

    @Допустим("Проверить, что выбрана Принимающая организация:{string}")
    public void проверить_выбранную_принимающую_организацию(String hostOrganization) {
        creationPage.checkHostOrganization(hostOrganization);

    }

    @Допустим("Проверить, что выбран Город Выбытия: {string}")
    public void проверить_выбранный_город_выбытия(String departureCity) {
        creationPage.checkDepartureCity(departureCity);

    }

    @Допустим("Проверить, что выбран Город Прибытия: {string}")
    public void проверить_выбранный_город_прибытия(String arrivalCity) {
        creationPage.checkArrivalCity(arrivalCity);

    }

    @Допустим("Проверить, что выбрана Дата Выбытия: {string}")
    public void проверить_выбранную_дату_выбытия(String departureDate) {
        creationPage.checkDepartureDatePlan(departureDate);

    }

    @Допустим("Проверить, что выбрана Дата Прибытия: {string}")
    public void проверить_выбранную_дату_прибытия(String returnDate) {
        creationPage.checkReturnDatePlan(returnDate);

    }

    @Допустим("Проверить, что появилось сообщение об ошибке на странице: {string}")
    public void проверить_сообщение_об_ошибке(String errorMessage) {
        creationPage.checkErrorMessage(errorMessage);
    }
}
