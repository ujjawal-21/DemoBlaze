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

	@FindBy(xpath="//div[@class='table-responsive']//tbody/tr")
	public List<WebElement> table_cart;

	public int getcartList() {

		int rows=table_cart.size();
		return rows;

	}
	@FindBy(xpath="//div[@class='table-responsive']//tbody/tr/td[4]/a")
	public WebElement btn_delete;
}
