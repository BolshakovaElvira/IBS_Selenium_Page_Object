package ru.ibs.appline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;


public class ProductPageAfterSearchRegard extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'Card_row')]")
    private List<WebElement> cardProductTitlesAfterSearch;
    @FindBy(xpath = "//div[contains(@class,'FilterTags_item')]")
    private WebElement filterTag;


    public void checkAmountDisplayedProducts(int amount) {
        String message = String.format("Проверка, что на странице отображено %d товаров", amount);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'Card_row')]"), amount));
        assertThat(message, cardProductTitlesAfterSearch.size(), equalTo(amount));
    }

    public void checkNameDisplayedProduct(int index) {
        String message = String.format("Проверка, что наименование товара соотвествует сохраненному");
        assertThat(message, cardProductTitlesAfterSearch.get(index).getText(), containsString(ProductPageRegard.getSavedProductName()));
    }
}
