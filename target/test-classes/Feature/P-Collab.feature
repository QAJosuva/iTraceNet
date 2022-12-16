
Feature: P-collab
Background:
		Given Navigate to the browser
		Then Navigating to landing page
		 

  @positive
  Scenario: Verifying all filed with positive data in vendor invitation page
    Given provide all postive data
    And click on Invite button 
    Then select workflow and click on proceed
   

  @Negative
  Scenario:  Verifying fileds with nagative data in vendor inviting page
    Given provide all negative data
    When and validate the error messages
      @Blank
  Scenario:  Verifying the attachments
    Given add new attchment
    And delete the added attachment
    Then enable the particular attachement
    
    Scenario Outline: 
    

  
