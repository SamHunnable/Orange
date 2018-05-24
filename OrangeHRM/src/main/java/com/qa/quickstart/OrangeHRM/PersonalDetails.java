package com.qa.quickstart.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetails {
	
	
	@FindBy(xpath = "//*[@id=\"profile-pic\"]/h1") private WebElement firstName;
	
	
	
	public String getFirstName() {
		return firstName.getText();
	}

}
