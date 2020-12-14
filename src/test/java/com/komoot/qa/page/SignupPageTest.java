package com.komoot.qa.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.komoot.qa.base.TestBase;

public class SignupPageTest extends TestBase {

	SearchPage search;
	SignupPage signup;

	public SignupPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		super.initialization();
		signup = new SignupPage();
		search = new SearchPage();
	}

	@Test(priority = 3)
	public void signupLoginTest() {
		signup.clickOnSubmitButton(prop.getProperty("email"), prop.getProperty("password"));
		// WebDriverWait wait = new WebDriverWait(driver, 100);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tw-text-right']//span[text()='Sign
		// up or log in']")));

		assertEquals(signup.verifySignupPageTitle(), "Komoot Sign-Up | Login To The Great Outdoors");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		signup.clickOnSubmitButton(prop.getProperty("email"), prop.getProperty("password"));
		assertEquals(search.verifyUserName(), prop.getProperty("username"));
	}

	@Test(priority = 1)
	public void verifyInvalidUserTest() {
		signup.verifyInvalidUser(prop.getProperty("email"), prop.getProperty("wrongpassword"));
		String text = signup.verifyLinkText();
		assertEquals(text,
				"Unfortunately we couldn’t log you in. Please verify your email and password and try again.");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
