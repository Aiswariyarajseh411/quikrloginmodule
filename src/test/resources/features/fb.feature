@facebook
Feature: launch the application
Scenario: user can log in with facebook
Given the user is in Login/Sign Up page 
When the user clicks on facebook button
And the user enters valid email id and password
Then user navigate to facebook page