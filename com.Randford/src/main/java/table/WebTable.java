package table;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.PageLibrary.com.Randford.Table;

import testBase.Base;

public class WebTable extends Base {

	static boolean status = false;

	public static void m1(WebDriver driver, By prop, String operation, String id) {
		try {
			boolean flag = false;
			WebElement table = driver.findElement(prop);
			List<WebElement> rows = table.findElements(getlocator("tableRow"));
			String[] pagelinks = rows.get(rows.size() - 1).getText().split(" ");

			for (int l = 1; l < pagelinks.length; l++) {

				try {
					if (pagelinks[l].contains("...") && status == true) {
						driver.findElement(getlocator("...right")).click();
					} else {
						table.findElement(By.linkText(pagelinks[l])).click();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (pagelinks[l].contains("...")) {
					status = true;
					m1(driver, prop, operation, id);
				}

				table = driver.findElement(prop);
				rows = table.findElements(getlocator("tableRow"));

				for (WebElement r : rows) {

					List<WebElement> columns = r.findElements(getlocator("tableColumn"));

					for (WebElement c : columns) {
						String text = c.getText();

						if (text.matches(id)) {

							if (operation.equalsIgnoreCase("edit")) {
								columns.get(columns.size() - 2).findElement(By.tagName("a")).click();
							} else if (operation.equalsIgnoreCase("delete")) {
								columns.get(columns.size() - 1).findElement(By.tagName("a")).click();
							} else {
								Reporter.log("Operation is failed");
							}
							flag = true;
							break;
						}

					}
					if (flag == true) {
						break;
					}

				}
				if (flag == true) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}