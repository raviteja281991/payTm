package com.website.stepdefinitions;


import com.website.utilities.FormPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Steps {
	
	@Given("user enters personal details")
	public void personaldetails() {
		FormPage.pDetails();
		
	}

	@And("user enters subjects")
	public void entersSubjects() {
	    FormPage.sujectMethod();
	}

	@And("user selects hobbies")
	public void selectHobbies() {
	    FormPage.hobbiesMethod();
	}

	@Then("user upload their Photo")
	public void uploadPhoto() {
		FormPage.choosePicMethod();
	}

	@And("user selects location details")
	public void selectLocation() {
		FormPage.enterAddress();
	    
	}



}
