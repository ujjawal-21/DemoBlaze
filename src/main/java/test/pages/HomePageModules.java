package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageModules {

	public HomePageModules(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li//following::a[@id='signin2']")
	public WebElement btn_signUp;
	
	@FindBy(id = "sign-username")
	public WebElement txtBox_username;
	
	@FindBy(id = "sign-password")
	public WebElement txtBox_password;
	
	@FindBy()
	public WebElement btn_close;
	
	@FindBy()
	public WebElement btn_register;
}
