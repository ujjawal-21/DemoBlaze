package test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorsPage {
	
	public MonitorsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-lg-3']//a[4]")
	public WebElement btn_monitors;
	
	@FindBy(xpath="//div[@class='card-block']//child::h4//child::a")
	public List<WebElement> links_monitors;
	
	@FindBy(xpath="//div[@class='col-sm-12 col-md-6 col-lg-6']/a")
	public WebElement btn_cart;
	
	public List<WebElement>listMonitors() {
		
		List<WebElement> list=new ArrayList<>();
		for(WebElement mon:links_monitors)
		{
			list.add(mon);
		}
		return list;
	}
}
