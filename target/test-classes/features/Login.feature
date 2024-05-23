Feature: OrangeHRM Login

  Scenario: OrangeHRM Default login
    Given User is on Login Page
    When User clicks on login by entering Username as "admin" and Password as "admin123"
    Then login success is "true"
    And Username displayed is "true"
		And close browser
		
  Scenario: OrangeHRM Invalid Login
    Given User is on Login Page
    When User clicks on login by entering Username as "user" and Password as "user123"
    Then login success is "false"
    And Username displayed is "false"
		And close browser

  Scenario Outline: OrangeHRM login with multiple invalid data set
    Given User is on Login Page
    When User clicks on login by entering Username as <username> and Password as <password>
    Then login success is "false"
    And Username displayed is "false"
		And close browser
    Examples: 
      | username | password |
      | a@b.com  |   111111 |
      | c@d.com  |   222222 |
      | e@f.com  |   333333 |
