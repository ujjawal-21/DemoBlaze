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
import test.pages.CartPage;
import test.pages.HomePageModules;
import test.pages.PhonesModule;

public class CartPageTest extends Base{
	Utilities utils;
	CartPage cp;
	HomePageModules hm;
	AppCommonModules cm;
	PhonesModule pm;
	
	@BeforeMethod
	public void settingUp() {
		init();
		utils = new Utilities();
		hm = new HomePageModules(driver);
		cp = new CartPage(driver);
		pm = new PhonesModule(driver);
		cm = new AppCommonModules();
	}
	
	@Test(priority = 1)
	public void productsPurchaseTest() throws InterruptedException {
		int rows=0;
		int sum=0, price=0;
		cm.login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(5000);
		List <WebElement> totalProductsAdded = cp.totalProductsAdded;
		for(WebElement e : totalProductsAdded) {
			String s = e.getText();
			sum = sum + Integer.parseInt(s);
			rows++;
		}
		String p = cp.txt_totalPrice.getText();
		price = Integer.parseInt(p);
		Assert.assertEquals(rows, tot);
		Assert.assertEquals(sum, price);
		
		
	/*	utils.HandleClickEvent(driver, cp.btn_placeOrder);
		utils.HandleClickEvent(driver, cp.link_purchaseCross);
		utils.HandleClickEvent(driver, cp.btn_placeOrder);
		utils.HandleClickEvent(driver, cp.btn_purchaseClose);
		utils.HandleClickEvent(driver, cp.btn_placeOrder);
		cp.txtBox_name.sendKeys("Yuv");
		cp.txtBox_country.sendKeys("Ind");
		cp.txtBox_city.sendKeys("Pat");
		cp.txtBox_creditCard.sendKeys("1234");
		cp.txtBox_month.sendKeys("11");
		cp.txtBox_year.sendKeys("2022");
		utils.HandleClickEvent(driver, cp.btn_purchase);
		Assert.assertEquals(cp.txt_confirmation.getText(), "Thank you for your purchase!");
		utils.HandleClickEvent(driver, cp.btn_ok);*/
	}
	
	@Test(priority = 2, enabled=false)
	public void productDeletionTest() throws InterruptedException {
		int products = 0, rows = 0;
		cm.login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(5000);
		List <WebElement> totalProductsAdded = cp.totalProductsAdded;
		for(int i=0; i<totalProductsAdded.size(); i++) {
			rows++;
		}
			List <WebElement> totalProductsToBeDeleted = cp.link_delete;
			for(int i=0; i<totalProductsToBeDeleted.size(); i++) {
				WebElement e = totalProductsToBeDeleted.get(i);
				utils.HandleClickEvent(driver, e);
				Thread.sleep(5000);
				products++;
			}
			Assert.assertEquals(products, rows);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
