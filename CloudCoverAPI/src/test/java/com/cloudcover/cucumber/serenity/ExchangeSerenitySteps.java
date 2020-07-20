package com.cloudcover.cucumber.serenity;

import java.util.HashMap;

import com.cloudcover.utils.ReuseSpecs;
import com.cloudcover.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ExchangeSerenitySteps {
	
	@Step("get all badges page:{0}, pageSize:{1}, site:{2}")
	public ValidatableResponse getBadgesApi(String page, String pageSize, String site){
		
		HashMap<String, String> map = TestUtils.urlParameterMap(page, pageSize, site);
						
	return	SerenityRest.rest().given().contentType(ContentType.JSON)
		.spec(ReuseSpecs.getGenericRequest(map))
		.get().then()
		.log().all();	 
	}

}

