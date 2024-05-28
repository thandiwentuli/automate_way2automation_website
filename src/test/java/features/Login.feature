Feature: Customer initial deposit

  Scenario Outline: Test 1
    Given the User is on the homepage
    And the User Clicks the Customer Login Button
    Then the User Clicks Dropdown List
#   And the User Selects A Username
    And the User Selects A Username "Ron Weasly"
    Then the User Clicks on Login Button
    And Welcome <your_name>
    And User deposits into accounts
      | AccountNumber | DepositAmount |
      | 1007          | 1500          |

#    Then User Clicks on Account Dropdown List
#    And Selects Account number
#    Then User verifies account balance
    And User logout
    Examples:
      | your_name  |
      | Ron Weasly |

  Scenario Outline: Test 2
    Given the User is on the homepage
    And the User Clicks the Customer Login Button
    Then the User Clicks Dropdown List
    And the User Selects A Username "Ron Weasly"
    Then the User Clicks on Login Button
    And Welcome <your_name>
    And User deposits into accounts
      | AccountNumber | DepositAmount |
      | 1007          | 1500          |
      | 1008          | 1500          |
      | 1009          | 1500          |
    And User logout
    Examples:
      | your_name  |
      | Ron Weasly |

  Scenario Outline: Test 3
    Given the User is on the homepage
    And the User Clicks the Customer Login Button
    Then the User Clicks Dropdown List
#   And the User Selects A Username
    And the User Selects A Username "Ron Weasly"
    Then the User Clicks on Login Button
    And Welcome <your_name>
    And User deposits into accounts
      | AccountNumber | DepositAmount |
      | 1007          | 31459          |
    And User clicks the withdrawal Button

#    Then User Clicks on Account Dropdown List
#    And Selects Account number
#    Then User verifies account balance
    #And User logout
    Examples:
      | your_name  |
      | Ron Weasly |
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