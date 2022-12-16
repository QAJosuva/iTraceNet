package com.staf.pageclass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class CompanyDetails extends WebDriverBase {
	public CompanyDetails(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='otherDetails-msmeRegistered']")
	WebElement MSMERegistered;
	@FindBy(xpath = "//input[@id='otherDetails-msmeRegisterNo']")
	WebElement MSMERegisteredNo;
	@FindBy(xpath = "//input[@id='otherDetails-providentFundNo']")
	WebElement PFNo;
	@FindBy(xpath = "//input[@id='otherDetails-incomeTaxPanNo']")
	WebElement PANno;
	@FindBy(xpath = "//input[@id='otherDetails-incomeTaxPanName']")
	WebElement nameOnPAN;
	@FindBy(xpath = "//input[@id='otherDetails-licenseNo']")
	WebElement labourLicense;
	@FindBy(xpath = "//input[@id='otherDetails-bankName']")
	WebElement bankName;
	@FindBy(xpath = "//select[@id='otherDetails-typeOfAcc']")
	WebElement accounttype;
	@FindBy(xpath = "//input[@id='otherDetails-accountNum']")
	WebElement accountNumber;
	@FindBy(xpath = "//input[@id='otherDetails-ifscCode']")
	WebElement ifscCode;
	@FindBy(xpath = "//input[@id='otherDetails-beneficiaryName']")
	WebElement benficaryName;
	@FindBy(xpath = "//input[@id='otherDetails-bankCountryDesc']")
	WebElement bankCounty;
	@FindBy(xpath = "(//*[@name='drop-search'])[4]")
	WebElement bankCountyseach;
	@FindBy(xpath = "//input[@id='otherDetails-bankStateDesc']")
	WebElement bankState;
	@FindBy(xpath = "(//*[@name='drop-search'])[5]")
	WebElement bankStateseach;
	@FindBy(xpath = "//input[@id='otherDetails-bankCity']")
	WebElement bankCity;
	@FindBy(xpath = "//input[@id='otherDetails-bankBranch']")
	WebElement bankbranch;
	@FindBy(xpath = "//label[contains(text(),'Other Details')]")
	WebElement scrollPupose;
	@FindBy(xpath = "//textarea[@id='otherDetails-bankStreet']")
	WebElement bankStreet;
	@FindBy(xpath = "//textarea[@id='otherDetails-Adress']")
	WebElement bankAddress;
	@FindBy(xpath = "//select[@id='otherDetails-inspecFacility']")
	WebElement inceptionFacility;
	@FindBy(xpath = "//select[@id='otherDetails-finYear1']")
	WebElement finacialyear;
	@FindBy(xpath = "//input[@id='otherDetails-finYear1Turnover']")
	WebElement turnover;
	@FindBy(xpath = "//button[@class='mat-tooltip-trigger btn view-btn pull-right']")
	WebElement continueBTN;

	public void checkpageCD() throws InterruptedException {
		
		
		try {
			Select sel = new Select(MSMERegistered);
			sel.selectByVisibleText(prop.getProperty("MSMEOption"));
		} catch (ElementNotInteractableException e) {

			e.printStackTrace();
		}

	}

	public void enterMSMEno() throws InterruptedException {

		try {
			MSMERegisteredNo.clear();
			MSMERegisteredNo.sendKeys(prop.getProperty("MSMEREgNo"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void enterPFno() {
		PFNo.clear();
		PFNo.sendKeys(prop.getProperty("PFNo"));
	}

	public void enterPANno() {
		PANno.clear();
		PANno.sendKeys(prop.getProperty("PANno"));
	}

	public void enterPANname() {
		nameOnPAN.clear();
		nameOnPAN.sendKeys(prop.getProperty("nameOnPAN"));
	}

	public void enterLabourLicense() {
		labourLicense.clear();
		labourLicense.sendKeys(prop.getProperty("labourLicense"));
	}

	public void enterBankName() {
		bankName.clear();
		bankName.sendKeys(prop.getProperty("bankName"));
	}

	public void selectBankType() {
		Select sel = new Select(accounttype);
		sel.selectByVisibleText(prop.getProperty("accounttype"));
	}

	public void enterAccountNumber() {
		accountNumber.clear();
		accountNumber.sendKeys(prop.getProperty("accountNumber"));
	}

	public void enterIFSCCode() {
		ifscCode.clear();
		ifscCode.sendKeys(prop.getProperty("ifscCode"));
	}

	public void enterBeneficaryName() {
		benficaryName.clear();
		benficaryName.sendKeys(prop.getProperty("benficaryName"));
	}

	public void selectBankCountry() throws InterruptedException {
		bankCounty.click();
		bankCountyseach.sendKeys(prop.getProperty("bankCountyseach"), Keys.TAB, Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", bankAddress);
		js.executeScript("window.scrollBy(0,250)", "");
	}

	public void selectBankState() {
		bankState.click();
		bankStateseach.sendKeys(prop.getProperty("bankStateseach"), Keys.TAB, Keys.ENTER);

	}

	public void enterBankCity() {
		bankCity.clear();
		bankCity.sendKeys(prop.getProperty("bankCity"));
	}

	public void enterBankBranch() {
		bankbranch.clear();
		bankbranch.sendKeys(prop.getProperty("bankbranch"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", inceptionFacility);

	}

	public void enterBankStreet() {
		bankStreet.clear();
		bankStreet.sendKeys(prop.getProperty("bankStreet"));
	}

	public void enterBankAddress() {
		bankAddress.clear();
		bankAddress.sendKeys(prop.getProperty("bankAddress"));
	}

	public void selectInceptionFacility() {
		Select sel = new Select(inceptionFacility);
		sel.selectByVisibleText(prop.getProperty("inceptionFacility"));
	}

	public void selectFinacialYear() {
		Select sel = new Select(finacialyear);
		sel.selectByVisibleText(prop.getProperty("finacialyear"));
		turnover.clear();
		turnover.sendKeys(prop.getProperty("turnover"));
	}

}
