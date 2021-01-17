
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Title of your feature
  I want to use this template for my feature file

 

 #Scenario: Checking the All Deals menu
  #Given user clicks the todys deals text
  #Then  user selects all the departments
  
#DBS Test case   
# Scenario: Return the travel path of Flight selected
  # Given  user opens browser and clicks on travel and flights
#  Then user click on round trip and fills in travel timings
 # And user selects passengers and hits select search
 # Then user selects Tinmings as night and airways as Singapore Airlines
 # And user selects total number of flights available
#  And user selects first available flight and returns the flight travel details


# PayTm Test case

  Scenario: paytm assigned scenario
  Given User opens paytm, select the menu and hits the All laptops
  Given user selects the specs 
  