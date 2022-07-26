package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.libraries.AppCommonModules;
import test.libraries.Base;
import test.libraries.Utilities;
import test.pages.HomePageModules;

public class HomePageModulesTest extends Base
{
	
	HomePageModules hm;
	Utilities utils;
	AppCommonModules cm;
	
	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
		cm = new AppCommonModules();
	}
	
	@Test(priority = 6, enabled=true)
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
	
	@Test(priority = 7, enabled=true)
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
	
	@Test(priority = 5, enabled=true)
	public void cartTest() {
		utils.HandleClickEvent(driver, hm.link_cart);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("cart.url"));
	}
	
	@Test(priority = 4, enabled=true)
	public void aboutUsTest() throws InterruptedException {
		utils.HandleClickEvent(driver, hm.link_aboutUs);
		utils.HandleClickEvent(driver, hm.link_AbtCross);
		utils.HandleClickEvent(driver, hm.link_aboutUs);
		utils.HandleClickEvent(driver, hm.btn_playVid);
		utils.HandleClickEvent(driver, hm.btn_closeAbtUs);
	}
	
	@Test(priority = 3, enabled=true)
	public void contactTest() {
		utils.HandleClickEvent(driver, hm.link_contact);
		utils.HandleClickEvent(driver, hm.link_contactCross);
		utils.HandleClickEvent(driver, hm.link_contact);
		utils.HandleClickEvent(driver, hm.btn_contactClose);
		utils.HandleClickEvent(driver, hm.link_contact);
		hm.txtBox_contactEmail.sendKeys("ABC");
		hm.txtBox_contactName.sendKeys("Yuv");
		hm.txtArea_msg.sendKeys("testing");
		utils.HandleClickEvent(driver, hm.btn_sendMsg);
		String msg = utils.HandleAlert(driver);
		Assert.assertEquals(msg, "Thanks for the message!!");
	}
	
	@Test(priority = 8, enabled=true)
	public void logoutTest() {
		cm.login();
		utils.HandleClickEvent(driver, hm.link_logOut);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("homeLink.url"));
	}
	
	@Test(priority = 2, enabled=true)
	public void homeLinkTest() {
		utils.HandleClickEvent(driver, hm.link_home);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("homeLink.url"));
	}
	
	@Test(priority = 1, enabled=true)
	public void logoTest() {
		utils.HandleClickEvent(driver, hm.link_logo);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("homeLink.url"));
	}
	
	@Test(priority = 9, enabled=true)
	public void bannerSlidingTest() throws InterruptedException {
		
		List<WebElement> list = hm.TotalBanners;
		for(int i=0; i<list.size(); i++) {
			utils.HandleClickEvent(driver, hm.link_next);
			Thread.sleep(1000);
		}
		
		for(int i=list.size(); i>0; i--) {
			utils.HandleClickEvent(driver, hm.link_prev);
			Thread.sleep(1000);
		}
	}
	
	@Test(priority = 10)
	public void nextPrevListTest() throws InterruptedException {	
		utils.JSExecutorScrollIntoView(driver, hm.btn_next);
		Thread.sleep(1000);
		utils.HandleClickEvent(driver, hm.btn_next);
		Thread.sleep(5000);
		utils.JSExecutorScrollIntoView(driver, hm.btn_prev);
		Thread.sleep(1000);
		utils.HandleClickEvent(driver, hm.btn_prev);
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
