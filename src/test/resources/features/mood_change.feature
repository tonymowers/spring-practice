Feature:  Change the Mood

  A person has a range of different moods and they choose which of the moods they want to currently have.

  Background: Setup the range of possible moods
    Given the following possible moods:
      | id  | name   |
      | 0   | happy  |
      | 1   | sad    |
    And "happy" is the default mood

  Scenario: No mood is chosen
    Given nothing is done about the mood
    When nothing is done about the mood
    Then the mood should be "happy"

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
