package com.komoot.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.komoot.qa.base.TestBase;

public class SearchPage extends TestBase {

	@FindBy(xpath = "//div[text()= 'Tanya']")
	WebElement userName;

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyUserName() {
		return userName.getText();
	}
}
