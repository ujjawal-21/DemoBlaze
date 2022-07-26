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
import test.pages.LaptopPage;

public class LaptopTest extends Base {

	Utilities utils;
	HomePageModules hm;
	LaptopPage laptopPage;
	CartPage cartPage;
	AppCommonModules appCommonModules;

	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
		laptopPage=new LaptopPage(driver);
		cartPage=new CartPage(driver);
		appCommonModules=new AppCommonModules();
	}

	@Test
	public void Laptoptest() throws InterruptedException {
		Thread.sleep(2000);
		appCommonModules.login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, laptopPage.btn_laptop);
		Thread.sleep(5000);
		List<WebElement> str=laptopPage.getList();
		//System.out.println(str.toString());
		for(int i=1;i<=str.size();i++)
		{
			//System.out.println(i);
			str=laptopPage.getList();
			utils.HandleVisibilityOfElements(driver, str.get(i-1));
			utils.JSExecutorScrollIntoView(driver, str.get(i-1));
			str.get(i-1).click();
			Thread.sleep(2000);
			laptopPage.btn_addtocart.click();
			Thread.sleep(2000);
			String text=utils.HandleAlert(driver);
			Assert.assertEquals(text, "Product added.");
			driver.get(prop.getProperty("url"));
			utils.HandleClickEvent(driver, laptopPage.btn_laptop);
			Thread.sleep(2000);	
			utils.HandleClickEvent(driver, hm.link_cart);
		}

	}

	@AfterMethod
	public void close() throws InterruptedException {
	
		//Thread.sleep(2000);
		appCommonModules.login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(5000);
		appCommonModules.DeleteCart();
		Thread.sleep(2000);
		driver.quit();
	}

}
