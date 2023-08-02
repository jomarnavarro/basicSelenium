package com.herokuapp.theinternet.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver createDriver() {
        switch(this.browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
                driver.set(new FirefoxDriver());
                break;
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }


}
