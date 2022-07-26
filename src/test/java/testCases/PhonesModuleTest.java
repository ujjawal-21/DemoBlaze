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
import test.pages.AddToCartPage;
import test.pages.PhonesModule;

public class PhonesModuleTest extends Base{

	Utilities utils;
	PhonesModule pm;
	AppCommonModules cm;
	AddToCartPage cart;
	
	@BeforeMethod
	public void initialization() {
		init();
		utils = new Utilities();
		pm = new PhonesModule(driver);
		cart = new AddToCartPage(driver);
		cm = new AppCommonModules();
	}
	
	@Test
	public void addingPhonestoCartTest() throws InterruptedException {
		cm.login();
		Thread.sleep(2000);
		utils.JSExecutorScrollIntoView(driver, pm.link_phones);
		utils.HandleClickEvent(driver, pm.link_phones);
		List <WebElement> list = pm.link_phoneName;
		List <WebElement> products = pm.products;
		for(int i=0; i<7; i++) {
			utils.JSExecutorScrollIntoView(driver, products.get(i));
			utils.HandleClickEvent(driver, list.get(i));
			tot++;
			utils.HandleClickEvent(driver, cart.btn_addToCart);
			String msg = utils.HandleAlert(driver);
			Assert.assertEquals(msg, "Product added.");
			Thread.sleep(2000);
			driver.get(prop.getProperty("url"));
			Thread.sleep(2000);
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
