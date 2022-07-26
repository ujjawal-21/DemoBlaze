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
	String value;
	
	public void login() {
		hm = new HomePageModules(driver);
		utils = new Utilities();
		cartPage=new CartPage(driver);
		utils.HandleClickEvent(driver, hm.link_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
	}
	
	public String totalCart() throws InterruptedException {
				
		login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(2000);
		int rows=cartPage.getcartList();
		for(int i=0;i<rows;i++)
		{
			value=driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+i+"]/td[2]")).getText();
		}
		return value;
		
	}
	
	public void DeleteCart() {
		
		int rows=cartPage.getcartList();
		List<WebElement> str1=laptopPage.getList();
		for(int j=0;j<rows;j++) {
			
			if(str1.get(j).getText()==value) {
				
				cartPage.btn_delete.click();
			}
		}
	}
	
	
}
