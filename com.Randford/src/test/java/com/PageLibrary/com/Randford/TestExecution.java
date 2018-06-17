package com.PageLibrary.com.Randford;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataDriven.ExcelDataDriven;

public class TestExecution extends Repository {
	@Parameters({ "browser" })
	@BeforeTest
	public void verify_launch(String browser) {

		launch(browser);
	}

	@Test(priority = 1)
	public void verify_login() {
		login();
	}

	/*	@DataProvider(name = "branches")
	public String[][] verify_excelContent_branch() {
		return excelContent("Exceldata.xls", "Sheet1");
	}

	@Test(priority = 2, dataProvider = "branches")
	public void verify_branchCreation(String bname, String address1, String address2, String address3, String area,
			String zipcode, String country, String state, String city) throws Exception {
		branchCreation(bname, address1, address2, address3, area, zipcode, country, state, city);
	}
	 */
	@Test(priority = 2)
	public void branch_excelConnection() throws Exception {

		ExcelDataDriven.excelConnection("Exceldata.xls", "Sheet1");
		ExcelDataDriven.outputExcelConnection("Exceldata.xls", "Output.xls", "Sheet1");

		int c = ExcelDataDriven.ccount();
		for (int r = 1; r < ExcelDataDriven.rcount(); r++) {

			branchCreation(ExcelDataDriven.readData(0, r), ExcelDataDriven.readData(1, r),
					ExcelDataDriven.readData(2, r), ExcelDataDriven.readData(3, r), ExcelDataDriven.readData(4, r),
					ExcelDataDriven.readData(5, r), ExcelDataDriven.readData(6, r), ExcelDataDriven.readData(7, r),
					ExcelDataDriven.readData(8, r));
			String text = Generic.alertPopup(driver).getText();
			Generic.alertPopup(driver).accept();

			if (text.contains("created Sucessfully")) {
				ExcelDataDriven.writeData(c++, r, "Test Passed");
				c--;
			} else if (text.contains("already Exist")) {
				ExcelDataDriven.writeData(c++, r, "Test Failed");
				c--;
			} else {
				ExcelDataDriven.writeData(c++, r, "Alert is not present");
				c--;
			}

		}

		ExcelDataDriven.saveWorkbook();

	}

	@Test(priority = 3)
	public void role_excelConnection() throws Exception{

		ExcelDataDriven.excelConnection("Exceldata.xls", "Sheet2");
		ExcelDataDriven.outputExcelConnection("Exceldata.xls", "Output.xls", "Sheet2");

		int c = ExcelDataDriven.ccount();
		for(int r=1; r<ExcelDataDriven.rcount(); r++){

			roleCreation(ExcelDataDriven.readData(0, r), ExcelDataDriven.readData(1, r), ExcelDataDriven.readData(2, r));
			String text = Generic.alertPopup(driver).getText();
			Generic.alertPopup(driver).accept();

			if(text.contains("created Sucessfully")){
				ExcelDataDriven.writeData(c++, r, "Test Passed");
				c--;
			}
			else if(text.contains("already Exist")){
				ExcelDataDriven.writeData(c++, r, "Test Failed");
				c--;
			}
			else{
				ExcelDataDriven.writeData(c++, r, "Alert is not present");
				c--;
			}

		}
		ExcelDataDriven.saveWorkbook();
	}

/*	@DataProvider(name = "roles")
	public String[][] verify_excelContent_role() {
		return excelContent("Exceldata.xls", "Sheet2");
	}

	@Test(priority = 3, dataProvider = "roles")
	public void verify_roleCreation(String roleName, String roleDesc, String roleType) throws Exception {
		roleCreation(roleName, roleDesc, roleType);
	}
*/
/*	@Test(priority = 4)
	public void verify_userCreation() throws Exception {
		userCreation();
	}

	@Test(priority = 5)
	public void verify_BranchesEdit() {

		editBranchTable();

	}

	@Test(priority = 6)
	public void verify_rolesEdit() {

		editRoleTable();
	}
*/
}
