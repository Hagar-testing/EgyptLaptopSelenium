package com.egyptlaptop.factory;

import com.egyptlaptop.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import static com.egyptlaptop.enums.BrowserType.CHROME;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class DriverFactory {

    public WebDriver initializeDriver() {
        String browserKey = System.getProperty(BROWSER, CHROME.getKey());
        WebDriver driver;

        BrowserType browser = BrowserType.getByKey(browserKey.toLowerCase());
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserKey);
        }

        configureDriver(driver);
        return driver;
    }

    private void configureDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
}
