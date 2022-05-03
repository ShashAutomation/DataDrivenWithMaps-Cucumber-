Feature: Multi user login

  Scenario Outline: Dropbox login
    Given User in google home page
    Given google title test
    When user in dropbox loginpage
    When dropbox title test
    When user enters email and password
      | email                     | password      |
      | Automationtest1@gmail.com | autoamte2345@ |
      | Automationtest2@gmail.com | automate2123@ |
    Then user close the browser
