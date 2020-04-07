Feature:  Change the Mood

  A person has a range of different moods and they choose which of the moods they want to currently have.

  Background: Setup the default mood
    Given "happy" is the default mood
    And the default mood is chosen

  Scenario: No mood is chosen
    Then the default mood should be "happy"
    And the mood should be "happy"

  Scenario Outline: Mood changed from <mood_name> to <new_mood_name>
    Given the "<mood_name>" mood is chosen
    When the "<new_mood_name>" mood is chosen
    Then the mood should be "<new_mood_name>"
    Examples:
      | mood_name | new_mood_name |
      | sad       | happy         |
      | happy     | sad           |

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

  Scenario: An unknown mood is chosen
    * a MoodNotFoundException should be thrown
    When an unknown mood is chosen