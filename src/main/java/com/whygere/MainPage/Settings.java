package com.whygere.MainPage;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.commons.io.FileUtils;
import com.whygere.BaseUrl.LaunchUrl;

public class Settings extends LaunchUrl {

	WebDriver driver;

	public void settingsPage(WebDriver driver) throws Exception {
		
		//Selecting Settings option 
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[9]//a[1]")));
		element.click();

		Thread.sleep(2000);
		
		//Editing the settings page
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='address']")).clear();
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("1890 Highland Parkway");
		driver.findElement(By.xpath("//button[@class='btn btn-apply']")).click();
		
		System.out.println("User details updated succesfully");
		
		//Screenshot after updating user details
		EventFiringWebDriver we1=new EventFiringWebDriver(driver);
		File src= we1.getScreenshotAs(OutputType.FILE);
		File desc= new File("./Screenshots/Settings.png");
		FileUtils.copyFile(src,desc);
		Thread.sleep(8000);
		System.out.println("Screenshot after updating user details");

		Login lgn = new Login(driver);
		lgn.Logout();
		driver.close();

		//Calling change Password 
//		changePassword(driver);
	}

	public void changePassword(WebDriver driver) throws Exception {

		driver.findElement(By.xpath("//li[9]//a[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Change Password')]")).click();
		driver.findElement(By.xpath("//input[@id='current']")).sendKeys("Ptg@1234");
		driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("Welcome@1234");
		driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("Welcome@1234");
		driver.findElement(By.xpath("//button[@class='btn btn-apply']")).click();
		Thread.sleep(5000);
		System.out.println("Password changed successfully");
		
		//Screenshot for Password Changed Successful
		EventFiringWebDriver we1=new EventFiringWebDriver(driver);
		File src= we1.getScreenshotAs(OutputType.FILE);
		File desc= new File("./Screenshots/Password.png");
		FileUtils.copyFile(src,desc);
		
		//Click again on settings option
		driver.findElement(By.xpath("//li[3]//a[1]")).click();
		System.out.println("Enter into settings page");
		
		// Logout method calling
//		Login lgn = new Login(driver);
//		lgn.Logout();

	}
}
