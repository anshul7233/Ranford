package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Validation {

	public static boolean IsTextIsPresent(WebDriver driver, String exp) {
		boolean b = driver.findElement(By.tagName("tbody")).getText().contains(exp);
		return b;
	}

	public static boolean IsAlertIsPresent(WebDriver driver, String exp) {
		boolean b = driver.switchTo().alert().getText().contains(exp);
		return b;
	}

}
