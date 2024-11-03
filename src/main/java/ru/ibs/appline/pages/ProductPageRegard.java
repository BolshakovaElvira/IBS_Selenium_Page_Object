package ru.ibs.appline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class ProductPageRegard extends BasePage {


    protected static String savedProductName;

    public static String getSavedProductName() {
        return savedProductName;
    }

    @FindBy(xpath = "//h1[contains(@class,'ListingPageTitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'ListingFilters_filterList')]//input[contains(@class,'RangeSelector') and @name='min']")
    private WebElement minPriceField;

    @FindBy(xpath = "//div[contains(@class,'Dropdown_title')]//span[text()='Производитель']//ancestor::section/div[contains(@class,'Dropdown_contentWrapper')]//input[@placeholder='Поиск']")
    private WebElement manufacturerField;

    @FindBy(xpath = "//div[contains(@class,'Dropdown_title')]//span[text()='Производитель']//ancestor::section/div[contains(@class,'Dropdown_contentWrapper')]//ul/li//span//span/label")
    private List<WebElement> manufacturerCheckBox;

    @FindBy(xpath = "//div[contains(text(), 'Товаров на странице')]/span")
    private WebElement amountProduct;

    @FindBy(xpath = "//div[contains(@class,'CardText_title')]")
    private List<WebElement> cardProductTitles;

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[contains(@class,'FilterTags_item')]")
    private WebElement filterTag;

    public void checkProductPageTitle(String text) {
        wait.until(visibilityOf(pageTitle));
        assertThat("Проверка, что заголовок заполнен верно", pageTitle.getText(), equalTo(text));
    }

    public void selectMinPrice(String minPrice) {
        wait.until(visibilityOf(minPriceField));
        minPriceField.sendKeys(minPrice);
        checkLoadingFinished();
    }

    public void selectManufacturer(String manufacturer) {
        manufacturerField.sendKeys(manufacturer);

        wait.until(visibilityOfAllElements(manufacturerCheckBox));
        for (WebElement label : manufacturerCheckBox) {
            if (label.getText().trim().equals(manufacturer.trim())) {
                label.click();
                return;
            }
        }
    }

    public void checkAmountProduct(String amount) {
        assertThat("Проверка, что заголовок заполнен верно", amountProduct.getText(), containsString(amount));
    }


    public void saveNameProduct(int index) {
        wait.until(not(ExpectedConditions.textToBePresentInElement(cardProductTitles.get(index), "")));
        savedProductName = cardProductTitles.get(index).getText();
    }


    public void searchForSavedProduct() {
        searchInput.sendKeys(savedProductName);
        searchInput.sendKeys(Keys.ENTER);
        checkLoadingFinished();
    }
}
