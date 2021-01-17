package com.website.stepdefinitions;

import com.website.utilities.MortalTaskPage;

import io.cucumber.java.en.Given;

public class MortalTaskSteps {

	@Given("User opens paytm, select the menu and hits the All laptops")
	public void user_opens_paytm_select_the_menu_and_hits_the_all_laptops() {
		MortalTaskPage.clickSelected("electronics");
		//MortalTaskPage.ClickProduct("all laptops");
		MortalTaskPage.specsSelectionMethod("Brand", "Asus");
		//MortalTaskPage.specsSelectionMethod("ram", "160");
		
		
	}

	@Given("user selects the specs")
	public void user_selects_the_specs() {
	}
}
