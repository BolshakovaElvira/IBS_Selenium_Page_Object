package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;
import ru.ibs.appline.pages.ProductPageAfterSearchRegard;
import ru.ibs.appline.pages.ProductPageRegard;

public class ProductPageAfterSearchRegardSteps {
    private final ProductPageAfterSearchRegard productPageAfterSearch;

    public ProductPageAfterSearchRegardSteps() {
        this.productPageAfterSearch = new ProductPageAfterSearchRegard();
    }


    @Допустим("Проверить количество отображенных товаров: {int}")
    public void проверить_количество_отображенных_товаров(int amount) {
        productPageAfterSearch.checkAmountDisplayedProducts(amount);
    }

    @Допустим("Проверить, что наименование товара соответствует сохраненному значению под индексом: {int}")
    public void проверить_наименнование_сохраненнгого_товара_после_поиска(int index) {
        productPageAfterSearch.checkNameDisplayedProduct(index);
    }
}
