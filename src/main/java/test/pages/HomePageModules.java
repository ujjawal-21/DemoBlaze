package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageModules {

	public HomePageModules(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//================Sign Up Module=====================//
	@FindBy(xpath = "//li//following::a[@id='signin2']")
	public WebElement btn_signUp;
	
	@FindBy(id = "sign-username")
	public WebElement txtBox_username;
	
	@FindBy(id = "sign-password")
	public WebElement txtBox_password;
	
	@FindBy(xpath = "//div[@id='signInModal']//child::button[text()='Close']")
	public WebElement btn_close;
	
	@FindBy(xpath = "//div[@id='signInModal']//child::button[text()='Sign up']")
	public WebElement btn_register;
	
	@FindBy(xpath = "//div[@id='signInModal']//child::span")
	public WebElement btn_cross;
	
	//=====================Login Module================//
	@FindBy(id = "login2")
	public WebElement btn_login;
	
	@FindBy(xpath = "//div[@id='logInModal']//child::span")
	public WebElement link_cross;
	
	@FindBy(id = "loginusername")
	public WebElement txtBox_usrnm;
	
	@FindBy(id = "loginpassword")
	public WebElement txtBox_psswrd;
	
	@FindBy(xpath = "//div[@id='logInModal']//child::button[text()='Close']")
	public WebElement btn_dismiss;
	
	@FindBy(xpath = "//div[@id='logInModal']//child::button[text()='Log in']")
	public WebElement btn_signIn;
	
	@FindBy(id = "nameofuser")
	public WebElement txt_user;
}
