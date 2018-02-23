package com.audi.retail.bdd.stepDefs;

import org.openqa.selenium.support.PageFactory;

import com.audi.retail.bdd.pageObjects.HomePagePO;
import com.audi.retail.bdd.pageObjects.LoginPO;

import com.audi.retail.bdd.utils.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	HomePagePO homePagePO = PageFactory.initElements(WebConnector.driver, HomePagePO.class);

	LoginPO loginPO = PageFactory.initElements(WebConnector.driver, LoginPO.class);

	@Given("^I go to ToyRUs Home page$")
	public void i_go_to()  {
		homePagePO.navigateToHomePage();
	}

	@When("^I click on Sign In link$")
	public void i_click_on_Sign_In_Link()  {
		homePagePO.clickOnSignInLink();
	}
	
	@Then("^I should see \"([^\\\"]*)\" header label$")
	public void i_should_see_Header_Label(String label) {
		loginPO.assertHeaderLabel(label);
	}
	

	@And("^I enter my Email Address as \"([^\"]*)\"$")
	public void i_enter_my_Email_Address_as(String email)  {
		loginPO.enterEmailId(email);
	  
	}

	@And("^I enter my Password as \"([^\"]*)\"$")
	public void i_enter_my_Password_as(String password)  {
		loginPO.enterPassword(password);
	}

	@And("^I click on Login button$")
	public void i_click_on_Login_button()  {
		loginPO.clickOnLoginButton();
	}

	@Then("^I should go to the page \"([^\"]*)\"$")
	public void i_should_go_to_the_page(String errorMessage)  {
		loginPO.assertErrorPage(errorMessage);
	}
	

}
