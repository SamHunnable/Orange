package com.qa.quickstart.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "txtUsername") private WebElement username;
	@FindBy(id = "txtPassword") private WebElement password;
	@FindBy(id = "btnLogin") private WebElement loginButton;
	
	
	public void login(Actions action) {
		action.click(username).sendKeys("Admin").perform();
		action.click(password).sendKeys("admin").perform();
		action.click(loginButton).perform();
		
	}
}
