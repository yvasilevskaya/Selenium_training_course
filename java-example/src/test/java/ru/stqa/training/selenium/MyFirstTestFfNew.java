package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Yulia on 7/12/2017.
 */
public class MyFirstTestFfNew {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    DesiredCapabilities caps = new DesiredCapabilities();
    //caps.setCapability(FirefoxDriver.MARIONETTE, false);
    driver = new FirefoxDriver(
            new FirefoxBinary(new File("c:\\Program Files\\Nightly\\firefox.exe")),
            new FirefoxProfile(), caps);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver,10);
  }

  @Test
  public void myFirstTest(){
    driver.get("http://www.google.com");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();
    wait.until(titleIs("webdriver - Пошук Google"));
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}