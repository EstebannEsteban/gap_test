package com.evercoding.vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindEmployee {
	WebDriver driver;
	@FindBy(css = "#content>h1")
	WebElement txtMessageEmployeeFoundNotFound;

	@FindBy(css = "#logo_text>h1>a>img")
	WebElement imgLogo;

	public FindEmployee(WebDriver driver) {
		this.driver = driver;

	}
	public String getMessageEmployeeFoundNotFound() {
		String greeting = txtMessageEmployeeFoundNotFound.getText();
		return greeting;
	}

	public SignIn ClickLogo() {
		imgLogo.click();
		return PageFactory.initElements(driver, SignIn.class);
	}
}
