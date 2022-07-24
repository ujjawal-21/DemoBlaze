package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.libraries.Base;
import test.libraries.Utilities;
import test.pages.HomePageModules;

public class HomePageModulesTest extends Base
{
	
	HomePageModules hm;
	Utilities utils;
	
	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
	}
	
	@Test(priority = 1)
    public void RegistrationTest() throws InterruptedException
    {
       utils.HandleClickEvent(driver, hm.btn_signUp);
       Thread.sleep(1000);
       utils.HandleClickEvent(driver, hm.btn_cross);
       utils.HandleClickEvent(driver, hm.btn_signUp);
       hm.txtBox_username.sendKeys(prop.getProperty("username"));
       hm.txtBox_password.sendKeys(prop.getProperty("password"));
       utils.HandleClickEvent(driver, hm.btn_close);
    }
	
	@Test(priority = 2)
	public void LoginTest() throws InterruptedException {
		utils.HandleClickEvent(driver, hm.btn_login);
		Thread.sleep(1000);
		utils.HandleClickEvent(driver, hm.link_cross);
		utils.HandleClickEvent(driver, hm.btn_login);
		Thread.sleep(1000);
		utils.HandleClickEvent(driver, hm.btn_dismiss);
		utils.HandleClickEvent(driver, hm.btn_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
		Thread.sleep(2000);
		Assert.assertEquals(hm.txt_user.getText(), prop.getProperty("user"));
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
