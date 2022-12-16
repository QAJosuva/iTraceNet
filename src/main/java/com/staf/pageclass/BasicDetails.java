package com.staf.pageclass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
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

public class BasicDetails extends WebDriverBase {
	public BasicDetails(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Basic Details')]")
	public  WebElement basicDetails;
	@FindBy(xpath = "//input[@id='basicDetails-businessNature']")
	WebElement natureOfBussines;
	@FindBy(xpath = "(//input[@name='drop-search'])[1]")
	WebElement natureOfBussinesSearch;
	@FindBy(xpath = "//input[@id='basicDetails-companyName']")
	public  WebElement NmaeOfCompany;
	@FindBy(xpath = "//input[@id='basicDetails-webSite']")
	WebElement webSiteURL;
	@FindBy(xpath = "//select[@id='basicDetails-typeOfFirm']")
	WebElement typeOfFirm;
	@FindBy(xpath = "//input[@id='basicDetails-partnerName']")
	WebElement nameOfPartner;
	@FindBy(xpath = "//input[@id='basicDetails-partnerAddress']")
	WebElement registerdAddress;
	@FindBy(xpath = "//select[@id='basicDetails-pointOfContactTitle']")
	WebElement Tittle;
	@FindBy(xpath = "//input[@id='basicDetails-pointOfContactName']")
	WebElement pointofContactName;

	@FindBy(xpath = "//input[@id='basicDetails-contactDesignation']")
	WebElement designation;
	@FindBy(xpath = "//input[@id='basicDetails-contactEmail']")
	WebElement EmailID;
	@FindBy(xpath = "//input[@id='basicDetails-contactPhone1']")
	WebElement ContactNumber;
	@FindBy(xpath = "//input[@id='basicDetails-contactPhone2']")
	WebElement alternativeNumber;
	@FindBy(xpath = "//button[@class='mat-tooltip-trigger btn view-btn pull-right']")
	WebElement continueButton;

	public  void clickOnBasicDetails() {
		basicDetails.click();
	}

	public void checkpageBD() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='card-title pull-left']"))));

		natureOfBussines.click();
		natureOfBussinesSearch.sendKeys(prop.getProperty("natureOfBussinesSearch"));
		natureOfBussinesSearch.sendKeys(Keys.TAB, Keys.ENTER);

	}

	public void enterNameOfComapnay() {
		NmaeOfCompany.sendKeys(prop.getProperty("NameOfComapnay"));
	}

	public void enterWebSiteURL() {
		webSiteURL.sendKeys(prop.getProperty("WebSiteURL"));
	}

	public void selectTypeOfFirm() {
		Select sel = new Select(typeOfFirm);
		sel.selectByVisibleText(prop.getProperty("TypeOfFirm"));

	}

	public void enterNmaeOfPartner() {
		nameOfPartner.sendKeys(prop.getProperty("nameOfPartner"));
	}

	public void enterRegisterdAdd() {
		registerdAddress.sendKeys(prop.getProperty("registerdAddress"));
	}

	public void selectTittle() {
		Select sel = new Select(Tittle);
		sel.selectByVisibleText(prop.getProperty("Tittle"));
	}

	public void enterPointOfContactName() {
		pointofContactName.sendKeys(prop.getProperty("pointofContactName"));
	}

	public void enterDesignation() {
		designation.sendKeys(prop.getProperty("designation"));
	}

	public void enterEmailID() {
		EmailID.sendKeys(prop.getProperty("Email"));
	}

	public void enterContactNumber() {
		ContactNumber.sendKeys(prop.getProperty("ContactNumber"));
	}

	public void enterAlternativeNumber() {
		alternativeNumber.sendKeys(prop.getProperty("alternativeNumber"));
	}

	public void clickOnContinueButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", continueButton);
		continueButton.click();
		Thread.sleep(3000);
	}

}
