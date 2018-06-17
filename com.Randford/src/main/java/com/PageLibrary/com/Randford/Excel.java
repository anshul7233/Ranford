package com.PageLibrary.com.Randford;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testBase.Base;

public class Excel extends Base {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\java_bank\\project\\com.Randford\\src\\test\\java\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://183.82.100.55/ranford1/adminflow.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']")).click();
		driver.findElement(By.id("BtnNewBR")).click();

		FileInputStream fis = new FileInputStream("D:\\java_bank\\project\\com.Randford\\Excel\\data.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		
		String BN = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		driver.findElement(By.id("txtbName")).sendKeys(BN);
		
	}
}