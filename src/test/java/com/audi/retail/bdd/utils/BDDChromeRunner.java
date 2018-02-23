package com.audi.retail.bdd.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.audi.retail.bdd.utils.WebConnector.Browsers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@smoke-test", 
                 features = "src/test/resources/com/audi/retail/bdd/features",
                 monochrome = true,  
                 strict = true, 
                	// dryRun = true,
                 format = {"pretty", "html:target/cucumber" }, 
                 glue = { "com.audi.retail.bdd.stepDefs"})

public class BDDChromeRunner {
	
	@BeforeClass
	public static void setUp() {
		WebConnector.getInstance().initialiseDriver(Browsers.valueOf("Chrome"));
	}

	@AfterClass
	public static void tearDown() {
		WebConnector.driver.quit();
	}

}
