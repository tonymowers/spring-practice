Feature: Greeting Strategy

  How the user is greeted should depend upon the current mood

  Background: Setup the default mood
    Given "happy" is the default mood
    And the default mood is chosen

  Scenario: user greeted using default mood
    Then the greeting should be "Howdy!"

  Scenario Outline: user greeted using "<mood_name>" mood
    When the "<mood_name>" mood is chosen
    Then the greeting should be "<greeting>"

    Examples:
      | mood_name | greeting           |
      | happy     | Howdy!             |
      | sad       | Please go away :-( |