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
import test.pages.CartPage;
import test.pages.HomePageModules;
import test.pages.LaptopPage;
import test.pages.MonitorsPage;

public class MonitorTest extends Base {

	Utilities utils;
	HomePageModules hm;
	LaptopPage laptopPage;
	CartPage cp;
	MonitorsPage monitorsPage;
	AppCommonModules appCommonModules;
	AppCommonModules cm;
	AddToCartPage cart;

	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
		laptopPage = new LaptopPage(driver);
		cp = new CartPage(driver);
		monitorsPage=new MonitorsPage(driver);

		appCommonModules=new AppCommonModules();

		cm = new AppCommonModules();
		cart = new AddToCartPage(driver);

	}

	@Test
	public void monitorTest() throws InterruptedException {


		appCommonModules.login();

		cm.login();

		Thread.sleep(2000);
		utils.JSExecutorScrollIntoView(driver, monitorsPage.link_monitors);
		utils.HandleClickEvent(driver, monitorsPage.link_monitors);
		Thread.sleep(2000);
		List <WebElement> list = monitorsPage.links_Totalmonitors;
		List <WebElement> products = monitorsPage.products;
		for(int i=0; i<2; i++) {
			utils.JSExecutorScrollIntoView(driver, products.get(i));
			utils.HandleClickEvent(driver, list.get(i));
			utils.HandleClickEvent(driver, cart.btn_addToCart);
			String msg = utils.HandleAlert(driver);
			Assert.assertEquals(msg, "Product added.");
			Thread.sleep(2000);
			driver.get(prop.getProperty("url"));
			Thread.sleep(2000);
			utils.JSExecutorScrollIntoView(driver, monitorsPage.link_monitors);
			utils.HandleClickEvent(driver, monitorsPage.link_monitors);
			Thread.sleep(2000);

			monitorsPage.btn_cart.click();
			String text=utils.HandleAlert(driver);
			Assert.assertEquals(text, "Product added");
			driver.get(prop.getProperty("url"));
			utils.HandleClickEvent(driver, monitorsPage.link_monitors);
			Thread.sleep(2000);	
		}

		hm.link_cart.click();
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods ="monitorTest",enabled = false)

	public void laptoptoCart() throws InterruptedException
	{

		List<WebElement> monitor=monitorsPage.links_Totalmonitors;
		appCommonModules.login();
		Thread.sleep(2000);
		hm.link_cart.click();
		Thread.sleep(5000);
		int list=cp.getcartList();
		Assert.assertEquals(list, monitor.size());

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
		Assert.assertEquals(rows, 2);
		Assert.assertEquals(sum, price);

		utils.HandleClickEvent(driver, cp.btn_placeOrder);
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
		utils.HandleClickEvent(driver, cp.btn_ok);

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}


