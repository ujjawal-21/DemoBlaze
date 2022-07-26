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
import test.pages.MonitorsPage;

public class MonitorTest extends Base {

	Utilities utils;
	HomePageModules hm;
	LaptopPage laptopPage;
	CartPage cartPage;
	MonitorsPage monitorsPage;
	AppCommonModules appCommonModules;
	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
		laptopPage=new LaptopPage(driver);
		cartPage=new CartPage(driver);
		monitorsPage=new MonitorsPage(driver);
		appCommonModules=new AppCommonModules();
	}

	@Test
	public void monitorTest() throws InterruptedException {

		appCommonModules.login();
		Thread.sleep(2000);
		utils.HandleClickEvent(driver, monitorsPage.btn_monitors);
		Thread.sleep(2000);
		List<WebElement> monitor=monitorsPage.listMonitors();
		for(int i=1;i<=monitor.size();i++)
		{
			monitor=monitorsPage.listMonitors();
			utils.HandleVisibilityOfElements(driver, monitor.get(i-1));
			utils.JSExecutorScrollIntoView(driver, monitor.get(i-1));
			monitor.get(i-1).click();
			Thread.sleep(2000);
			monitorsPage.btn_cart.click();
			String text=utils.HandleAlert(driver);
			Assert.assertEquals(text, "Product added");
			driver.get(prop.getProperty("url"));
			utils.HandleClickEvent(driver, monitorsPage.btn_monitors);
			Thread.sleep(2000);	
		}

		hm.link_cart.click();
		Thread.sleep(5000);

	}

	@Test(dependsOnMethods ="monitorTest",enabled = false)

	public void laptoptoCart() throws InterruptedException
	{
		List<WebElement> monitor=monitorsPage.listMonitors();
		appCommonModules.login();
		Thread.sleep(2000);
		hm.link_cart.click();
		Thread.sleep(5000);
		int list=cartPage.getcartList();
		Assert.assertEquals(list, monitor.size());
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}


