package test.libraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.pages.CartPage;
import test.pages.HomePageModules;
import test.pages.LaptopPage;

public class AppCommonModules extends Base{

	Utilities utils;
	HomePageModules hm;
	CartPage cartPage;
	LaptopPage laptopPage;
	String value[];
	
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
		utils.HandleClickEvent(driver, hm.link_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username1"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password1"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
		laptopPage=new LaptopPage(driver);
	}
	
	public String[] totalCart() throws InterruptedException {
				
		login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(2000);
		int rows=cartPage.getcartList();
		for(int i=0;i<rows;i++)
		{
			value[i]=driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+i+"]/td[2]")).getText();
		}
		return value;
		
	}
	
	public void DeleteCart() throws InterruptedException {
		
		int rows=cartPage.getcartList();
		Thread.sleep(2000);
		List<WebElement> str1=laptopPage.getList();
		Thread.sleep(2000);
		for(int j=0;j<rows;j++) {
			
			if((str1.get(j).getText()).equals(value[j])) {
				
				cartPage.btn_delete.click();
				Thread.sleep(5000);
			}
		}
	}
	
	
}
