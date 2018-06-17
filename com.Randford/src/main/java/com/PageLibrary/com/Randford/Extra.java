package com.PageLibrary.com.Randford;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testBase.Base;

public class Extra extends Base {
		
	
		
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\java_bank\\project\\com.Randford\\src\\test\\java\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://www.way2sms.com/content/index.html?");
	WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About Way2SMS')]"));
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollintoview", about);
	
	
}
}