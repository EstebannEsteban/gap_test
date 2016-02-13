package com.evercoding.vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PublicSite {

	WebDriver driver;

	@FindBy(css = "#employee_identification")
	WebElement txtEmployeeIdentification;

	@FindBy(css = ".actions>input")
	WebElement btnFindEmployee;

	public PublicSite(WebDriver driver) {
		this.driver = driver;

	}

	public FindEmployee FindEmployee(String identification) {

		setIdentification(identification);
		ClickFindEmployee();
		return PageFactory.initElements(driver, FindEmployee.class);
	}

	public void setIdentification(String identification) {
		txtEmployeeIdentification.sendKeys(identification);
	}

	public void ClickFindEmployee() {
		btnFindEmployee.click();
	}
}
