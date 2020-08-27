Feature: humanscore Registration

  Scenario: Register to the website

    Given registration information
      | name  | age | city  | country      | email          | password  |
      | Punnu | 29  | Patna | Bihar, India | *********gmail.com | *********** |
      | Ranu | 34  | Ranchi | Jharkhand, India | ************@gmail.com | pAssword2 |
      | Manu | 39  | Patna | Bihar, India | ***************@gmail.com | pAssword2 |
    When post is performed
    Then profile is created

