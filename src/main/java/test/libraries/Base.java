package test.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	public static int tot = 0;
	public Base() {
		FileInputStream fin;
		try {
			prop = new Properties();
			fin = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/other/config.properties");
			try {
				prop.load(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init() {
		    System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver.path"));
	        driver = new ChromeDriver();
	        driver.get(prop.getProperty("url"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
