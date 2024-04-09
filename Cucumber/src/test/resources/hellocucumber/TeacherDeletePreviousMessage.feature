Feature: Teacher Delete Previous Message

  Scenario: Course teacher removes Previous message from Ml course announcment before student press previous button
    Given Teacher is logged in
    And Teacher is on first announcment
    And Student is logged in
    When Student is in the middle annoncment page
    And Teacher removes the previous announcment
    Then Student is no longer seen the previous message button

  Scenario: Course teacher removes Previous message from Ml course announcment after student press previous button
    Given Teacher is logged in
    And Teacher is on first announcment
    And Student is logged in
    When Student is in the middle annoncment page
    And Student presses the prev page button
    And Teacher removes the previous announcment
    Then Student is no longer seen the previous message button

