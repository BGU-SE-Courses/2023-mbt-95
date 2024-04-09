Feature: Student login and then read the message

  Scenario Outline: Student views a message on the message board
    Given the student is logged in on with "<Username>" and "<Password>"
    When user is on one of the  Announcmentes page of Ml course
    And Current page is not the only
    And Student presses the prev page button
    Then the message changes to the previous message
    Examples:
      |Username       |Password|
      |student|Stud12345!|
