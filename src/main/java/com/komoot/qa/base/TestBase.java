package com.komoot.qa.base;

import static com.komoot.qa.util.TestUtil.Implicit;
import static com.komoot.qa.util.TestUtil.pageLoadTimeout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	static {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					TestBase.class.getClassLoader().getResource("config.properties").getFile());
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					TestBase.class.getClassLoader().getResource("chromedriver.exe").getFile());
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					TestBase.class.getClassLoader().getResource("chromedriver.exe").getFile());
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Implicit, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
