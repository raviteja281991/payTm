package com.website.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DBSTravelPage extends DriverFactory {
	public DBSTravelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[text()='Travel']")
	public WebElement travelHomeLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Travel']")
	public WebElement travelLink;

	@FindBy(how = How.XPATH, using = "//div[starts-with(@class,'HorizontalTabsMenuStyles')]//button[text()='Flights']")
	public WebElement flightsLink;

	@FindBy(how = How.XPATH, using = "//div[@class='trip-type']/label/input[@id='ROUND_TRIP']")
	public WebElement roundTripBtn;

	@FindBy(how = How.XPATH, using = "//input[@id='locationOrigin-input']")
	public WebElement fromField;

	@FindBy(how = How.XPATH, using = "//ul[@id='locationOrigin-menu']/li")
	public List<WebElement> fromList;

	@FindBy(how = How.XPATH, using = "//input[@id='locationDestination-input']")
	public WebElement toField;

	@FindBy(how = How.XPATH, using = "//ul[@id='locationDestination-menu']/li")
	public List<WebElement> toList;

	@FindBy(how = How.XPATH, using = "//input[@id='RangeDatePicker-Departing']")
	public WebElement departDate;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'CalendarMonth_caption')]/strong)[2]")
	public WebElement checkMonthText;

	@FindBy(how = How.XPATH, using = "//img[@class ='cal-icon next']")
	public WebElement hitNextMonth;

	@FindBy(how = How.XPATH, using = "//table[@role='presentation']/tbody/tr/td")
	public List<WebElement> selectDay;

	@FindBy(how = How.XPATH, using = "//input[@id='RangeDatePicker-Returning']")
	public WebElement returnDate;

	@FindBy(how = How.XPATH, using = "//div[@role='combobox']/input")
	public WebElement classAndPassengers;

	@FindBy(how = How.XPATH, using = "//div[@class='select-class-item']/span[text()='Business']")
	public WebElement selectClassType;

	@FindBy(how = How.XPATH, using = "//img[@class='circle-choice plus']")
	public List<WebElement> passengerIncrement;

	@FindBy(how = How.XPATH, using = "//input[@value='Search Flights']")
	public WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//div[@class='loading-box inline']//img")
	public WebElement spinnerIcon;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'auto-sort-flights')]/div)[1]")
	public WebElement searchCount;

	@FindBy(how = How.XPATH, using = "//input[@value='night']")
	public WebElement nightCheck;

	@FindBy(how = How.XPATH, using = "//input[@data-label='Singapore Airlines']")
	public WebElement airlinesCheck;

	@FindBy(how = How.XPATH, using = "(//div[starts-with(@class,'styles__Container-d')]/div)[1]")
	public WebElement firstFlightSelect;
	
	@FindBy(how = How.XPATH, using = "(//img[starts-with(@class,'styles__ExpandIcon')])[1]")
	public WebElement roundTripArrow;

	// @FindBy(how = How.XPATH, using = "")
	// public WebElement;



	public static void getScreenShots(String fileName) {
		File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		fileDes = new File("./Screenshots/" + fileName + ".png");
		try {
			FileHandler.copy(temp, fileDes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clickTabs() {
		dbsTravelpage.travelHomeLink.click();
		// dbsTravelpage.travelLink.click();
		dbsTravelpage.flightsLink.click();
		if (!dbsTravelpage.roundTripBtn.isEnabled()) {
			dbsTravelpage.roundTripBtn.click();
		}
	}

	public static void departureLocation() {
		waits(dbsTravelpage.fromField);
		dbsTravelpage.fromField.click();
		dbsTravelpage.fromField.clear();
		dbsTravelpage.fromField.sendKeys("Melbourne, Australia");

		String departure = "Melbourne Airport";
		System.out.println("The size of fromList is " + dbsTravelpage.fromList.size());
		boolean status = false;

		for (WebElement flightList : dbsTravelpage.fromList) {

			if (flightList.getText().contains(departure)) {
				flightList.click();
				status = true;
				break;
			}
		}
		if (status) {
			System.out.println("Successfullly selected the departure location");
		} else {
			Assert.fail(departure + "location not found");
		}

	}

	public static void arrivalLocation() {

		waits(dbsTravelpage.toField);
		dbsTravelpage.toField.click();
		dbsTravelpage.toField.clear();
		dbsTravelpage.toField.sendKeys("Hyderabad");
		boolean status = false;
		String arrival = "Hyderabad";
		for (WebElement flightList : dbsTravelpage.toList) {

			if (flightList.getText().contains(arrival)) {
				flightList.click();
				status = true;
				break;
			}
		}
		if (status) {
			System.out.println("Succesfully selected the arrival location");
		} else {
			Assert.fail(arrival + " Arrival location not found");
		}

	}

	public static void selectDepartureDate() {
		dbsTravelpage.departDate.click();

		for (int i = 1; i <= 12; i++) {
			waits(dbsTravelpage.checkMonthText);
			threadWait(3000);
			if (dbsTravelpage.checkMonthText.getText().equals("August 2021")) {
				threadWait(2000);
				selectDate("18");
				break;
			} else {
				threadWait(3000);
				dbsTravelpage.hitNextMonth.click();
			}
		}
	}

	public static void selectDate(String date) {
		threadWait(4000);
		for (WebElement goingDate : dbsTravelpage.selectDay) {
			if (goingDate.getText().equalsIgnoreCase(date)) {
				System.out.println("im in date seelction");
				executor.executeScript("arguments[0].click();", goingDate);
				break;
			}
		}
	}

	public static void selectReturnDate() {

		dbsTravelpage.returnDate.click();
		for (int i = 1; i <= 12; i++) {
			waits(dbsTravelpage.checkMonthText);
			if (dbsTravelpage.checkMonthText.getText().equals("September 2021")) {
				threadWait(2000);
				selectDate("26");
				break;
			} else {
				dbsTravelpage.hitNextMonth.click();
			}
		}

	}

	public static void selectClass() {
		System.out.println("im in select passengers");
		waits(dbsTravelpage.classAndPassengers);
		dbsTravelpage.classAndPassengers.click();
		threadWait(2000);
		waits(dbsTravelpage.selectClassType);
		executor.executeScript("arguments[0].click();", dbsTravelpage.selectClassType);
		System.out.println("i'm at the end odf SelectClass");
	}

	public static void selectPassengerType(String passenger, int value) {
		System.out.println("I'm in select passengers Type");
		threadWait(3000);
		if (passenger.toLowerCase().equals("adult")) {
			typeOfPassengers(1, value - 1);
		} else if (passenger.toLowerCase().equals("child")) {
			typeOfPassengers(2, value);
		} else if (passenger.equalsIgnoreCase("infant")) {
			typeOfPassengers(3, value);
		}
	}

	public static void typeOfPassengers(int i, int value) {
		threadWait(2000);
		String passengerXpath = "(//img[@class='circle-choice plus'])[" + i + "]";
		WebElement ele = driver.findElement(By.xpath(passengerXpath));
		waits(ele);
		for (int j = 0; j < value; j++) {
			executor.executeScript("arguments[0].click();", ele);
		}
	}

	public static void searchFlights() {
		dbsTravelpage.searchButton.click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.invisibilityOf(dbsTravelpage.spinnerIcon));
		threadWait(5000);
		getScreenShots("Flights_Result_Pic1");
		displayCount(0, 3);
	}

	public static void displayCount(int i, int j) {
		waits(dbsTravelpage.searchCount);
		String count = dbsTravelpage.searchCount.getText();
		System.out.println("Toatal available flights are " + count.substring(i, j));

	}

	public static void checkTravelPreferences() {
		threadWait(3000);
		executor.executeScript("arguments[0].click();", dbsTravelpage.nightCheck);
		executor.executeScript("arguments[0].click();", dbsTravelpage.airlinesCheck);
		displayCount(0, 2);
	}
public static void selectFlight() {
	System.out.println("Im in selectflightMethod");
	threadWait(3000);
	dbsTravelpage.roundTripArrow.click();
	threadWait(3000);
	getScreenShots("departing_flight_details");
	threadWait(2000);
	waits(dbsTravelpage.firstFlightSelect);
	executor.executeScript("arguments[0].click();", dbsTravelpage.firstFlightSelect);
	
}
public static void returnInteger(WebElement webelement) {
	System.out.println("the flights count is"+webelement.getText().replaceAll("//D+", ""));
	
	
}
}
