package com.selenium.steps;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// passes object of webconnecter in both classes. Same object
// same object for 1 scenario
import com.selenium.webdriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppSteps{
	
	WebConnector con;
	
	public AppSteps(WebConnector con) {
		this.con=con;
	}
	
	@Then("^Login should be (.*)$")
	public void validateLogin(String expectedResult) {
		con.validateLogin(expectedResult);
	}

	@And("^I Login inside application$")
	public void login(List<String> data) {
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		con.login(data.get(0),data.get(1));
		
	}
	        
	@When("^List of tags (.*) loc (\\d+) rd tag (.*) click$")
	public void clicktagFromListofTags(String tagLinkBase_xpath, int n, String tagLink_xpath)
	{				
		List<WebElement> e =con.getObjectsList(tagLinkBase_xpath);
		e.get(n).findElement(By.xpath(con.getProperty(tagLink_xpath))).click();
		con.infoLog(n+"th tag is successfully clicked with locator "+tagLink_xpath);
		System.out.println("Element clicked");
	}	
			
	@Then("^Count the total no of questions (.*)$")
	public void CountTotalnoOfQuestions(String newest_count_xpath)
	{
		String totalNewestQuestions = con.getObject(newest_count_xpath).getText();
		con.infoLog("Total Count of newest question asked is : "+ totalNewestQuestions);
		System.out.println("Total Count of newest question asked is : "+ totalNewestQuestions);				
	}
	
	
}
