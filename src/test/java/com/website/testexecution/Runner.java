package com.website.testexecution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/FeatureFiles"},
		glue= {"com.website.stepdefinitions","com.website.cucumberhooks"}
		)
public class Runner {

}
