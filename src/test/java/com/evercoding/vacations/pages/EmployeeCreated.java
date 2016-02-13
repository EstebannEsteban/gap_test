package com.evercoding.vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeCreated {

	WebDriver driver;

	@FindBy(css = "#notice")
	WebElement lblEmployeeCreatedSuccesfully;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement lblBack;

	public EmployeeCreated(WebDriver driver) {
		this.driver = driver;

	}
	public String getCreationMessage() {
		String succesfulMessage = lblEmployeeCreatedSuccesfully.getText();
		return succesfulMessage;
	}

	public MainPage clickBack() {
		lblBack.click();
		return PageFactory.initElements(driver, MainPage.class);

	}
}
