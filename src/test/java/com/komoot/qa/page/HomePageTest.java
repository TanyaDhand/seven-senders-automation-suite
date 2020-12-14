package com.komoot.qa.page;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.komoot.qa.base.TestBase;
import com.komoot.qa.page.HomePage;
import com.komoot.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homepage.validateLoginPageTitle();
		Assert.assertEquals(title, "Komoot | Everything You Need To Explore More of the Great Outdoors");
	}

	@Test(priority = 2)
	public void signUpOrLoginLinkTest() {
		homepage.signupLink();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl = "https://account.komoot.com/signin";
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
