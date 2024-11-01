package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;

import ru.ibs.appline.pages.MainPage;


public class MainPageSteps {
    private final MainPage mainPage;

    public MainPageSteps() {
        this.mainPage = new MainPage();
    }

    @Допустим("Проверить, что текст заголовка основной страницы: {string}")
    public void проверить_что_текст_заголовка_основной_страницы(String string) {
        mainPage.checkMainPageTitle(string);
    }

    @Допустим("Перейти на страницу Командировки")
    public void перейти_на_страницу_командировки() {
        mainPage.costClick();
        mainPage.tripClick();
    }
}
