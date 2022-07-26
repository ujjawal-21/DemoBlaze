package test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonesModule {
	public PhonesModule(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='cat']//following-sibling::a[text()='Phones']")
	public WebElement link_phones;
	
	@FindBy(xpath = "//div[@class='card-block']//child::h4//child::a")
	public List<WebElement> link_phoneName;
	
	@FindBy(xpath = "//div[@class='card h-100']")
	public List<WebElement> products;
}

