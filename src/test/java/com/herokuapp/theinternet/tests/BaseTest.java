package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.utilities.BrowserDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage home;
    LoginPage login;

    @Parameters({"url", "browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String url, @Optional("chrome") String browser) {
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();
        driver.get(url);
        home = new HomePage(driver);
        login = new LoginPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
