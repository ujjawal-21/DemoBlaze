package test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage {
	
	public LaptopPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-lg-3']//a[3]")
	public WebElement btn_laptop;
	
	@FindBy(xpath="//div[@class='card-block']//child::h4//child::a")
	public List<WebElement> links_laptops;
	
	@FindBy(xpath="//button[@value='1']")
	public WebElement btn_previous;
	
	@FindBy(xpath="//button[@value='9']")
	public WebElement btn_next;
		
	@FindBy(xpath="//div[@class='col-sm-12 col-md-6 col-lg-6']/a")
	public WebElement btn_addtocart;
	
	@FindBy(xpath = "//tbody[@id='tbodyid']//child::td[2]")
	public List<WebElement> txt_lapName;
	
	public List<WebElement> getList(){
		List<WebElement> list=new ArrayList<>();
		for(WebElement cl:links_laptops)
		{
			list.add(cl);
			System.out.println(list);
		}
		return list;
		
	}
	

}
