package testCases;

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
	
	@Test(priority = 6, enabled=false)
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
	
	@Test(priority = 7, enabled=false)
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
	
	@Test(priority = 5, enabled=false)
	public void cartTest() {
		utils.HandleClickEvent(driver, hm.link_cart);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("cart.url"));
	}
	
	@Test(priority = 4, enabled=false)
	public void aboutUsTest() throws InterruptedException {
		utils.HandleClickEvent(driver, hm.link_aboutUs);
		utils.HandleClickEvent(driver, hm.btn_playVid);
		utils.HandleClickEvent(driver, hm.btn_cls);
	}
	
	@Test(priority = 3, enabled=false)
	public void contactTest() {
		utils.HandleClickEvent(driver, hm.link_contact);
		utils.HandleClickEvent(driver, hm.link_crossCls);
		utils.HandleClickEvent(driver, hm.link_contact);
		utils.HandleClickEvent(driver, hm.btn_contactCls);
		utils.HandleClickEvent(driver, hm.link_contact);
		hm.txtBox_contactEmail.sendKeys("Abc");
		hm.txtBox_contactName.sendKeys("Yuv");
		hm.txtArea_msg.sendKeys("Testing");
		hm.btn_sendMsg.click();
		String msg = utils.HandleAlert(driver);
		Assert.assertEquals(msg, "Thanks for the message!!");
	}
	
	@Test(priority = 2, enabled=false)
	public void homeLinkTest() {
		utils.HandleClickEvent(driver, hm.link_home);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("homeLink.url"));
	}
	
	@Test(priority = 1, enabled=false)
	public void logoTest() {
		utils.HandleClickEvent(driver, hm.link_Complogo);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("homeLink.url"));
	}
	
	@Test(priority = 8)
	public void logOutTest() {
		cm.Login();
		utils.HandleClickEvent(driver, hm.link_logOut);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("homeLink.url"));
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
