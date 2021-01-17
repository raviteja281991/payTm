package com.website.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MortalTaskPage extends DriverFactory {

	public MortalTaskPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='_22in']/i[@class='iconMenu cursor']")
	public WebElement menuIcon;
	@FindBy(how = How.XPATH, using = "//div[@class='_26bf']/a")
	public List<WebElement> menuProductCategory;
	// @FindBy(how = How.XPATH, using = "//div[@class='bbKy']/div/div/div")
	// public List<WebElement> subCategory;
	@FindBy(how = How.XPATH, using = "//a[text()='All Laptops']")
	public WebElement laptopsBttn;
	@FindBy(how = How.XPATH, using = "//div[@class='DMLK']/div/div/label/span[2]")
	public List<WebElement> procuctSpecs;
	@FindBy(how = How.XPATH, using = "//div[@class='_1sRm']")
	public List<WebElement> productFilterTypeSelection;
	@FindBy(how = How.XPATH, using = "//div[@class='_1EI9 CtZB']/span")
	public WebElement productCount;
	// @FindBy(how = How.XPATH, using =
	// "//input[@type='search']//preceding::i[@class='iconMenu cursor']")
	// public WebElement menuIcon;
	// @FindBy(how = How.XPATH, using =
	// "//input[@type='search']//preceding::i[@class='iconMenu cursor']")
	// public WebElement menuIcon;
	// @FindBy(how = How.XPATH, using =
	// "//input[@type='search']//preceding::i[@class='iconMenu cursor']")
	// public WebElement menuIcon;
	// @FindBy(how = How.XPATH, using =
	// "//input[@type='search']//preceding::i[@class='iconMenu cursor']")
	// public WebElement menuIcon;

//@FindBy(how = How.XPATH, using = "//input[@type='search']//preceding::i[@class='iconMenu cursor']")
//public WebElement menuIcon;

	public static void clickSelected(String productMenuSelect) {

		waits(mortalTaskPage.menuIcon);

		executor.executeScript("arguments[0].click();", mortalTaskPage.menuIcon);

		for (WebElement product_category : mortalTaskPage.menuProductCategory) {
			if (product_category.getText().equalsIgnoreCase(productMenuSelect)) {
				mouseHover(product_category);
				break;
			}

		}
		waits(mortalTaskPage.laptopsBttn);
		mortalTaskPage.laptopsBttn.click();

	}

	/*
	 * public static void ClickProduct(String selectedProduct) { threadWait(10000);
	 * for (WebElement desired_product : mortalTaskPage.subCategory) { if
	 * (desired_product.getText().equalsIgnoreCase(selectedProduct)) {
	 * 
	 * desired_product.click(); break;
	 * 
	 * }
	 * 
	 * } }
	 */

	public static String filterSelection = "//div[text()='value']";

	public static WebElement productSpecsMenuBar(String xpath, String value, String replaceValue) {

		WebElement brand = driver.findElement(By.xpath(xpath.replace(value, replaceValue)));
		return brand;

	}

	public static void specsSelectionMethod(String name, String spec2) {
		WebElement element = productSpecsMenuBar(MortalTaskPage.filterSelection, "value", name);
		if (element.getText().replaceAll("\\P{L}", "").equals("Brand")) {
			doubleClick(element);
		} else if (element.getText().equalsIgnoreCase("ram")) {
			doubleClick(element);
		} else {
			element.click();
		}
		System.out.println("Filter Expanded");
		threadWait(3000);

		for (WebElement individualFilter : mortalTaskPage.procuctSpecs) {
			if (individualFilter.getText().equals(spec2)) {
				individualFilter.click();
			}

		}
	}

	public static void getCount() {
		System.out.println(
				"The available product count is" + mortalTaskPage.productCount.getText().replaceAll("//D+", ""));

	}
}
