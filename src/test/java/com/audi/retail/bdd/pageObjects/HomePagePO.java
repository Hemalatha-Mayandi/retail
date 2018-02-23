package com.audi.retail.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePO extends BasePage{
	
	@FindBy(partialLinkText="Sign In")
    private WebElement signInLink;
	
	public void clickOnSignInLink() {
		clickOnWebElement(signInLink);
	}
}
