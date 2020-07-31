Feature: Validate maps API
  Scenario Outline: Add place in to maps
    Given Add place with "<accuracy>" "<name>" and "<address>"
    When I call add place API with "POST" http request
    Then response "status" is "OK"
    And get the added address details

    Examples:
    | accuracy | name   | address          |
    | 30       | Suresh | 50 avenew street |
    | 40       | Mahesh | 39 CM street     |
