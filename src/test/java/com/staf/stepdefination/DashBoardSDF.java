package com.staf.stepdefination;

import com.staf.pageclass.LandingPage;
import com.staf.pageclass.Login;
import com.staf.pageclass.VendorOnboarding;
import com.staf.utilis.ExtentReportsClass;
import com.staf.webdrivermanager.WebDriverBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashBoardSDF extends WebDriverBase {
	public Login lgn;
	public LandingPage board;
	public VendorOnboarding vendor;

	@Given("^user should navigate to dashboard with valid credentials$")
	public void user_should_navigate_to_dashboard_with_valid_credentials() throws Throwable {
		ExtentReportsClass.config("Browser");
		getBrowser();

		lgn = new Login(driver, prop);
		ExtentReportsClass.config("Loginpage");
		lgn.enterUserName();
		lgn.enterPassword();
		lgn.selectType();
		lgn.clickOnLogin();

	}

	@Then("^Enter the all mandatory fields$")
	public void enter_the_all_mandatory_fields() throws Throwable {
		vendor = new VendorOnboarding(driver, prop);
		ExtentReportsClass.config("Invite New Vendor");
		vendor.clickOnVendorOnBoardingNV();
		vendor.selectVendorTypeNV();
		vendor.selectTempleteNV();
		vendor.enterEmailIdNV();
		vendor.enterVendorNameNV();
		vendor.selectCountryCodeNV();
		vendor.enterPhoneNumberNV();
		vendor.clickOnVendorTypeERP();
		vendor.clickOnVendorTypeERP();

	}

	@And("^click on Vendor Onboard$")
	public void click_on_vendor_onboard() throws Throwable {
		board = new LandingPage(driver, prop);
		ExtentReportsClass.config("Landingpage");
		Thread.sleep(10000);
		board.selectVendor();

	}

}
