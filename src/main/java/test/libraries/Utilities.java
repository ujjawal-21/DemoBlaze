package test.libraries;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.pages.LaptopPage;


public class Utilities {

LaptopPage laptopPage;
	private void syncEvents(WebDriver driver, WebElement element, String string) {
		switch(string) {

		case "To Be Clickable":
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
			break;

		case  "To Alert":
			new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
			break;
			

						
			case "To Be Visible":
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
				break;
		}

		
		}

	

	public void HandleClickEvent(WebDriver driver, WebElement element) {
		syncEvents(driver, element, "To Be Clickable");
		element.click();
	}


	public void HandleAlertEvent(WebDriver driver) {
		syncEvents(driver, null, "To Alert");
		driver.switchTo().alert().accept();
	}
	
	
	
	public String Alerttext(WebDriver driver) {
		
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	public void loadPage(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	public void waitbyjse(WebDriver driver) {
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("return document.readyState").toString().equals("complete");
	}
	
	


	
	public void HandleVisibilityOfElements(WebDriver driver, WebElement element) {
		syncEvents(driver, element, "To Be Visible");
	}
}

