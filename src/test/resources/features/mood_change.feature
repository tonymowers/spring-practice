Feature:  Change My Mood

  A person has a range of different moods and they choose which of the moods they want to currently have.

  Background: Setup the range of available moods
    Given the following possible moods:
      | id  | name   |
      | 0   | happy  |
      | 1   | sad    |
    And "happy" is the default mood

  Scenario: I am in my default mood
    Given I have done nothing about my mood
    When I have done nothing about my mood
    Then I should be in a "happy" mood

  Scenario: I choose to be happy
    Given I have chosen a "sad" mood
    When I have chosen a "happy" mood
    Then I should be in a "happy" mood

  Scenario: I choose to be sad
    Given I have chosen a "happy" mood
    When I have chosen a "sad" mood
    Then I should be in a "sad" mood

  Scenario: I choose to be in my default mood
    Given I have chosen a "sad" mood
    When I have chosen my default mood
    Then I should be in a "happy" mood
