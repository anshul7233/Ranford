package com.PageLibrary.com.Randford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.Base;

public class NewUserPage extends Base {
	public static WebElement newUser_text(WebDriver driver){
		return driver.findElement(getlocator("newUser"));
	}

	public static WebElement customer_name(WebDriver driver){
		return driver.findElement(getlocator("Lbc_name"));
	}
	
	public static WebElement user_name(WebDriver driver){
		return driver.findElement(getlocator("txtUname"));
	}
	
	public static WebElement login_password(WebDriver driver){
		return driver.findElement(getlocator("txtLpwd"));
	}

	public static WebElement transaction_password(WebDriver driver){
		return driver.findElement(getlocator("txtTpwd"));
	}
	
	public static WebElement submitUser(WebDriver driver) {
		return driver.findElement((getlocator("submitUser")));
	}
}

