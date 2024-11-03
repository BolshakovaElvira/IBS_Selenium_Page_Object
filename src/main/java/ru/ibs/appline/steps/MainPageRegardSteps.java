package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;
import ru.ibs.appline.pages.MainPageRegard;


public class MainPageRegardSteps {
    private final MainPageRegard mainPage;

    public MainPageRegardSteps() {
        this.mainPage = new MainPageRegard();
    }

    @Допустим("Нажать на кнопку Каталог")
    public void нажать_на_кнопку_каталог() {
        mainPage.catalogBtnClick();
    }

    @Допустим("Выбрать категорию товаров в каталоге: {string}")
    public void выбрать_категорию_товаров_в_каталоге(String string) {
        mainPage.selectCategoryInCatalog(string);
    }

    @Допустим("Выбрать раздел в категории товаров: {string}")
    public void выбрать_раздел_в_категории_товаров(String string) {
        mainPage.selectCardCategory(string);
    }

}
