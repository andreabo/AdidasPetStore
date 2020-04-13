Feature: Update a Pet requests

  Scenario Outline: U01-Update a pet
    Given There is a pet already create
    And I have the pet id
    And I change the <field>
    When I update the pet
    Then The service status code should be 200
    And The pet <field> should be updated
    Examples:
      | field     |
      | name      |
      | photoUrls |
      | category  |
      | tags      |
      | status    |

  Scenario: U02-Update a pet with a non existed status
    Given There is a pet already create
    And I have the pet id
    And I change the status
    When I update the pet
    Then The message should be "Invalid status supplied"


