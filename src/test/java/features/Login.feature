Feature: Customer initial deposit

  Scenario Outline: Test 1
    Given the User is on the homepage
    And the User Clicks the Customer Login Button
    Then the User Clicks Dropdown List
    And the User Selects A Username "Ron Weasly"
    Then the User Clicks on Login Button
    And Welcome <your_name>
    And User deposits into accounts
      | AccountNumber | DepositAmount |
      | 1007          | 1500          |
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
    And the User Selects A Username "Ron Weasly"
    Then the User Clicks on Login Button
    And Welcome <your_name>
    And User deposits into accounts
      | AccountNumber | DepositAmount |
      | 1007          | 31459          |
    Then Validate that deposit appears under the transaction page
    And User clicks the withdrawal Button
    And User enters withdrawal amount
      | WithdrawalAmount |
      | 31459            |
    And User clicks final withdrawal button
    Then Validate that withdrawal appears under the transaction page
    And User logout
    Examples:
      | your_name  |
      | Ron Weasly |

  Scenario Outline: Test 4
    Given the User is on the homepage
    And the User Clicks the Customer Login Button
    Then the User Clicks Dropdown List
    And the User Selects A Username "Ron Weasly"
    Then the User Clicks on Login Button
    And Welcome <your_name>
    And User deposits into accounts
      | AccountNumber | DepositAmount |
      | 1007          | 1500          |
    And User logout
    Examples:
      | your_name  |
      | Ron1 Weasly |