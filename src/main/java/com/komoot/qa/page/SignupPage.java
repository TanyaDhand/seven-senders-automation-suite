package com.komoot.qa.page;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.komoot.qa.base.TestBase;
import com.komoot.qa.util.TestUtil;

public class SignupPage extends TestBase {

	@FindBy(id = "email")
	WebElement email;

	@FindBy(className = "css-qbizf4")
	WebElement emailLink;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(className = "css-qbizf4")
	WebElement submitLink;

	@FindBy(xpath = "//*[@class='tw-text-right']//span[text()='Sign up or log in']")
	WebElement signupLink;

	@FindBy(linkText = "Sign up or log in")
	WebElement sign;

	@FindBy(xpath = "//div[text()= 'Tanya']")
	WebElement userName;

	@FindBy(xpath = "//span[@class='icon-action-more tw-inline-flex tw-items-center tw-justify-center tw-text-inherit']")
	WebElement logoutLink;

	@FindBy(xpath = "//a[text()='Log Out']")
	WebElement logoutClick;

	@FindBy(xpath = "//p[contains(text(),'Unfortunately we couldn’t log you in. Please verify your email and password and try again.')]")
	WebElement links;

	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

	public SearchPage clickOnSubmitButton(String em, String pw) {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		Actions action = new Actions(driver);
		action.click(signupLink).build().perform();
		email.sendKeys(em);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		emailLink.click();
		password.sendKeys(pw);
		submitLink.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		return new SearchPage();
	}

	public String verifySignupPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userName.isDisplayed();
	}

	public void verifyInvalidUser(String em, String pw) {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		Actions action = new Actions(driver);
		action.click(signupLink).build().perform();
		email.sendKeys(em);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		emailLink.click();
		password.sendKeys(pw);
		submitLink.click();
		links.isDisplayed();
	}

	public String verifyLinkText() {
		return links.getText();
	}
}
