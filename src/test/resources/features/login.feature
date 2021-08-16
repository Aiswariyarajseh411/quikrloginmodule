
@aishu

Feature: user login with valid credentials
Scenario: user can login with valid username and password
Given the user is in home page
When the user enters valid username  
And the user clicks on continue button
And the user enters password
And the user clicks on login button
Then he redirects to application

Scenario: User logs in with invalid email
Given user is in home page
When the user enters invalid email id
And the user clicks on the continue button
Then error is shown


Scenario: User logs in with invalid password
Given user is in the home page
When  user enters valid email id
And  clicks on continue button
And the user enters invalidpassword
And the click on login button
Then errormsg is shown

 
 Scenario: User logs in with invalid emailid
 Given user  in  home page
 When the user enters invalid emailid
 And the user clicks on the continuetn
 Then errormessage is shown
 
 