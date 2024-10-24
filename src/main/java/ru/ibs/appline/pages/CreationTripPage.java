package ru.ibs.appline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CreationTripPage extends BasePage {
    @FindBy(xpath = "//h1[contains(@class,'user-name')]")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[contains(@class,'selector')]/span[text()='Выберите подразделение']/following-sibling::select")
    private WebElement subdivisionDropDown;
    @FindBy(xpath = "//select[contains(@id,'crm_business_trip_business')]/preceding-sibling::span")
    private WebElement choosenSubdivision;

    @FindBy(xpath = "//label[text()='Выбрать организацию из списка']/following-sibling::div/div/a[text()='Открыть список']")
    private WebElement selectHostOrganizationBtn;
    @FindBy(xpath = "//span[text()='Укажите организацию']")
    private WebElement specifyHostOrganizationBtn;

    @FindBy(xpath = "//div[contains(@class,'select2-search')]/input[contains(@class,'select2-input')]")
    private WebElement inputHostOrganization;
    @FindBy(xpath = "//div[contains(@class,'select2-result-label')]")
    private WebElement currentdHostOrganization;

    @FindBy(xpath = "//span[contains(@class,'select2-chosen')]")
    private WebElement choosenHostOrganizationName;

    @FindBy(xpath = "//div[contains(@data-name,'field__tasks')]//label")
    private List<WebElement> tasksCheckBox;

    @FindBy(xpath = "//input[contains(@data-name,'field__departure-city')]")
    private WebElement inputDepartureCity;

    @FindBy(xpath = "//input[contains(@data-name,'field__arrival-city')]")
    private WebElement inputArrivalCity;

    @FindBy(xpath = "//input[contains(@name,'date_selector_crm_business_trip_departureDatePlan')]")
    private WebElement inputDepartureDatePlan;

    @FindBy(xpath = "//input[contains(@name,'date_selector_crm_business_trip_returnDatePlan')]")
    private WebElement inputReturnDatePlan;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть') and @type='submit']")
    private WebElement saveAndCloseBtn;

    public void checkTitle(String text) {
        loading();
        wait.until(visibilityOf(pageTitle));
        assertThat("Проверка, что заголовок заполнен верно", pageTitle.getText(), equalTo(text));
    }

    public void enterSubdivision(String subdivision) {
        Select selectSubdivisionDropDown = new Select(subdivisionDropDown);
        selectSubdivisionDropDown.selectByVisibleText(subdivision);
    }

    public void enterHostOrganization(String hostOrganization) {
        selectHostOrganizationBtn.click();
        specifyHostOrganizationBtn.click();
        inputHostOrganization.sendKeys(hostOrganization);
        currentdHostOrganization.click();
    }

    public void enterDepartureCity(String departureCity) {
        wait.until(elementToBeClickable(inputDepartureCity));
        inputDepartureCity.clear();
        inputDepartureCity.sendKeys(departureCity);
    }

    public void enterArrivalCity(String arrivalCity) {
        wait.until(elementToBeClickable(inputArrivalCity));
        inputArrivalCity.clear();
        inputArrivalCity.sendKeys(arrivalCity);
    }

    public void enterDepartureDatePlan(String departureDate) {
        wait.until(visibilityOf(inputDepartureDatePlan));
        inputDepartureDatePlan.clear();
        inputDepartureDatePlan.sendKeys(departureDate);
    }

    public void enterReturnDatePlan(String returnDate) {
        wait.until(visibilityOf(inputReturnDatePlan));
        inputReturnDatePlan.clear();
        inputReturnDatePlan.sendKeys(returnDate);
    }

    public void selectTaskInCheckBox(String task) {
        wait.until(visibilityOfAllElements(tasksCheckBox));
        for (WebElement label : tasksCheckBox) {
            if (label.getText().trim().equals(task.trim())) {
                label.click();
                return;
            }
        }
    }

    public void saveAndCloseBtnClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", saveAndCloseBtn);
    }

    public void checkSubdivisionDropDown(String text) {
        assertThat("Проверка, что поле Подразделение соответствует заполненому",
                choosenSubdivision.getText(), equalTo(text));
    }

    public void checkHostOrganization(String text) {
        assertThat("Проверка, что поле Принимающая организация соответствует заполненому",
                choosenHostOrganizationName.getText(), equalTo(text));
    }

    public void checkTasksCheckBox(List<String> tasks) {
        for (String task : tasks) {
            String path = String.format("//label[contains(@for,'crm_business_trip_tasks') and text()='%s']/preceding-sibling::input", task);
            assertTrue(driver.findElement(By.xpath(path)).isSelected(), "Чекбокс должен быть выбран.");
        }
    }

    public void checkDepartureCity(String text) {
        assertThat("Проверка, что поле Город выбытия соответствует заполненому",
                inputDepartureCity.getAttribute("value"), equalTo(text));
    }

    public void checkArrivalCity(String text) {
        assertThat("Проверка, что поле Город прибытия соответствует заполненому",
                inputArrivalCity.getAttribute("value"), equalTo(text));
    }

    public void checkDepartureDatePlan(String text) {
        assertThat("Проверка, что поле Дата выбытия соответствует заполненому",
                inputDepartureDatePlan.getAttribute("value"), equalTo(text));
    }

    public void checkReturnDatePlan(String text) {
        assertThat("Проверка, что поле Дата прибытия соответствует заполненому",
                inputReturnDatePlan.getAttribute("value"), equalTo(text));
    }

    public void checkErrorMessage(String errorText) {
        String path = String.format("//*[contains(text(), '%s')]", errorText);
        WebElement errorMessage = wait.until(visibilityOfElementLocated(By.xpath(path)));
        assertThat("Проверка, что cообщение об ошибке соответствует ожидаемому", errorMessage.getText(), equalTo(errorText));
    }

}
