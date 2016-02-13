package com.evercoding.vacations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Create a new employee')]")
	WebElement lnkCreateNewEmployee;
	
	@FindBy(css = "#user_information>span>a")
	WebElement lnkLogout;

	@FindBy(css = ".flash_notice")
	WebElement lblMessageLoginSuccess;

	public MainPage(WebDriver driver) {
		this.driver = driver;

	}

	public CreateNewEmployee clickCreateNewEmployee() {

		lnkCreateNewEmployee.click();
		return PageFactory.initElements(driver, CreateNewEmployee.class);
	}
	
	
	public SignIn clickLogout() {
		lnkLogout.click();
		return PageFactory.initElements(driver, SignIn.class);
		
	}
	
	
	public void DeleteUser(String identification) {


		By lnkDeleteUser = By
				.xpath("//td[text()='"
						+ identification
						+ "']/following-sibling::td/a[contains(@data-method,'delete')]");
		driver.findElement(lnkDeleteUser).click();
		driver.switchTo().alert().accept();
	}

	public String getSuccesfullyLogin() {

		String successMessage = lblMessageLoginSuccess.getText();

		return successMessage;
	}



}
