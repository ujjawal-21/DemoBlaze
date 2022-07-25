package test.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {

	private void syncEvents(WebDriver driver, WebElement element, String string) {
		switch(string) {
			case "To Be Clickable":
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
				break;
				
			case "To Be Visible":
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
				break;
				
			case "Alert Is Present":
				new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
				break;
		}
		
	}
	
	public void HandleClickEvent(WebDriver driver, WebElement element) {
		syncEvents(driver, element, "To Be Clickable");
		element.click();
	}
	
	public void HandleVisibilityOfElements(WebDriver driver, WebElement element) {
		syncEvents(driver, element, "To Be Visible");
	}
	
	public String HandleAlert(WebDriver driver) {
		syncEvents(driver, null, "Alert Is Present");
		String msg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return msg;
	}
}
