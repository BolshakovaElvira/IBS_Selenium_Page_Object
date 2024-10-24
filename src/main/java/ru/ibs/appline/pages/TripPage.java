package ru.ibs.appline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class TripPage extends BasePage {
    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createTripBtn;

    public void createTripBtnClick(){
        wait.until(elementToBeClickable(createTripBtn));
        createTripBtn.click();
    }

}
