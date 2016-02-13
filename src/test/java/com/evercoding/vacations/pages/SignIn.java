package com.evercoding.vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

	WebDriver driver;

	@FindBy(css = "#user_email")
	WebElement txtUserEmail;

	@FindBy(css = "#user_password")
	WebElement txtUserPassword;

	@FindBy(css = ".submit")
	WebElement btnSignIn;

	@FindBy(css = "#content>p>a")
	WebElement lnkPublicSite;

	public SignIn(WebDriver driver) {
		this.driver = driver;

	}

	public void go() {

		driver.get("http://vacations.evercoding.com/");

	}


	public MainPage Login(String UserEmail,
			String UserPassword) {

		setTxtUserEmail(UserEmail);
		setTxtUserPassword(UserPassword);
		clickLoginButton();

		return PageFactory.initElements(driver, MainPage.class);
	}


	public PublicSite clickPublicSite() {

		lnkPublicSite.click();
		return PageFactory.initElements(driver, PublicSite.class);
	}

	/**
	 * @param txtUserEmail
	 *            the txtUserEmail to set
	 */
	public void setTxtUserEmail(String UserEmail) {
		txtUserEmail.sendKeys(UserEmail);
	}

	/**
	 * @param txtUserPassword
	 *            the txtUserPassword to set
	 */
	public void setTxtUserPassword(String UserPassword) {
		txtUserPassword.sendKeys(UserPassword);
	}

	/**
	 * 
	 */
	public void clickLoginButton() {
		btnSignIn.click();
	}



}
