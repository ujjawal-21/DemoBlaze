package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.libraries.Base;
import test.libraries.Utilities;
import test.pages.HomePageModules;
import test.pages.LaptopPage;

public class LaptopTest extends Base {
	
	Utilities utils;
	HomePageModules hm;
	LaptopPage laptopPage;
	
	@BeforeMethod
	public void initialization() {
		init();
		hm = new HomePageModules(driver);
		utils = new Utilities();
		laptopPage=new LaptopPage(driver);
	}
	
	@Test
	public void Laptoptest() throws InterruptedException {
		
		utils.loadPage(driver);
		utils.HandleClickEvent(driver, laptopPage.btn_laptop);
		Thread.sleep(5000);
		List<WebElement> str=laptopPage.getList();
		System.out.println(str.toString());
		for(int i=1;i<str.size();i++)
		{
			System.out.println(i);
			str=laptopPage.getList();
			Thread.sleep(2000);
			str.get(i-1).click();
			Thread.sleep(2000);
			laptopPage.btn_addtocart.click();
			Thread.sleep(2000);
			String text=utils.Alerttext(driver);
			Assert.assertEquals(text, "Product added");
			utils.HandleAlertEvent(driver);
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(5000);
			utils.HandleClickEvent(driver, laptopPage.btn_laptop);
			
			
		}
		
		
	}

}
