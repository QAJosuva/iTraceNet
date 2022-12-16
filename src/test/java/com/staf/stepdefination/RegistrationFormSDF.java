package com.staf.stepdefination;

import com.staf.pageclass.AddressDetails;
import com.staf.pageclass.Attachments;
import com.staf.pageclass.BasicDetails;
import com.staf.pageclass.Collaborations;
import com.staf.pageclass.CompanyDetails;
import com.staf.pageclass.CompanyOverViewDetails;
import com.staf.pageclass.Declaration;
import com.staf.pageclass.PaymentDetails;
import com.staf.webdrivermanager.WebDriverBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegistrationFormSDF extends WebDriverBase {
	private BasicDetails basic;
	AddressDetails address;
	private CompanyOverViewDetails overv;
	Collaborations col;
	CompanyDetails companyDetails;
	PaymentDetails payment;
	Attachments attachment;
	Declaration declaration;

	@Given("^Navigate to the vendor registration form$")
	public void navigate_to_the_vendor_registration_form() throws Throwable {
		getBrowser();
	}

	@Then("^Click on submit$")
	public void click_on_submit() throws Throwable {

	}

	@And("^Provide basic details$")
	public void provide_basic_details() throws Throwable {

		basic = new BasicDetails(driver, prop);
		basic.checkpageBD();
		basic.enterNameOfComapnay();
		basic.enterWebSiteURL();
		basic.enterNmaeOfPartner();
		basic.enterRegisterdAdd();
		basic.selectTypeOfFirm();
		basic.selectTittle();
		basic.enterPointOfContactName();
		basic.enterDesignation();
		basic.enterEmailID();
		basic.enterContactNumber();
		basic.enterAlternativeNumber();
		basic.clickOnContinueButton();

	}

	@And("^Provide Company Overview details$")
	public void provide_company_overview_details() throws Throwable {

		overv = new CompanyOverViewDetails(driver, prop);
		overv.checkpageCOVD(); //
		// overv.enterComapnyEstablishedDate(); overv.enterGgrossAnualInocome();
		overv.enterGeographicServiceArea();
		overv.enterBusinessType();
		overv.enterCINNumber();
		overv.enterCompanyGST();
		overv.enterTradeName();
		overv.checkingGSTINNumber();
		overv.enterLegalName();
		overv.enterAdditionalInfo();
		basic.clickOnContinueButton();

	}

	@And("^Provide Address details$")
	public void provide_address_details() throws Throwable {

		address = new AddressDetails(driver, prop);
		address.checkpageAD();
		address.selectCountry();
		address.selectState();
		address.selectCity();
		address.enterPinCode();
		address.enterStreet();
		address.enterAddressLine1();
		address.enterAddressLine2();
		address.enterAddressLine3();
		basic.clickOnContinueButton();

	}

	@And("^Provide colaboration details$")
	public void provide_colaboration_details() throws Throwable {

		col = new Collaborations(driver, prop);
		col.checkpageCol();
		col.selectRadioBTN();

	}

	@And("^Provide company details$")
	public void provide_company_details() throws Throwable {

		companyDetails = new CompanyDetails(driver, prop);
		companyDetails.checkpageCD();
		companyDetails.enterMSMEno();
		companyDetails.enterPFno();
		companyDetails.enterPANno();
		companyDetails.enterPANname();
		companyDetails.enterLabourLicense();
		companyDetails.enterBankName();
		companyDetails.selectBankType();
		companyDetails.enterAccountNumber();
		companyDetails.enterIFSCCode();
		companyDetails.enterBeneficaryName();
		companyDetails.selectBankCountry();
		companyDetails.selectBankState();
		companyDetails.enterBankCity();
		companyDetails.enterBankBranch();
		companyDetails.enterBankStreet();
		companyDetails.enterBankAddress();
		companyDetails.selectInceptionFacility();
		companyDetails.selectFinacialYear();
		basic.clickOnContinueButton();

	}

	@And("^Provide payment details$")
	public void provide_payment_details() throws Throwable {

		payment = new PaymentDetails(driver, prop);
		payment.checkpagePD();
		payment.selectCurrencyCode();
		payment.slectPaymentType();
		payment.selectPaymentTerms();
		basic.clickOnContinueButton();

	}

	@And("^Provide Attachments details$")
	public void provide_attachments_details() throws Throwable {

		attachment = new Attachments(driver, prop);
		attachment.checkpageATT();
		attachment.enterDocumentType();
		attachment.uploadFile();
		attachment.downoadFile();
		attachment.saveedFile();
		attachment.deleteFile();
		basic.clickOnContinueButton();

	}

	@And("^Provide declaration details$")
	public void provide_declaration_details() throws Throwable {
		declaration = new Declaration(driver, prop);
		declaration.checkpageDD();
		declaration.enterApplicationName();
		declaration.enteCompanyName();
		declaration.entePlace();
//		basic.clickOnContinueButton();
	}

}
