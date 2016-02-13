package com.evercoding.vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewEmployee {

	WebDriver driver;
	
	@FindBy(css = "#employee_first_name")
	WebElement txtEmployeeFirstName;

	@FindBy(css = "#employee_last_name")
	WebElement txtEmployeeLastName;

	@FindBy(css = "#employee_email")
	WebElement txtEmployeeEmail;

	@FindBy(css = "#employee_identification")
	WebElement txtEmployeeIdentification;

	@FindBy(css = "#employee_leader_name")
	WebElement txtEmployeeLeaderName;

	@FindBy(css = "#employee_start_working_on_1i")
	WebElement txtDateYear;

	@FindBy(css = "#employee_start_working_on_2i")
	WebElement txtDateMonth;

	@FindBy(css = "#employee_start_working_on_3i")
	WebElement txtDateDay;

	@FindBy(css = ".actions>input")
	WebElement btnCreateEmployee;

	public CreateNewEmployee(WebDriver driver) {
		this.driver = driver;

	}

	public EmployeeCreated CreateEmployee(String firstName,
			String lastName, String email,
			String identification, String leaderName, String year,
			String month, String day) {

		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setIdentification(identification);
		setLeaderName(leaderName);
		setYear(year);
		setMonth(month);
		setDay(day);
		ClickCreateEmployee();
		return PageFactory.initElements(driver, EmployeeCreated.class);
	}

	public void setFirstName(String firstName) {
		txtEmployeeFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		txtEmployeeLastName.sendKeys(lastName);
	}

	public void setEmail(String email) {
		txtEmployeeEmail.sendKeys(email);
	}

	public void setIdentification(String identification) {
		txtEmployeeIdentification.sendKeys(identification);
	}

	public void setLeaderName(String leaderName) {
		txtEmployeeLeaderName.sendKeys(leaderName);
	}

	public void setYear(String year) {
		txtDateYear.sendKeys(year);
	}

	public void setMonth(String month) {
		txtDateMonth.sendKeys(month);
	}

	public void setDay(String day) {
		txtDateDay.sendKeys(day);
	}

	public void ClickCreateEmployee() {
		btnCreateEmployee.click();
	}
}
