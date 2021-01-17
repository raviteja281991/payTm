package com.website.cucumberhooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.website.utilities.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverFactory {

	public void openBrowser(String desiredBrowser) {

		switch (desiredBrowser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\000 Selenium Softwares\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get(URL);

			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\000 Selenium Softwares\\geckodriver.exe");
			driver = new FirefoxDriver();
			// driver.get(URL);

			break;
		default:
			System.out.println("Enter a valid browser(Hint: Chrome or firefox)");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
		executor = (JavascriptExecutor) driver;

	}

	public void openUrl(String url) {
		if (url.equalsIgnoreCase("Amazon")) {
			driver.get("https://www.amazon.in");
		} else if (url.equalsIgnoreCase("Demosite")) {
			driver.get("https://demoqa.com/automation-practice-form");
			// driver.manage().window().maximize();
		} else if (url.equalsIgnoreCase("DBSmarketplace")) {
			driver.get("https://www.dbs.com.sg/personal/marketplace/");
		} else if (url.equalsIgnoreCase("paytm")) {
			driver.get("https://paytm.com/");

		}
	}

	@Before
	public void init() {
		openBrowser(Browser);
		openUrl(URL);
		loadPages();
		// loadAmazonPages();

	}

	@After
	public void tearDown() {
		System.out.println("i'm in after anno");
		// driver.close();

	}
}
