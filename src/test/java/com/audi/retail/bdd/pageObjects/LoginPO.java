package com.audi.retail.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePage{
	
	@FindBy(css=".breadcrum h1")
    private WebElement headerLabel;
	
	@FindBy(css="#acc_login")
    private WebElement emailIdTextField;
	
	@FindBy(css="#acc_login_password")
    private WebElement passwordTextField;
	
	@FindBy(css=".track-order")
    private WebElement LoginButton;
	
	@FindBy(css=".large-error")
    private WebElement errorText;
	
	
	public void assertHeaderLabel(String labelText) {
		assertTextOnWebElement(headerLabel, labelText);	
	}
	
	public void enterEmailId(String email) {
			enterText(emailIdTextField, email);
	}
	
	public void enterPassword(String password) {
			enterText(passwordTextField, password);
	}
	
	public void clickOnLoginButton () {
		clickOnWebElement(LoginButton);
	}
	
	public void assertErrorPage(String errorMessage) {
		assertTextOnWebElement(errorText, errorMessage);
	}
	
}
