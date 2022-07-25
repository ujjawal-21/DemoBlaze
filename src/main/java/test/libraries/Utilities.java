package test.libraries;

import org.openqa.selenium.JavascriptExecutor;
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
<<<<<<< HEAD
		
		public void JSExecutorScrollIntoView(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
=======

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

>>>>>>> 0099bd5e7bf40b37b9c0ad4e14cb84d46b212ce2
}
