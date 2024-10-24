package ru.ibs.appline.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.ibs.appline.properties.TestProps.getInstance;

public class DriverManager {
    private static WebDriver driver;
    private static Properties properties = getInstance().getProperties();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        System.setProperty(properties.getProperty("webdriver"), properties.getProperty("webdriver.path"));
        driver = new ChromeDriver();
        driver.get(properties.getProperty("base.url"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
