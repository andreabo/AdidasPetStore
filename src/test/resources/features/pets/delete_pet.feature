Feature: Delete a Pet requests

  Scenario: D01-Delete a pet
    Given There is a pet already create
    And I have the pet id
    When I delete the pet
    Then The service status code should be 200
    And The pet should be deleted

  Scenario: D02-Delete a pet with a non existed id
    When I request to delete a pet with a non existed id
    Then The service status code should be 404
    And The message should be "Pet not found"

  Scenario: D03-Delete a pet with an invalid id
    When I request to delete a pet with an invalid id
    Then The service status code should be 400
    And The message should be "Invalid ID supplied"