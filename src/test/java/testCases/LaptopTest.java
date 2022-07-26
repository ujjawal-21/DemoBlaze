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
	String[] value=new String[100];

	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
		laptopPage=new LaptopPage(driver);
		cartPage=new CartPage(driver);
		appCommonModules=new AppCommonModules();
	}

	@Test(enabled=false)
	public void Laptoptest() throws InterruptedException {

		appCommonModules.login1();
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
			Thread.sleep(5000);
			utils.HandleClickEvent(driver, laptopPage.btn_laptop);
			Thread.sleep(2000);	
		}
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(2000);
		hm.link_logOut.click();
	}


	/*	@Test(dependsOnMethods ="Laptoptest")

	public void laptoptoCart() throws InterruptedException
	{
		int rows = 0;
		hm.link_cart.click();
		Thread.sleep(5000);
		List<WebElement> totalProductsAdded = cartPage.totalProductsAdded; 
		for(WebElement e : totalProductsAdded) {
			System.out.println(e.getText());
			rows++;
		}
        Assert.assertEquals(6, rows);
	} */

	@Test
	public void deleteLaptop() throws InterruptedException {

		appCommonModules.login1();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, laptopPage.btn_laptop);
		Thread.sleep(2000);
		List<WebElement> str=laptopPage.getList();
		utils.HandleClickEvent(driver, hm.link_cart);
		Thread.sleep(2000);
		int rows=cartPage.getcartList();
		Thread.sleep(2000);
		value=appCommonModules.totalCart();
		for(int j=0;j<rows;j++) {
			
			String text=str.get(j).getText();

			if(text.equals(value[j])) {

				cartPage.btn_delete.click();
				Thread.sleep(5000);
			}
		}
	}
	@AfterMethod
	public void close()  {

		driver.quit();
	}

}

