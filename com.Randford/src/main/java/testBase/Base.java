package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Base {

	static Properties p;
	public static void loadproperty()
	{
		try {
			File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\configuration\\OR.properties");

			FileReader fs = new FileReader(f);

			p = new Properties();

			p.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static By getlocator(String key)
	{
		loadproperty();
		By loc = null;
		String elevalue = p.getProperty(key);
		
		String loctype = elevalue.split(":")[0];
		String locvalue = elevalue.split(":")[1];
		
		switch(loctype)
		{
		case "id":
			loc = By.id(locvalue);
			break;
		case "name":
			loc = By.name(locvalue);
		break;
		
		case "className":
			loc = By.className(locvalue);
			break;
			
		case "linkText":
			loc = By.linkText(locvalue);
			break;
			
		case "partialLinkText":
			loc = By.partialLinkText(locvalue);
		break;
			
		case "tagName":
			loc = By.cssSelector(locvalue);
			break;

		
		case "cssselector":
			loc = By.cssSelector(locvalue);
			break;
		
		case "xpath":
			loc = By.xpath(locvalue);
			break;
		}
		return loc;
		
	}
	
	
	public static void loadproperty1()
	{
		try {
			File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\configuration\\config.properties");

			FileReader fs = new FileReader(f);

			p = new Properties();

			p.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String config(String key){
		loadproperty1();
		
		String evevalue= p.getProperty(key);
		return evevalue;
		
	}

}
