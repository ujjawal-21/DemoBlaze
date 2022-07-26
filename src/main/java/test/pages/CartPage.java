package test.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//==================Cart================//


	@FindBy(xpath="//div[@class='table-responsive']//tbody/tr")
	public List<WebElement> table_cart;

	public int getcartList() {

		int rows=table_cart.size();
		return rows;

	}
	@FindBy(xpath="//div[@class='table-responsive']//tbody/tr/td[4]/a")
	public WebElement btn_delete;

	@FindBy(xpath="//tbody[@id='tbodyid']//child::td[3]")
	public List<WebElement> totalProductsAdded;
	
	@FindBy(xpath = "//button[@data-target='#orderModal']")
	public WebElement btn_placeOrder;
	
	@FindBy(id = "name")
	public WebElement txtBox_name;
	
	@FindBy(id = "country")
	public WebElement txtBox_country;
	
	@FindBy(id = "city")
	public WebElement txtBox_city;
	
	@FindBy(id = "card")
	public WebElement txtBox_creditCard;
	
	@FindBy(id = "month")
	public WebElement txtBox_month;
	
	@FindBy(id = "year")
	public WebElement txtBox_year;
	
	@FindBy(xpath = "//div[@id='orderModal']//child::button[text()='Close']")
	public WebElement btn_purchaseClose;
	
	@FindBy(xpath = "//div[@id='orderModal']//child::button[text()='Purchase']")
	public WebElement btn_purchase;
	
	@FindBy(xpath = "//div[@id='orderModal']//child::span")
	public WebElement link_purchaseCross;
	
	@FindBy(id = "totalp")
	public WebElement txt_totalPrice;
	
	//=============Confirmation Msg=============//
	
	@FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
	public WebElement txt_confirmation;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement btn_ok;

}
