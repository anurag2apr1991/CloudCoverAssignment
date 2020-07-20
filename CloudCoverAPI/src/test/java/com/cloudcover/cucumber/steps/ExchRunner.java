package com.cloudcover.cucumber.steps;

import org.junit.runner.RunWith;

import com.cloudcover.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		dryRun=false,
		strict=true,
		monochrome=false,
		features = "src/test/resources/feature/",
		//glue = "steps",		
				tags= {"@StackExchange"}
		
		)
public class ExchRunner extends TestBase{

}
