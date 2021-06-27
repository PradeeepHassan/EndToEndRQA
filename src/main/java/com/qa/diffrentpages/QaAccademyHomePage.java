package com.qa.diffrentpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaAccademyHomePage {
	
	@FindBy(xpath = "//button[text()='NO THANKS']")
	private WebElement closePopUpbutton;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='text-center']/h2")
	private WebElement homeTextCheck;
	
	@FindBy(xpath = "//a[text()='Contact']")
	private WebElement checkContact;
	
	public QaAccademyHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void handlingHomePagePopup() {
		
		closePopUpbutton.click();
	}
	
	public void clickLoginButton() {
		
		loginButton.click();
	}
	
	public String checkText() {
		
		return homeTextCheck.getText();
	}
	
	public boolean contactCheck() {
		
	 return 	checkContact.isDisplayed();
	}
	
	}
	


