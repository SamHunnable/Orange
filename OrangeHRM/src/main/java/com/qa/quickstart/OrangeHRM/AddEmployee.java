package com.qa.quickstart.OrangeHRM;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {
	
	@FindBy(id = "content") private WebElement addEmployeeHeader;
	@FindBy(id = "firstName") private WebElement firstName;
	@FindBy(id = "lastName") private WebElement lastName;
	@FindBy(id = "chkLogin") private WebElement logInDetailsButton;
	@FindBy(id = "user_name") private WebElement userName;
	@FindBy(id = "btnSave") private WebElement saveButton;
	@FindBy(id = "user_password") private WebElement password;
	@FindBy(id = "re_password") private WebElement confirmPassword;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/h1") private WebElement heading;
	
	
	
	
	public String findHeader(WebDriver driver) {
		return addEmployeeHeader.getText();
	}
	
	
	public void fillDetails(Actions action) {
		action.click(firstName).sendKeys("John").perform();
		action.click(lastName).sendKeys("Doe").perform();		
	}
	
	
	public void activateLoginDetails(Actions action) {
		action.click(logInDetailsButton).perform();
	}
	
	
	public String fillLoginDetails(Actions action) {
		
		String username = UUID.randomUUID().toString();
		
		System.out.println("username was " + username);
		
		action.click(userName).sendKeys(username);	
		action.click(password).sendKeys("password");
		action.click(confirmPassword).sendKeys("password");
		return username;
	}
	
	
	public void save(Actions action) {
		action.click(saveButton).perform();
	}
	
	public String getHeading() {
		return heading.getText();
	}
	
	public String getFirstName() {
		return firstName.getText();
	}
	

}
