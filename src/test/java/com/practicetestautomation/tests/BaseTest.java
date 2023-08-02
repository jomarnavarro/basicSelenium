package com.practicetestautomation.tests;

import com.practicetestautomation.pages.HomePage;
import com.practicetestautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage home;
    LoginPage login;

    @Parameters({"url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
        home = new HomePage(driver);
        login = new LoginPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
