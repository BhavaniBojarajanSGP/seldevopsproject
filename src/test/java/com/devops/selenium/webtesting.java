package com.devops.selenium;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class webtesting
{
	@Test
    public void test()
    {
    	String driverfile =System.getProperty("user.dir")+"/Driver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverfile);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:3001");
        driver.findElement(By.name("login")).sendKeys("devops");
        driver.findElement(By.name("password")).sendKeys("test");
        driver.findElement(By.name("click")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        String test=driver.findElement(By.name("test")).getText();
        assertEquals(test,"Login Succeeded");
        System.out.println("Test Succeeded!!");
        driver.quit();

    }
}