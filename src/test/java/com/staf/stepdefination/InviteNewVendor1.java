package com.staf.stepdefination;

import com.staf.pageclass.LandingPage;
import com.staf.pageclass.Login;
import com.staf.pageclass.SelectWorkFlow;
import com.staf.pageclass.VendorOnboarding;
import com.staf.webdrivermanager.WebDriverBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InviteNewVendor1 extends WebDriverBase {
	public Login lgn;
	public VendorOnboarding ven;
	public LandingPage ldn;
	public SelectWorkFlow wrokflow;
	@Given("^Navigate to the browser$")
    public void navigate_to_the_browser() throws Throwable {
		getBrowser();
		
            }
	

    @Given("^provide all postive data$")
    public void provide_all_postive_data() throws Throwable {
    	ven=new VendorOnboarding(driver, prop);
    	ven.selectTempleteNV();
		ven.enterEmailIdNV();		
		ven.enterVendorNameNV();
		ven.selectCountryCodeNV();
		ven.enterPhoneNumberNV();
		ven.clickOnVendorTypeERP();
		ven.planningGroupERP();
		ven.vendorGroupERP();
		ven.addNEWattachERP();
		ven.clickOnAttachRadioBTN();

        
    }

    @Given("^provide all negative data$")
    public void provide_all_negative_data() throws Throwable {
    	ven=new VendorOnboarding(driver, prop);
    	ven.selectTempleteNV();
		ven.enterEmailIdNV();
		ven.enterVendorNameNV();
		ven.selectCountryCodeNV();
		ven.enterPhoneNumberNV();
		ven.clickOnVendorTypeERP();
		ven.planningGroupERP();
		ven.vendorGroupERP();
		ven.selectCountryCodeNV();
		ven.enterPhoneNumberNV();
    }

    @Given("^add new attchment$")
    public void add_new_attchment() throws Throwable {
       
    }

    @When("^and validate the error messages$")
    public void and_validate_the_error_messages() throws Throwable {
       
    }

    @Then("^Navigating to landing page$")
    public void Navigating_to_landing_page() throws Throwable {
    	lgn=new Login(driver, prop);
    	lgn.selectType();
    	lgn.enterUserName();
    	lgn.enterPassword();
    	lgn.clickOnLogin();
    	ldn=new LandingPage(driver, prop);
    	ldn.selectVendor();
    	VendorOnboarding ven=new VendorOnboarding(driver, prop);
    	ven.clickOnVendorOnBoardingNV();
		ven.selectVendorTypeNV();
       
    }

    @Then("^select workflow and click on proceed$")
    public void select_workflow_and_click_on_proceed() throws Throwable {
    	 wrokflow=new SelectWorkFlow(driver, prop);
    	 wrokflow.visibityofSelWrkFlLb();
    	 wrokflow.clickOnPrcBTN();
       
    }

    @Then("^enable the particular attachement$")
    public void enable_the_particular_attachement() throws Throwable {
       
    }

    @And("^click on Invite button$")
    public void click_on_invite_button() throws Throwable {
    	ven=new VendorOnboarding(driver, prop);
    	ven.clickOnInviteBTN();
    }

    @And("^delete the added attachment$")
    public void delete_the_added_attachment() throws Throwable {
       
    }

}
