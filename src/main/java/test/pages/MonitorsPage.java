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
	public List<WebElement> btn_monitors;
	
	public List<WebElement>listMonitors() {
		
		List<WebElement> list=new ArrayList<>();
		for(WebElement mon:btn_monitors)
		{
			list.add(mon);
		}
		return list;
	}
}
