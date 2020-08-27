Feature: Humanscore profile

  Scenario: Get profile mix
    Given a valid auth token
    When post is performed to profile mix
    Then list of profiles is returned

  Scenario: Get profile
    Given a valid auth token
      And profileid
    When post is performed to profile
    Then profile info is returned