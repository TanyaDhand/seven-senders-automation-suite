package com.komoot.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.komoot.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@class=\"tw-inline-flex tw-justify-center tw-items-center c-btn c-btn--primary-inv\"]//span[contains(text(), 'Sign up or log in')]")
	WebElement Signup;

	@FindBy(xpath = "//*[@class='tw-inline-flex tw-justify-center tw-items-center c-btn c-btn--primary-inv']//span[text()='Sign up or log in']")
	WebElement signupLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public SignupPage signupLink() {
		driver.manage().deleteAllCookies();
		Actions action = new Actions(driver);
		action.click(signupLink).build().perform();
		return new SignupPage();
	}
}
