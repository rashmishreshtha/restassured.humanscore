Feature: humanscore Registration

  Scenario: Register to the website

    Given registration information
      | name  | age | city  | country      | email          | password  |
      | Punnu | 29  | Patna | Bihar, India | punu@gmail.com | pAssword1 |
      | Ranu | 34  | Ranchi | Jharkhand, India | rannu@gmail.com | pAssword2 |
    When post is performed
    Then profile is created

