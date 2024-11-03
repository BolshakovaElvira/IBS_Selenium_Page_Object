package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;
import ru.ibs.appline.pages.ProductPageRegard;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProductPageRegardSteps {
    private final ProductPageRegard productPage;

    public ProductPageRegardSteps() {
        this.productPage = new ProductPageRegard();
    }

    @Допустим("Проверить, что заголовок страницы продукта заполнен значением: {string}")
    public void проверить_что_заголовок_заполнен_верно(String title) {
        productPage.checkProductPageTitle(title);
    }

    @Допустим("Выбрать Минимальную цену: {string}")
    public void выбрать_минимальную_цену(String price) {
        productPage.selectMinPrice(price);
    }

    @Допустим("Выбрать Производителя: {string}")
    public void выбрать_производителя(String manufacturer) {
        productPage.selectManufacturer(manufacturer);
    }

    @Допустим("Проверить, что страница с товаром загрузилась после поиска")
    public void проверить_что_поиск_закончен() {
        productPage.checkLoadingFinished();
    }

    @Допустим("Проверить фильтр количества товаров для отображения: {string}")
    public void проверить_фильтр_количества_товаров(String amount) {
        productPage.checkAmountProduct(amount);
    }

    @Допустим("Сохранить наименование товара под индексом {int} на странице")
    public void сохранить_наименование_товара(int index) {
        productPage.saveNameProduct(index);
    }

    @Допустим("Найти сохраненный товар")
    public void найти_сохраненный_товар() {
        productPage.searchForSavedProduct();
    }
}
