Feature: Customer initial deposit

  Scenario: Clear Account Balance status
    Given the User is on the homepage
    And the User Clicks the Customer Login Button
    Then the User Clicks Dropdown List
    And the User Selects <yourName>
    Then the User Clicks on Login Button
    And Welcome <yourName> !! message is displayed
    Then User Clicks on Account Dropdown List
    And Selects Account number
    Then User verifies account balance

#  Scenario: Login as a Customer
#    Given the User is on the homepage "http://www.way2automation.com/angularjs-protractor/banking/#/login"
#    When the User Clicks the Customer Login Button
#    And the User Clicks Dropdown List
#    Then the User Selects <yourName>
#    And the User Clicks on Login Button
#
#    And the User logs out
#
#  Scenario: Customer deposits money into their account and validates the deposit
#    And User Clicks on Transactions Button
#    Then