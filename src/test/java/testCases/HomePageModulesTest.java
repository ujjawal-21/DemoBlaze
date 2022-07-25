package testCases;

import org.openqa.selenium.interactions.Actions;
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
	
	@Test(priority = 1, enabled=false)
    public void RegistrationTest() throws InterruptedException
    {
       utils.HandleClickEvent(driver, hm.link_signUp);
       Thread.sleep(1000);
       utils.HandleClickEvent(driver, hm.btn_cross);
       utils.HandleClickEvent(driver, hm.link_signUp);
       hm.txtBox_username.sendKeys(prop.getProperty("username"));
       hm.txtBox_password.sendKeys(prop.getProperty("password"));
       utils.HandleClickEvent(driver, hm.btn_close);
    }
	
	@Test(priority = 2, enabled=false)
	public void LoginTest() throws InterruptedException {
		utils.HandleClickEvent(driver, hm.link_login);
		Thread.sleep(1000);
		utils.HandleClickEvent(driver, hm.link_cross);
		utils.HandleClickEvent(driver, hm.link_login);
		Thread.sleep(1000);
		utils.HandleClickEvent(driver, hm.btn_dismiss);
		utils.HandleClickEvent(driver, hm.link_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
		Thread.sleep(2000);
		Assert.assertEquals(hm.txt_user.getText(), prop.getProperty("user"));
	}
	
	@Test(priority = 3, enabled=false)
	public void cartTest() {
		utils.HandleClickEvent(driver, hm.link_cart);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("cart.url"));
	}
	
	@Test(priority = 4)
	public void aboutUsTest() throws InterruptedException {
		Actions action = new Actions(driver);
		utils.HandleClickEvent(driver, hm.link_aboutUs);
		Thread.sleep(2000);
		action.moveToElement(hm.btn_playVid).click().perform();
		
		Thread.sleep(2000);
		//for(int i=0; i<2; i++)
	//	action.moveToElement(hm.btn_playPause).click().perform();
		
		action.moveToElement(hm.btn_muteUnmute).click().perform();
			Thread.sleep(2000);
		action.moveToElement(hm.btn_muteUnmute).click().perform();
		
	/*	action.moveToElement(hm.slider_vidFrame, 0, 170).perform();
		
		for(int i=0; i<2; i++) {
			utils.HandleClickEvent(driver, hm.btn_maxMinScreen);
			Thread.sleep(1000);
		}*/
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
