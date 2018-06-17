package com.PageLibrary.com.Randford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.Base;

public class Table extends Base{
	
	public static WebElement update_btn(WebDriver driver){
		return driver.findElement(getlocator("btnupdate"));
	}
	
	public static WebElement branches_table(WebDriver driver)
	{
		return driver.findElement((getlocator("branchesTable")));
		
	}

	public static WebElement table_row(WebDriver driver)
	{
		return driver.findElement((getlocator("TableRow")));
	}
	
	public static WebElement table_column(WebDriver driver)
	{
		return driver.findElement((getlocator("TableColumn")));

}
	
	public static WebElement table_edit(WebDriver driver)
	{
		return driver.findElement((getlocator("edit")));
}
	
	public static WebElement roles_table(WebDriver driver){
		
		return driver.findElement(getlocator(""));
	}
	
	
	
	
	
}
