package ru.ibs.appline.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.ibs.appline.managers.DriverManager;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getWebDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        takeScreenshot(scenario);
        DriverManager.closeDriver();
    }

    public static void takeScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
