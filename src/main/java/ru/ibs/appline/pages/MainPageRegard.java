package ru.ibs.appline.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPageRegard extends BasePage {
    @FindBy(xpath = "//button/span[text()='Каталог']")
    private WebElement catalogBtn;

    @FindBy(xpath = "//ul[contains(@class,'Catalog_mainList')]/li/a/div")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//div[contains(@class,'Categories_categoryItem')]//p[contains(@class,'CardCategory_title')]")
    private List<WebElement> categoryCards;


    public void catalogBtnClick() {
        wait.until(elementToBeClickable(catalogBtn));
        catalogBtn.click();
    }

    public void selectCategoryInCatalog(String nameCategory) {
        wait.until(visibilityOfAllElements(categoryList));
        for (WebElement category : categoryList) {
            if (category.getText().trim().contains(nameCategory.trim())) {
                category.click();
                return;
            }
        }
    }

    public void selectCardCategory(String cardName) {
        wait.until(visibilityOfAllElements(categoryCards));
        for (WebElement card : categoryCards) {
            if (card.getText().trim().contains(cardName.trim())) {
                wait.until(elementToBeClickable(card));
                card.click();
                return;
            }
        }
    }
}
