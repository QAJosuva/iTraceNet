
Feature: p-Collab

  @NewVendor
  Scenario: Inviting new Vendor
    Given Login to the application
    And select organization and select new vendor tab
    Then Enter all mandatory fileds and click on invite
    And check the new vendor is add in List of vendors


