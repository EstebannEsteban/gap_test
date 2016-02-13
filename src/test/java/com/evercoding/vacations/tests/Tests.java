package com.evercoding.vacations.tests;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evercoding.vacations.pages.CreateNewEmployee;
import com.evercoding.vacations.pages.EmployeeCreated;
import com.evercoding.vacations.pages.FindEmployee;
import com.evercoding.vacations.pages.MainPage;
import com.evercoding.vacations.pages.PublicSite;
import com.evercoding.vacations.pages.SignIn;

public class Tests {

	WebDriver driver;
	SignIn home = new SignIn(driver);

	@BeforeMethod
	public void before() {


		driver = new FirefoxDriver();
		home = PageFactory.initElements(driver, SignIn.class);
		home.go();

	}

	@AfterMethod
	public void after() {
		// driver.quit();
	}

	/*
	 * Test Login correctly
	 */
	@Test(timeOut = 30000)
	public void testLoginPage() {

		MainPage mainPage = home.Login("gap-automation-test@mailinator.com",
				"12345678");
		CreateNewEmployee createEmployee = mainPage
.clickCreateNewEmployee();
		EmployeeCreated employeeCreated = createEmployee.CreateEmployee(
				"James", "Smith", "jamessmith@cuvox.de", "12345678",
				"Esteban Ibarguen", "2010", "01", "21");
		Assert.assertEquals("Employee was successfully created.",
				employeeCreated.getCreationMessage());
		employeeCreated.clickBack();
		home = mainPage.clickLogout();
		PublicSite publicSite = home.clickPublicSite();
		FindEmployee findEmployee = publicSite.FindEmployee("12345678");

		Assert.assertEquals("Hi James Smith,",
				findEmployee.getMessageEmployeeFoundNotFound());
		findEmployee.ClickLogo();
		home.Login("gap-automation-test@mailinator.com", "12345678");
		mainPage.DeleteUser("12345678");
		mainPage.clickLogout();
		home.clickPublicSite();
		publicSite.FindEmployee("12345678");
		Assert.assertEquals("No Employee found with that identification",
				findEmployee.getMessageEmployeeFoundNotFound());
	}

}
