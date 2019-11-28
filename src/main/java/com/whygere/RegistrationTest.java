package com.whygere;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public class RegistrationTest {
  private WebDriver driver;
  JavascriptExecutor js;

  @Test
  public void whygreneRegistrationTest() throws InterruptedException, MalformedURLException {
    DesiredCapabilities dc=new DesiredCapabilities().chrome();
    dc.setBrowserName("chrome");
    dc.setPlatform(Platform.WINDOWS);
    URL url=new URL("http://172.17.4.154:4444/wd/hub");
    RemoteWebDriver driver=new RemoteWebDriver(url,dc);
    js = (JavascriptExecutor) driver;
    String email= RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
    System.out.println("email is "+email);
    String passwd= "Ptg@1234";
    driver.get("http://15.206.16.180/");
    driver.manage().window().maximize();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("HolyWhyGrene");
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("phone")).sendKeys("1234567890");
    driver.findElement(By.id("address")).click();
    driver.findElement(By.id("address")).sendKeys("area name");
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys("10007");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys(passwd);
    driver.findElement(By.id("utility_company")).click();
    driver.findElement(By.id("utility_company")).sendKeys("utilitycompany");
    driver.findElement(By.id("account_number")).click();
    driver.findElement(By.id("account_number")).sendKeys("1234567");
    driver.findElement(By.cssSelector(".btn-success")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".btn")).click();
    Thread.sleep(2000);
    {
      WebElement element = driver.findElement(By.cssSelector(".btn"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    Thread.sleep(2000);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(passwd);
    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".fa-cog")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".settings-sidebar li:nth-child(2)")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector(".settings-sidebar li:nth-child(2)")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Change Password")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("current")).click();
    driver.findElement(By.id("current")).sendKeys(passwd);
    driver.findElement(By.id("newPassword")).sendKeys("Ptg@12345");
    driver.findElement(By.id("confirm")).sendKeys("Ptg@12345");
    driver.findElement(By.cssSelector(".btn-apply")).click();
    driver.findElement(By.cssSelector(".fa-caret-down")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Logout")).click();
    driver.close();
    driver.quit();
  }
}
