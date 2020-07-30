Feature: Validate maps API
  Scenario: Add place in to maps
    Given Add place payload
    When I call add place API with "POST" http request
    Then response "status" is "OK"
    And get the added address details
