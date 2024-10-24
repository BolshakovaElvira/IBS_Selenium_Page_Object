package ru.ibs.appline.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//h2[text()='Логин']")
    private WebElement pageTitle;
    @FindBy(xpath = "//input[contains(@placeholder,'Имя пользователя или Email')]")
    private WebElement registrationLoginField;
    @FindBy(xpath = "//input[contains(@placeholder,'Пароль')]")
    private WebElement registrationPasswordField;

    @FindBy(xpath = "//button[@type='submit' and text()='Войти']")
    private WebElement buttonSubmit;


    public void enterLoginAndPassword(String login, String password) {
        wait.until(visibilityOf(pageTitle));
        registrationLoginField.sendKeys(login);
        registrationPasswordField.sendKeys(password);
    }

    public void submitClick() {
        wait.until(elementToBeClickable(buttonSubmit));
        buttonSubmit.click();
    }
}
