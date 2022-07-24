package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.libraries.Base;
import test.pages.HomePageModules;

public class HomePageModulesTest extends Base
{
	
	HomePageModules hm;
	
	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		
	}
	
	@Test
    public void RegistrationTest()
    {
       hm.btn_signUp.click();
    }
	
	@AfterMethod
	public void close() {
		//driver.close();
	}
}
