package com.PageLibrary.com.Randford;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import dataDriven.Excel;
import dataDriven.ExcelDataDriven;
import table.WebTable;
import testBase.Base;
import utility.Library;
import utility.Validation;

public class Repository extends Base {

	WebDriver driver;

	public void launch(String browser) {
		
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",
					"D:\\java_bank\\project\\com.Randford\\src\\test\\java\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver",
				"D:\\java_bank\\project\\com.Randford\\src\\test\\java\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		driver.get(config("Build1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (Validation.IsTextIsPresent(driver, "Welcome to Personalized Banking")) {
			Reporter.log("Launch test is passed");
		} else {
			Reporter.log("Launch test is failed");
			Library.attachment("Launch");
		}
	}

	public void login() {
		HomePage.userName_text(driver).sendKeys("Admin");
		HomePage.password_text(driver).sendKeys("Admin");
		HomePage.login(driver).click();

		if (Validation.IsTextIsPresent(driver, "Welcome to Admin")) {
			Reporter.log("Login test is passed");
		} else {
			Reporter.log("Login test is failed");
			Library.attachment("Login");
		}

	}

	public void branchCreation(String bname, String address1, String address2, String address3, String area,
			String zipcode, String country, String state, String city) throws InterruptedException {
		
			AdminPage.branches_link(driver).click();
			AdminPage.newBranch_link(driver).click();
			NewBranchesPage.branchName_text(driver).sendKeys(bname);
			NewBranchesPage.address1_text(driver).sendKeys(address1);
			NewBranchesPage.address2_text(driver).sendKeys(address2);
			NewBranchesPage.address3_text(driver).sendKeys(address3);
			NewBranchesPage.area_text(driver).sendKeys(area);
			NewBranchesPage.zipcode_text(driver).sendKeys(zipcode);
			Generic.dropdown(driver, getlocator("country"), country);
			Generic.dropdown(driver, getlocator("state"), state);
			Generic.dropdown(driver, getlocator("city"), city);
			NewBranchesPage.submitBranch(driver).click();
			Thread.sleep(3000);
		

			/*if (Validation.IsAlertIsPresent(driver, "created Sucessfully")) {
				Reporter.log("Branch creation is passed");
			} else {
				Reporter.log("Branch creation is failed");
				// Library.attachment("branch");
			}
			Generic.alertPopup(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void roleCreation(String roleName, String roleDesc, String roleType) throws InterruptedException {

		
			AdminPage.roles_link(driver).click();
			NewRolePage.newRoles_text(driver).click();
			NewRolePage.roleName_text(driver).sendKeys(roleName);
			NewRolePage.roleDesc_text(driver).sendKeys(roleDesc);
			Thread.sleep(2000);
			Generic.dropdown(driver, getlocator("roleType"), roleType);
			Thread.sleep(2000);
			NewRolePage.submitRole(driver).click();
			

/*			if (Validation.IsAlertIsPresent(driver, "created Sucessfully")) {
				Reporter.log("role creation is passed");
			} else {
				Reporter.log("role creation is failed");
				// Library.attachment("role creation");
			}
			Generic.alertPopup(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/	}

	public void userCreation() throws InterruptedException {

		AdminPage.users_link(driver).click();

		NewUserPage.newUser_text(driver).click();
		Generic.dropdown(driver, getlocator("roless"), "icustomer");
		Thread.sleep(3000);
		Generic.dropdown(driver, getlocator("branch"), "BTM");
		Thread.sleep(3000);
		Generic.dropdown(driver, getlocator("customerID"), "46");
		Thread.sleep(3000);
		NewUserPage.user_name(driver).sendKeys("Anshul");
		Thread.sleep(3000);
		NewUserPage.login_password(driver).sendKeys("Ansh");
		Thread.sleep(3000);
		NewUserPage.transaction_password(driver).sendKeys("Ansh");
		Thread.sleep(3000);
		NewUserPage.submitUser(driver).click();
		Thread.sleep(3000);

		if (Validation.IsAlertIsPresent(driver, "created Sucessfully")) {
			Reporter.log("user creation is passed");
		} else {
			Reporter.log("user creation is failed");
			// Library.attachment("user creation");
		}
		Generic.alertPopup(driver);
	}

	public void editBranchTable() {

		AdminPage.branches_link(driver).click();
		WebTable.m1(driver, getlocator("branchesTable"), "edit", "77");
		Table.update_btn(driver).click();
	}

	public void editRoleTable() {

		AdminPage.roles_link(driver).click();
		WebTable.m1(driver, getlocator("rolesTables"), "edit", "52");
		Table.update_btn(driver).click();

	}

	public String[][] excelContent(String fileName, String sheetName) {
		ExcelDataDriven.excelConnection(fileName, sheetName);
		int rc = ExcelDataDriven.rcount();
		int cc = ExcelDataDriven.ccount();

		String[][] data = new String[rc - 1][cc];
		for (int r = 1; r < rc; r++) {
			for (int c = 0; c < cc; c++) {
				data[r - 1][c] = ExcelDataDriven.readData(c, r);
			}
		}
		return data;
	}

}
