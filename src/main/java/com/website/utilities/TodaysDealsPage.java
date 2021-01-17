package com.website.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TodaysDealsPage extends DriverFactory {
	public TodaysDealsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Today')]")
	public WebElement todaysDeals;

	@FindBy(how = How.XPATH, using = "//div[starts-with(@class,'a-row a-expander')]/span/div/label/input")
	public List<WebElement> departmentsList;

	public static void clickTwodaysDeals() {
		todaysDealsPage.todaysDeals.click();

	}

	/*public static void checkDepartmentList() {
		for (WebElement checklist : todaysDealsPage.departmentsList) {
			//WebElement singelCheck = driver.findElement(By.xpath("//div[starts-with(@class,'a-row a-expander')]/span/div/label/input"));
			checklist.click();

		}
	}*/
	public static void clickDepartmentIndividually() {
		
		for(int i=1; i<= todaysDealsPage.departmentsList.size(); i++) {
			try {
				Thread.sleep(5000);
				WebElement singelCheck = driver.findElement(By.xpath("//div[starts-with(@class,'a-row a-expander')]/span[" + i + "]/div/label/input"));
				singelCheck.click();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
				
		}
	}

}
