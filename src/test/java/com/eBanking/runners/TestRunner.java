 package com.eBanking.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
                 glue = {"com.eBanking.stepDefinitions", "com.eBanking.hooks"},
                		 tags = "@Userregistration",
                 plugin = {"pretty", "html:target/cucumber-reports/reports.html",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 dryRun = true,
                 monochrome = true
)



public class TestRunner{
	
}
