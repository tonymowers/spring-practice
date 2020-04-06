Feature:  Change the Mood

  A person has a range of different moods and they choose which of the moods they want to currently have.

  Background: Setup the range of possible moods
    Given the following possible moods:
      | id    | name   |
      | HAPPY | happy  |
      | SAD   | sad    |
    And "happy" is the default mood

  Scenario: No mood is chosen
    Then the default mood should be "happy"
    And the mood should be "happy"

  Scenario: The happy mood is chosen
    Given the "sad" mood is chosen
    When the "happy" mood is chosen
    Then the mood should be "happy"

  Scenario: The sad mood is chosen
    Given the "happy" mood is chosen
    When the "sad" mood is chosen
    Then the mood should be "sad"

  Scenario: The default mood is chosen
    Given the "sad" mood is chosen
    When the default mood is chosen
    Then the mood should be "happy"

  Scenario: The default mood is set
    When "sad" is the default mood
    Then the default mood should be "sad"

  Scenario: There are no moods available
    Given the following possible moods:
      | id  | name   |
    Then the default mood should be unknown
    And the mood should be unknown

  Scenario: An unknown mood is chosen
    * a MoodNotFoundException should be thrown
    When an unknown mood is chosen