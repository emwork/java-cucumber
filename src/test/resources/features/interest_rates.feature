Feature: Interest rates impact on bonds and stocks

  Scenario: rates go down, bond price goes up
    Given interest rate is 4%
    And Canada-3-Year Bond price is $100, yield is 4.5%
    When interest rate changes to 3%
    Then Bond price is $110

  Scenario: rates go up, bond price goes down
    Given interest rate is 4%
    And Canada-3-Year Bond price is $100, yield is 4.5%
    When interest rate changes to 5%
    Then Bond price is $90

  Scenario: rates go down, bond yield goes down
    Given interest rate is 4%
    And Canada-3-Year Bond price is $100, yield is 4.5%
    When interest rate changes to 3%
    Then Bond yield is 4.05%

  Scenario: rates go up, bond yield goes up
    Given interest rate is 4%
    And Canada-3-Year Bond price is $100, yield is 4.5%
    When interest rate changes to 5%
    Then Bond yield is 4.95%

  Scenario: rates go up, bond yield goes up (alternative parameter)
    Given interest rate is 4%
    And Security is Bond|Canada-3-Year|$100|4.5%
    When interest rate changes to 6%
    Then Bond yield is 5.4%

  Scenario: rates go down, bond price goes up (alternative parameter)
    Given interest rate is 4%
    And Bond is
      | assetClass | description    | price | yield|
      | Bond       | Canada-3-Year  |   100 |   4.5|
    When interest rate changes to 1%
    Then Bond price is $130

  Scenario: asset class cannot be handled
    Given interest rate is 4%
    And MSFT Stock price is $200, yield is 0.5%
    When interest rate changes to 5%
    Then Exception is thrown "The service handles bonds only"
