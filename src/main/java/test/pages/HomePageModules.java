package test.pages;

import java.util.List;

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
	public WebElement link_signUp;
	
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
	public WebElement link_login;
	
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
	
	@FindBy(xpath = "//div[@id='navbarExample']//child::li//child::a[@id='nameofuser']")
	public WebElement txt_user;
	
	//============Cart============//
	
	@FindBy(xpath = "//div[@id='navbarExample']//child::li//child::a[@id='cartur']")
	public WebElement link_cart;
	
	//==============About Us================//
	
	@FindBy(xpath = "//div[@id='navbarExample']//child::li//child::a[@data-target='#videoModal']")
	public WebElement link_aboutUs;
	
	@FindBy(xpath = "//button[@title='Play Video']")
	public WebElement btn_playVid;
	
	@FindBy(xpath = "//div[@id='videoModal']//child::button[text()='Close']")
	public WebElement btn_closeAbtUs;
	
	@FindBy(xpath = "//div[@id='videoModal']//child::button[@class='close']")
	public WebElement link_AbtCross;
	
	//===============Contact==================//
	@FindBy(xpath = "//div[@id='navbarExample']//child::a[@data-target='#exampleModal']")
	public WebElement link_contact;
	
	@FindBy(xpath = "//div[@id='exampleModal']//child::span")
	public WebElement link_contactCross;
	
	@FindBy(id = "recipient-email")
	public WebElement txtBox_contactEmail; 
	
	@FindBy(id = "recipient-name")
	public WebElement txtBox_contactName;
	
	@FindBy(id = "message-text")
	public WebElement txtArea_msg; 
	
	@FindBy(xpath = "//div[@id='exampleModal']//child::button[text()='Close']")
	public WebElement btn_contactClose;
	
	@FindBy(xpath = "//div[@id='exampleModal']//child::button[text()='Send message']")
	public WebElement btn_sendMsg;
	
	//============Home============//
	@FindBy(xpath = "//div[@id='navbarExample']//child::a[@href='index.html']")
	public WebElement link_home;
	
	//===========Logo==============//
	
	@FindBy(id = "nava")
	public WebElement link_logo;
	
	//================Logout==============//
	
	@FindBy(id = "logout2")
	public WebElement link_logOut;
	
	//================Banner Slider===============//
	@FindBy(xpath = "//a[@data-slide='next']//following::span[@class='carousel-control-next-icon']")
	public WebElement link_next;
	
	@FindBy(xpath = "//a[@data-slide='prev']//following::span[@class='carousel-control-prev-icon']")
	public WebElement link_prev;
	
	@FindBy(xpath = "//img[@class='d-block img-fluid']")
	public List<WebElement> TotalBanners;
	
	//===============Next list=================//
	@FindBy(id = "next2")
	public WebElement btn_next;
	
	//===============Previous List===============//
	@FindBy(id = "prev2")
	public WebElement btn_prev;
}
