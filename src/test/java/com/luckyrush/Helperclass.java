package com.luckyrush;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Helperclass {

	protected static WebDriver driver;
	protected Properties prop = new Properties();
	
	
	 public Helperclass() {
	        driver = getDriver();
	    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\websu\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            
            ChromeOptions options = new ChromeOptions();
      //      options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
   //         options.addArguments("--window-size=360,640");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize(); 
            driver.get("https://wbst:Welcome@12345@beta-dev.luckyrush.io");
        }
        return driver;//one
    }
}
