package com.qa.quickstart.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage {
	
	@FindBy(id = "menu_pim_viewPimModule") private WebElement pimButton;
	
	

	public void goToPim(Actions action) throws InterruptedException {
		action.click(pimButton).perform();
	}

}
