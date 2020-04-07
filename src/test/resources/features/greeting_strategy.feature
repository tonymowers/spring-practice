Feature: Greeting Strategy

  The way the application greetings a user should depend on the selected mood

  Background: Setup the range of possible moods
    Given "happy" is the default mood

    Scenario: user greeted using default mood
      Then the greeting should be "Howdy!"

    Scenario Outline: user greeted using <mood_name> mood
      When the <mood_name> mood is chosen
      Then the greeting should be <greeting>

    Examples:
      | mood_name | greeting |
      | "happy"   | "Howdy!"  |
      | "sad"     | "Please go away :-("  |