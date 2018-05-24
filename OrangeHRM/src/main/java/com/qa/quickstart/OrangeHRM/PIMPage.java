package com.qa.quickstart.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PIMPage {
	
	@FindBy(id = "menu_pim_addEmployee") private WebElement addEmployeeButton;
	
	public void goToAddEmployee(Actions action) throws InterruptedException {
		action.click(addEmployeeButton).perform();
	}


}
