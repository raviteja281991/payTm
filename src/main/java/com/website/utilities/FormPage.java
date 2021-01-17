package com.website.utilities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends DriverFactory {

	public FormPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//label[text()='Name']/following::input)[1]")
	public WebElement firstName;
	@FindBy(how = How.XPATH, using = "(//label[text()='Name']/following::input)[2]")
	public WebElement lastName;
	@FindBy(how = How.XPATH, using = "//div[text()='Gender']/preceding::input[@id='userEmail']")
	public WebElement email;
	@FindBy(how = How.XPATH, using = "(//div[text()='Gender']/following::label)[1]")
	public WebElement gender;
	@FindBy(how = How.XPATH, using = "//input[@id='userNumber']")
	public WebElement mobileNum;
	@FindBy(how = How.XPATH, using = "//input[@id='dateOfBirthInput']")
	public WebElement dob;
	@FindBy(how = How.XPATH, using = "//select[@class='react-datepicker__month-select']")
	public WebElement month1;
	@FindBy(how = How.XPATH, using = "//select[@class='react-datepicker__year-select']")
	public WebElement year;
	@FindBy(how = How.XPATH, using = "//div[@role='listbox']/div/div")
	public List<WebElement> dates;
	@FindBy(how = How.XPATH, using = "//div[starts-with(@class,'subjects-auto-complete__value-container subjects')]")
	public WebElement subject;
	@FindBy(how = How.XPATH, using = "//label[text()='Reading']/preceding::label[text()='Sports']")
	public WebElement hobbies;
	@FindBy(how = How.XPATH, using = "//label[@for='uploadPicture']")
	public WebElement choosePic;
	@FindBy(how = How.XPATH, using = "//textarea[@id='currentAddress']")
	public WebElement textarea;

	public static void cool() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	public static void pDetails() {
		form.firstName.sendKeys("Ravi Teja");
		form.lastName.sendKeys("sripalli");
		form.email.sendKeys("raviteja281991@email.com");
		form.gender.click();
		form.dob.click();
		cool();
		Select BirthYear = new Select(form.year);
		BirthYear.selectByValue("1991");
		Select month = new Select(form.month1);
		month.selectByVisibleText("July");
		for (WebElement Birthday : form.dates) {

			if (Birthday.getText().equals("18")) {

				Birthday.click();
				break;
			}
		}
	}

	public static void sujectMethod() {
		// form.subject.sendKeys("history");
	}

	public static void hobbiesMethod() {
		form.hobbies.click();
	}

	public static void choosePicMethod() {
		//form.choosePic.click();
		 		executor.executeScript("arguments[0].click();", form.choosePic );
		try {
			Runtime.getRuntime().exec("C:\\Users\\ravis\\Documents\\Script_to_choose_file.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void enterAddress() {
		form.textarea.sendKeys("Gunadala, Vijayawada");
	}
}
