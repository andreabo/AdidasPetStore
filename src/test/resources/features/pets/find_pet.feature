Feature: Find Pets requests

  Scenario: F01-Find a pet by id
    Given There is a pet already create
    And I have the pet id
    When I request for the pet by id
    Then The service status code should be 200
    And The response body should contains the pet information

  Scenario: F02-Find a pet with a non existed id
    When I request for a non existed pet by id
    Then The service status code should be 404
    And The message should be "Pet not found"

  Scenario: F03-Find a pet with a negative id
    When I request for a negative pet by id
    Then The service status code should be 404
    And The message should be "Pet not found"

  Scenario: F04-Find a pet with a invalid id
    When I request for a pet with an invalid id
    Then The service status code should be 400
    And The message should be "Invalid ID supplied"

  Scenario Outline: F05-Find pets by status
    Given There are pets already create with <status>
    When I request for pets <status>
    Then The service status code should be 200
    And The response should contains a lists of pets
    And All the pets should have <status> as status value
    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |

  Scenario: F06-Find pets by a invalid status
    When I request for a invalid pets status
    Then The service status code should be 400
    And The message should be "Invalid status supplied"

  Scenario: F07-Find pets by a non existed status
    When I request for a non existed pets status
    Then The service status code should be 400
    And The message should be "Invalid status supplied"
