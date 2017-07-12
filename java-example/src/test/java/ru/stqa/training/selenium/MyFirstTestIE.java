package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Yulia on 7/12/2017.
 */
public class MyFirstTestIE {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
      driver = new InternetExplorerDriver();
      wait = new WebDriverWait(driver,50);
    }

    @Test
    public void myFirstTest(){
      driver.get("http://www.google.com");
      driver.findElement(By.name("q")).sendKeys("webdriver");
      driver.findElement(By.name("btnG")).click();
      wait.until(titleIs("webdriver - Google Search"));
    }

    @After
    public void stop() {
      driver.quit();
      driver = null;
    }
  }
