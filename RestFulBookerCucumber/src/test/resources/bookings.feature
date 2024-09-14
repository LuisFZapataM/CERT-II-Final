Feature: Bookings EndPoint


  Scenario: Verify the booking with a given Id
    Given Perform a GET call to employees end point with id "2"
    Then Verify status code 200
    Then Verify that body is not empty



  Scenario: Verify an error code when booking Id is in wrong format
    Given Perform a GET call to employees end point with id "one"
    Then Verify status code 404
    Then Verify error message "Not Found"



  Scenario Outline: Create a new booking
    Given Create a new booking with the Info
      | <name> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionals> |
    And Make a POST request with the booking body
    Then Verify status code 200
    Then Booking id is not 0
    Then Verify name equals "<name>"
    Then Verify last name equals "<lastname>"
    Then  Verify total price equals "<totalprice>"
    Then Verify additionals equals "<additionals>"

    Examples:
    | name | lastname | totalprice | depositpaid | checkin    | checkout   | additionals    |
    | Luis | Zapata   | 780        | true        | 2024-05-12 | 2024-05-17 | null           |
    | Juan | Perez    | 1540       | false       | 2024-05-17 | 2024-05-30 | Breakfast      |
    | Rosa | Alvarez  | 100        | true        | 2024-05-12 | 2024-05-13 | Big room       |



  Scenario Outline: Create a new booking when dates are in wrong format
    Given Create a new booking with the Info
      | <name> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionals> |
    And Make a POST request with the booking body
    Then Verify status code 400
    Examples:
      | name | lastname | totalprice | depositpaid | checkin    | checkout   | additionals    |
      | Luis | Zapata   | 780        | true        | mañana     | pasado     | null           |
      | Juan | Perez    | 1540       | false       | 17-05-2024 | 19-06-2024 | Breakfast      |
      | Rosa | Alvarez  | 100        | true        | 200-200-200 | 400-400-400 | Big room       |



  Scenario: Create a new booking when body is empty
    And Make a POST request with the empty body
    Then Verify status code 400
    Then Verify error message "Bad Request"