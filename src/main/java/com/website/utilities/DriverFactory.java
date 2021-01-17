package com.website.utilities;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	public static WebDriver driver;
	public static String Browser = System.getProperty("browser");
	public static String URL = System.getProperty("url");
	public static JavascriptExecutor executor;
	public static File fileDes;

	public static FormPage form;
	public static TodaysDealsPage todaysDealsPage;

	public static DBSTravelPage dbsTravelpage;

	public static MortalTaskPage mortalTaskPage;

	public static void loadPages() {
		form = new FormPage();
		todaysDealsPage = new TodaysDealsPage();
		mortalTaskPage = new MortalTaskPage();
		dbsTravelpage = new DBSTravelPage();
	}

	public static void threadWait(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void waits(WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(webelement));

	}

	public static void doubleClick(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.doubleClick(ele).build().perform();
	}
	public static void mouseHover(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}
}