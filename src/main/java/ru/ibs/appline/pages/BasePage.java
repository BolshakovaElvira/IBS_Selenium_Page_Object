package ru.ibs.appline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static ru.ibs.appline.managers.DriverManager.getWebDriver;

public class BasePage {
    @FindBy(className = "loader-mask")
    private WebElement loadingIcon;

    protected static WebDriver driver = getWebDriver();
    protected static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public BasePage() {
        initElements(driver, this);
    }

    public void loading() {
        wait.until(invisibilityOf(loadingIcon));
    }
}
