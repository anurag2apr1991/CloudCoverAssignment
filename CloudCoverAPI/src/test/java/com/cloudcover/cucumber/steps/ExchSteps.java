package com.cloudcover.cucumber.steps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cloudcover.cucumber.serenity.ExchangeSerenitySteps;
import com.cloudcover.utils.TestUtils;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class ExchSteps {
	static String email=null;
	
	@Steps
	ExchangeSerenitySteps steps;
					
	
	@When("^Get badge by (\\d+)$")
	public void Get_badge_by(int badgeId)
	{
		SerenityRest.rest()
		.given().queryParam("site", "stackoverflow")
		.when()
		.get("/"+badgeId)
		.then()
		.statusCode(200);		
	}	
	       
	@When("^GET badges by badge id (\\d+) response status code (\\d+)$")
	public void GetBadgesById(int badgeId, int statusCode)
	{
		SerenityRest.rest()
		.given().queryParam("site", "stackoverflow")
		.when()
		.get("/"+badgeId)
		.then()
		.statusCode(statusCode);
	}	
	       
	@When("^I get all badges page (.*) pageSize (.*) site (.*) verify status (.*)$")	
	public void getAllBadges(int page, int pageSize, String site, int status){
		String page_string = Integer.toString(page); 
		String pageSize_string = Integer.toString(pageSize);
		
		steps.getBadgesApi(page_string, pageSize_string, site)
		.body(matchesJsonSchema(TestUtils.getSchemaFile("GetSuccessResponseSchema.json")))
		.assertThat()
		 .statusCode(status);		
	}
			
	@When("^Negative Test get all badges page (.*) pageSize (.*) site (.*) verify status (.*) errror (.*)$")	
	public void getAllBadgesNegative(float page, float pageSize, String site, int status, String error_message){
		String page_string = String.valueOf(page); 
		String pageSize_string = String.valueOf(pageSize);

		steps.getBadgesApi(page_string, pageSize_string, site)
		.body("error_message", equalTo (error_message))
		.body("error_name", equalTo ("bad_parameter"))		 
		 .assertThat()
		 .statusCode(status);		
	}
	
	
	@When("^I get badges name page (.*) pageSize (.*) site (.*) verify status (.*)$")	
	public void getBadgesName(int page, int pageSize, String site, int status){
		String page_string = Integer.toString(page); 
		String pageSize_string = Integer.toString(pageSize);
		RestAssured.basePath = "name";
		steps.getBadgesApi(page_string, pageSize_string, site)
		 .assertThat()
		 .statusCode(status);		
	}
	   		
	@When("^Negative Test get badges name page (.*) pageSize (.*) site (.*) verify status (.*) errror (.*)$")	
	public void getBadgesNameNegative(float page, float pageSize, String site, int status, String error_message){
		String page_string = String.valueOf(page); 
		String pageSize_string = String.valueOf(pageSize);
		RestAssured.basePath = "name";

		steps.getBadgesApi(page_string, pageSize_string, site)
		.body("error_message", equalTo (error_message))
		.body("error_name", equalTo ("bad_parameter"))
		 .assertThat()
		 .statusCode(status);		
	}
	
	int bedge_id;
	@Given ("^Get the id (.*)$")
	public void getId(int id){ bedge_id = id; }
	
	@When("^I get badges recipients by page (.*) pageSize (.*) site (.*) verify status (.*)$")	
	public void getBadgesRecipientsById(int page, int pageSize, String site, int status){
		String page_string = Integer.toString(page); 
		String pageSize_string = Integer.toString(pageSize);
		RestAssured.basePath = bedge_id+"/recipients";
		steps.getBadgesApi(page_string, pageSize_string, site)
		 .assertThat()
		 .statusCode(status);		
	}
	   		
	@When("^Negative Test get badges recipients by page (.*) pageSize (.*) site (.*) verify status (.*) errror (.*)$")	
	public void getBadgesRecipientsByIdNegative(float page, float pageSize, String site, int status, String error_message){
		String page_string = String.valueOf(page); 
		String pageSize_string = String.valueOf(pageSize);
		RestAssured.basePath = bedge_id+"/recipients";

		steps.getBadgesApi(page_string, pageSize_string, site)
		.body("error_message", equalTo (error_message))
		.body("error_name", equalTo ("bad_parameter"))
		 .assertThat()
		 .statusCode(status);		
	}
	//@Then("^I verify response error_message (.*)")	

}
