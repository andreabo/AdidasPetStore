Feature: Create Pet requests

  Scenario: C01-Create a pet with valid data
    Given I have valid pet information
    When I create a new pet
    Then The service status code should be 200
    And The response body should contains the new pet information

  Scenario: C02-Create a pet with empty fields
    Given I have no pet information
    When I create a new pet
    And The response body should contains the new pet information

  Scenario Outline: C03-Create a pet with invalid data
    Given I have invalid pet information on "<field>"
    When I create a new pet
    Then The service status code should be 400
    And The message should be "Invalid input"
    Examples:
      | field     |
      | id        |
      | photoUrls |
      | tags      |
      | category  |

  Scenario Outline: C04-Create a pet without data
    Given I have valid pet information
    But without "<field>"
    When I create a new pet
    Then The service status code should be 200
    And The response body should contains the new pet information without "<field>"
    Examples:
      | field     |
      | name      |
      | photoUrls |
      | tags      |
      | category  |

  Scenario: C05-Create a pet without status
    Given I have valid pet information
    But without "status"
    When I create a new pet
    Then The service status code should be 400
    And The message should be "bad input"

  Scenario: C06-Create a pet with a status different to the existed
    Given I have valid pet information
    But Pet status is adopted
    When I create a new pet
    Then The service status code should be 400
    And The message should be "bad input"

  Scenario: C07-Create a pet with an existed id
    Given There is a pet already create
    And I have the pet id
    When I create a new pet with same id
    Then The service status code should be 400
    And The message should be "Pet Id already existed"
    And The pet already create should not change with the new one

