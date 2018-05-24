package com.qa.quickstart.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.*;
import cucumber.api.java.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeTesting {
	
	
	WebDriver driver;
	Actions action;
	AddEmployee addEmployee;
	LoginPage loginPage;
	ExtentReports extent;
	ExtentTest test;
	
	@Before					//This is broken and does not run
	private void setup() {					
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		action = new Actions(driver);
		System.out.println("Before ran");
	}
	
	@After					//This is broken and does not run
	private void tearDown() {
		extent.endTest(test);
		extent.flush();
		driver.quit();
		System.out.println("After ran");
	}
	
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws Throwable {
		
		extent = new ExtentReports("C:\\Users\\Admin\\git\\Orange\\Report.html", true);
		test = extent.startTest("Scenario 1");
		test.log(LogStatus.INFO, "Scenario 1 has started");
		
		System.setProperty("webdriver.chrome.driver", Constants.pathToWebDriver);
		driver = new ChromeDriver();	
		action = new Actions(driver);
		
	    driver.get(Constants.loginPage);
	    
	    loginPage = PageFactory.initElements(driver, LoginPage.class);
	    loginPage.login(action);
	    
	    DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
	    dashboard.goToPim(action);
	    Thread.sleep(1000);
	    
	    PIMPage pim = PageFactory.initElements(driver, PIMPage.class);
	    pim.goToAddEmployee(action);
	    Thread.sleep(1000);
	    
	    addEmployee = PageFactory.initElements(driver, AddEmployee.class); 
		
//		assertEquals("Add Employee" , addEmployee.getHeading());
//		String expected = "Add Employee";
//		if (expected.equals(addEmployee.getHeading())) {
//			test.log(LogStatus.PASS, "On add employee page");
//		}
//		else {
//			test.log(LogStatus.FAIL, "Not on add employee page");
//		}
	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() throws Throwable {
		addEmployee.fillDetails(action);
//		String testname = "John";
//		assertEquals(testname, addEmployee.getFirstName());
//		if (testname.equals(addEmployee.getHeading())) {
//			test.log(LogStatus.PASS, "On add employee page");
//		}
//		else {
//			test.log(LogStatus.FAIL, "Not on add employee page");
//		}
//	    
	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() throws Throwable {
	   addEmployee.activateLoginDetails(action);
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws Throwable {
	     addEmployee.fillLoginDetails(action);
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {
	   addEmployee.save(action);
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() throws Throwable {
		//Thread.sleep(5000);
		PersonalDetails pd = PageFactory.initElements(driver, PersonalDetails.class);
		assertEquals("John Doe", pd.getFirstName());
		
		
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}



}
