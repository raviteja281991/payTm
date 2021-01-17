package com.website.stepdefinitions;

import com.website.utilities.DBSTravelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DBSTravelSteps {

	@Given("user opens browser and clicks on travel and flights")
	public void user_opens_browser_and_clicks_on_travel_and_flights() {
		DBSTravelPage.clickTabs();
	}

	@Then("user click on round trip and fills in travel timings")
	public void user_click_on_round_trip_and_fills_in_travel_timings() {
		DBSTravelPage.departureLocation();
		DBSTravelPage.arrivalLocation();
		DBSTravelPage.selectDepartureDate();
		DBSTravelPage.selectReturnDate();

	}

	@Then("user selects passengers and hits select search")
	public void user_selects_passengers_and_hits_select_search() {
		DBSTravelPage.selectClass();
		DBSTravelPage.selectPassengerType("adult", 2);
		DBSTravelPage.selectPassengerType("child", 1);
		DBSTravelPage.searchFlights();
	}

	@Then("user selects Tinmings as night and airways as Singapore Airlines")
	public void user_selects_tinmings_as_night_and_airways_as_singapore_airlines() {
		DBSTravelPage.checkTravelPreferences();
	}

	@Then("user selects total number of flights available")
	public void user_selects_total_number_of_flights_available() {
		System.out.println("i've already printed this out");
	}

	@Then("user selects first available flight and returns the flight travel details")
	public void user_selects_first_available_flight_and_returns_the_flight_travel_details() {
		DBSTravelPage.selectFlight();
	}

}
