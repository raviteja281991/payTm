package com.website.stepdefinitions;


import com.website.utilities.TodaysDealsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TodaysDealsSteps {
	
	@Given("user clicks the todys deals text")
	public void todaysDeals() {
		TodaysDealsPage.clickTwodaysDeals();
		
	}


	@Then("user selects all the departments")
	public void selectDepartments() {
		//TodaysDealsPage.checkDepartmentList();
		TodaysDealsPage.clickDepartmentIndividually();
	}
}
