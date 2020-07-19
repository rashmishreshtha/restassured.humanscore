Feature: Humanscore profile mix

  Scenario: Get profile mix
    Given a valid auth token
    When post is performed to profile mix
    Then list of profiles is returned