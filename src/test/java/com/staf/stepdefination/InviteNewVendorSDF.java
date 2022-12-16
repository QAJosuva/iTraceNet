package com.staf.stepdefination;

import com.staf.pageclass.LandingPage;
import com.staf.pageclass.Login;
import com.staf.pageclass.SelectWorkFlow;
import com.staf.pageclass.VendorOnboarding;
import com.staf.webdrivermanager.WebDriverBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class InviteNewVendorSDF extends WebDriverBase {
	public Login lgn;
	public LandingPage land;
	public VendorOnboarding vendor;
	public SelectWorkFlow wrokflow;

	@Given("^Login to the application$")
	public void login_to_the_application() throws Throwable {
		getBrowser();
		lgn = new Login(driver, prop);
		lgn.selectType();
		lgn.enterUserName();
		lgn.enterPassword();
		lgn.clickOnLogin();
	}

	@Then("^Enter all mandatory fileds and click on invite$")
	public void enter_all_mandatory_fileds_and_click_on_invite() throws Throwable {
		vendor = new VendorOnboarding(driver, prop);
		vendor.selectTempleteNV();
		vendor.enterEmailIdNV();
		vendor.enterVendorNameNV();
		vendor.selectCountryCodeNV();
		vendor.enterPhoneNumberNV();
		
		

	}

	@And("^select organization and select new vendor tab$")
	public void select_organization_and_select_new_vendor_tab() throws Throwable {
		land = new LandingPage(driver, prop);
		land.selectVendor();
		vendor = new VendorOnboarding(driver, prop);
		vendor.clickOnVendorOnBoardingNV();
		vendor.selectVendorTypeNV();

	}

	@And("^check the new vendor is add in List of vendors$")
	public void check_the_new_vendor_is_add_in_list_of_vendors() throws Throwable {
		vendor.clickOnVendorTypeERP();
		vendor.planningGroupERP();
		vendor.vendorGroupERP();
//		vendor.clickOnAttachRadioBTN();
//		vendor.addNEWattachERP();
		vendor.clickOnInviteBTN();
		 wrokflow=new SelectWorkFlow(driver, prop);
    	 wrokflow.visibityofSelWrkFlLb();
    	 wrokflow.clickOnPrcBTN();
		
	}

}
