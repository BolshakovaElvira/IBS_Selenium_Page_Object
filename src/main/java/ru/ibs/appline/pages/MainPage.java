package ru.ibs.appline.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {
    @FindBy(xpath = "//h1[contains(@class,'oro-subtitle')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[text()='Расходы']")
    private WebElement costBtn;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]/li/a/span[text()='Командировки']")
    private WebElement tripBtn;

    public void checkTitle(String text){
        loading();
        wait.until(visibilityOf(pageTitle));
        assertThat("Проверка, что заголовок заполнен верно",pageTitle.getText(),equalTo(text));
    }

    public void costClick(){
        wait.until(elementToBeClickable(costBtn));
        costBtn.click();
    }

    public void tripClick(){
        wait.until(elementToBeClickable(tripBtn));
        tripBtn.click();
    }
}
