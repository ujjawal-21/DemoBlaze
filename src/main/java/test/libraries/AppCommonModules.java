package test.libraries;

import test.pages.HomePageModules;

public class AppCommonModules extends Base {
	HomePageModules hm;
	Utilities utils;
	public void Login() {
		hm = new HomePageModules(driver);
		utils = new Utilities();
		utils.HandleClickEvent(driver, hm.link_login);
		hm.txtBox_usrnm.sendKeys(prop.getProperty("username"));
		hm.txtBox_psswrd.sendKeys(prop.getProperty("password"));
		utils.HandleClickEvent(driver, hm.btn_signIn);
	}
}
