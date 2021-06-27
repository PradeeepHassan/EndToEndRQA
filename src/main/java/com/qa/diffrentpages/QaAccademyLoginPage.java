package com.qa.diffrentpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaAccademyLoginPage {
	
	@FindBy(id = "user_email")
	private WebElement userEmailId;
	
	@FindBy(id = "user_password")
	private WebElement userPassword;
	
	@FindBy(xpath = "(//div/input)[3]")
	private WebElement signinbutton;
	
	public QaAccademyLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginCredential(String un, String ps) {
		userEmailId.sendKeys(un);
		userPassword.sendKeys(ps);
		signinbutton.click();
	}

}
