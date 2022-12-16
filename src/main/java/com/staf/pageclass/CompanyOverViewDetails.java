package com.staf.pageclass;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class CompanyOverViewDetails extends WebDriverBase {
	public CompanyOverViewDetails(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Company Overview')]")
	WebElement companyOverView;
	@FindBy(xpath = "//textarea[@id='companyOverviewDetails-generalDetails']")
	WebElement genaralDetailsOfSG;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-establishedDate']")
	WebElement companyEstablishedDate;
	@FindBy(xpath = "//mat-calendar-header/div[1]/div[1]/button[1]")
	WebElement chooseyearbutton;
	@FindBy(xpath = "//div[@class='mat-calendar-body-cell-preview']")
	List<WebElement> selectDate;
	@FindBy(xpath = "//mat-calendar-header/div[1]/div[1]/button[2]")
	WebElement lessButton;
	@FindBy(xpath = "//mat-calendar-header/div[1]/div[1]/button[3]")
	WebElement greaterButton;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-annualRevenue']")
	WebElement grossAnualInocome;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-geographicArea']")
	WebElement geographicServiceArea;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-bussinessType']")
	WebElement businessType;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-licenseNum']")
	WebElement CINNumber;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-gstin']")
	WebElement companyGST;
	@FindBy(xpath = "(//div[@class='pull-left'])[2]")
	WebElement Cmpname;

	@FindBy(xpath = "//input[@id='companyOverviewDetails-tradeName']")
	WebElement tradeName;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-tradeName']")
	WebElement legalName;
	@FindBy(xpath = "//input[@id='companyOverviewDetails-additionalInfo']")
	WebElement additionalInfo;
	@FindBy(xpath = "//button[@class='mat-tooltip-trigger btn view-btn pull-right']")
	WebElement continueButton;

	public void checkpageCOVD() {
		if (companyOverView.getText().equalsIgnoreCase(prop.getProperty("companyOverView"))) {
			genaralDetailsOfSG.sendKeys(prop.getProperty("GeneralDetailsOfGoodandServices"));

		}

	}

	public void enterComapnyEstablishedDate() {
		companyEstablishedDate.click();
		chooseyearbutton.click();
		String year = prop.getProperty("ComapanyEstablishedyear");
		if (Integer.valueOf(year) >= 2016 && Integer.valueOf(year) < 2039) {
			for (int i = 0; i < selectDate.size(); i++) {
				if (selectDate.get(i).getText().equalsIgnoreCase(year)) {
					selectDate.get(i).click();
				}
				for (int j = 0; j < selectDate.size(); j++) {
					if (selectDate.get(i).getText().equalsIgnoreCase(year)) {
						selectDate.get(i).click();
					}

				}
			}

		} else if (Integer.valueOf(year) < 2016) {
			lessButton.click();
			for (int i = 0; i < selectDate.size(); i++) {
				if (selectDate.get(i).getText().equalsIgnoreCase(year)) {
					selectDate.get(i).click();
				} else
					lessButton.click();

			}
		} else if (Integer.valueOf(year) > 2039) {
			lessButton.click();
			for (int i = 0; i < selectDate.size(); i++) {
				if (selectDate.get(i).getText().equalsIgnoreCase(year)) {
					selectDate.get(i).click();
				} else
					lessButton.click();
			}
		}
	}

	public void enterGgrossAnualInocome() {

		grossAnualInocome.sendKeys(prop.getProperty("grossAnualInocome"));
	}

	public void enterGeographicServiceArea() {
		geographicServiceArea.sendKeys(prop.getProperty("geographicServiceArea"));

	}

	public void enterBusinessType() {
		businessType.sendKeys(prop.getProperty("businessType"));

	}

	public void enterCINNumber() {
		CINNumber.sendKeys(prop.getProperty("CINNumber"));

	}

	public void enterCompanyGST() {
		companyGST.sendKeys(prop.getProperty("companyGST"), Keys.TAB);

	}

	public void checkingGSTINNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Cmpname));
		String text = Cmpname.getText();
		BasicDetails b = new BasicDetails(driver, prop);
		b.clickOnBasicDetails();
		String text2 = b.NmaeOfCompany.getText();
		if (text.contains(text2)) {
			companyOverView.click();

		}
	}

	public void enterTradeName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Cmpname));
//		tradeName.clear();
		tradeName.sendKeys(prop.getProperty("tradeName"));
		tradeName.clear();
	}

	public void enterLegalName() {
		legalName.sendKeys(prop.getProperty("legalName"));

	}

	public void enterAdditionalInfo() {
		additionalInfo.sendKeys(prop.getProperty("additionalInfo"));

	}

	public void clickOnContinueButton() {

		continueButton.click();
	}
}
