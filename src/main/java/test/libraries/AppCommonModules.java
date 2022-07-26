package test.libraries;

import org.openqa.selenium.By;
import test.pages.CartPage;
import test.pages.HomePageModules;
import test.pages.LaptopPage;

public class AppCommonModules extends Base{

	Utilities utils;
	HomePageModules hm;
	CartPage cartPage;
	LaptopPage laptopPage;
	String value[]=new String[100];
	
	public void login() {
		hm = new HomePageModules(driver);
		utils = new Utilities();
		cartPage=new CartPage(driver);
		utils.HandleClickEvent(driver, hm.link_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
		laptopPage=new LaptopPage(driver);
	}
	
	public void login1() {
		hm = new HomePageModules(driver);
		utils = new Utilities();
		cartPage=new CartPage(driver);
		laptopPage=new LaptopPage(driver);
		utils.HandleClickEvent(driver, hm.link_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username1"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password1"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
		
	}
	
	public String[] totalCart() throws InterruptedException {
				
		int rows=cartPage.getcartList();
		for(int i=1;i<=rows;i++)
		{
			value[i-1]=driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+i+"]/td[2]")).getText();
		}
		return value;
		
	}
	
}
