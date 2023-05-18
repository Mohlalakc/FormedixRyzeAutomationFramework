Feature: Update Medical History

  @Test1
  Scenario Outline: As a user I want to login to Ryze application and update the medical history description
    Given Ryze website is open and I am on a login page open on "<Browser>" "<Environment>"
    When I login with "<Username>" and "<Password>" credentials
    Then I click on Login button
    And I click on the Repository button
    And I click on the Studies option
    And I click on the Tech Study menu bar
    And I verify the Tech Study options "<View>" "<Edit>" "<RemoveThisStudy>" "<TransitionThisStudy>"
    And I click on the View button
    And I click on the Data Acquisition button
    And I click on forms option under assets
    And I click on the Medical History option
    And I click on the Edit Form button
    And I clear the Description text box
    And I capture the Description "<Description>"
    And I click on the Update button
    And I verify that the textbox is updated successfully "<Description>"
    And I click on the profile
    And I click on Logout option
    And I verify that the Ryze Logo is displayed


    Examples:
    |Username        | Password   | Browser| Environment|View|Edit|RemoveThisStudy  |TransitionThisStudy  |Description                                              |
    |testteamtechtest| Ryz3T3st!x | Chrome | QA         |View|Edit|Remove this study|Transition this study| This description was updated by Kgothatso Collen Mohlala|