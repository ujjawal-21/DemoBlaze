package test.libraries;

import test.pages.AddToCartPage;
import test.pages.HomePageModules;
import test.pages.PhonesModule;

public class AppCommonModules extends Base{

	Utilities utils;
	HomePageModules hm;
	PhonesModule pm;
	AddToCartPage cart;
	
	public void login() {
		hm = new HomePageModules(driver);
		utils = new Utilities();
		utils.HandleClickEvent(driver, hm.link_login);
		utils.HandleVisibilityOfElements(driver, hm.txtBox_usrnm);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username"));
		utils.HandleVisibilityOfElements(driver, hm.txtBox_psswrd);
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
	}
}
