package com.PageLibrary.com.Randford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.Base;

public class NewRolePage extends Base {

	public static WebElement newRoles_text(WebDriver driver) {
		return driver.findElement((getlocator("newRoles")));
	}

	public static WebElement roleName_text(WebDriver driver) {
		return driver.findElement((getlocator("roleName")));
	}

	public static WebElement roleDesc_text(WebDriver driver) {
		return driver.findElement((getlocator("roleDesc")));
	}

	public static WebElement submitRole(WebDriver driver) {
		return driver.findElement((getlocator("submitRole")));
	}

}
