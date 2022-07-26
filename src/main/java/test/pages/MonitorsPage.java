package test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorsPage {
	
	public MonitorsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='cat']//following-sibling::a[text()='Monitors']")
	public WebElement link_monitors;
	
	@FindBy(xpath="//div[@class='card-block']//child::h4//child::a")
	public List<WebElement> links_Totalmonitors;
	
	@FindBy(xpath="//div[@class='col-sm-12 col-md-6 col-lg-6']/a")
	public WebElement btn_cart;
	
	@FindBy(xpath = "//div[@class='card h-100']")
	public List<WebElement> products;
}
