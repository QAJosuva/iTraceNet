package com.staf.stepdefination;

import com.staf.pageclass.Login;
import com.staf.utilis.ExtentReportsClass;
import com.staf.webdrivermanager.WebDriverBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSTF extends WebDriverBase {
	Login lgn;

	@Given("^User should navigate to Pcollab with valid url from any browser$")
	public void user_should_navigate_to_pcollab_with_valid_url_from_any_browser() throws Throwable {
		ExtentReportsClass.config("browserLaunch");
		getBrowser();

	}

	@Then("^Click on Login button dashboard should display$")
	public void click_on_login_button_dashboard_should_display() throws Throwable {
		lgn = new Login(driver, prop);
		lgn.clickOnLogin();

	}

	@And("^user should select the user Type$")
	public void user_should_select_the_user_type() throws Throwable {
		lgn = new Login(driver, prop);
		lgn.selectType();
	}

	@And("^user enter the valid userName and Valid password$")
	public void user_enter_the_valid_username_and_valid_password() throws Throwable {
		lgn = new Login(driver, prop);
		lgn.enterUserName();
		lgn.enterPassword();

	}

}
