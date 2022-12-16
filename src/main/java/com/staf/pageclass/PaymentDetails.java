package com.staf.pageclass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class PaymentDetails extends WebDriverBase {

	public PaymentDetails(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='paymentInfo-countryCodeDesc']")
	WebElement countryCode;
	@FindBy(xpath = "(//*[@name='drop-search'])[6]")
	WebElement countryCodeSearch;
	@FindBy(xpath = "//input[@id='paymentInfo-currencyDesc']")
	WebElement currencyCode;
	@FindBy(xpath = "(//*[@name='drop-search'])[7]")
	WebElement currencyCodeSearch;
	@FindBy(xpath = "//select[@id='paymentInfo-typeOfPayment']")
	WebElement paymentType;
	@FindBy(xpath = "//input[@id='paymentInfo-paymentTermsDesc']")
	WebElement paymentTerms;
	@FindBy(xpath = "(//*[@name='drop-search'])[8]")
	WebElement paymentTermsSearch;
	 	
	public void checkpagePD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Payment Details')]"))));
		countryCode.click();
		countryCodeSearch.clear();
		countryCodeSearch.sendKeys(prop.getProperty("countryCodeSearch"),Keys.TAB,Keys.ENTER);
	}
	public void selectCurrencyCode() {
		currencyCode.click();
		currencyCodeSearch.clear();
		currencyCodeSearch.sendKeys(prop.getProperty("currencyCodeSearch"),Keys.TAB,Keys.ENTER);
	}
	public void slectPaymentType() {
		Select sel=new Select(paymentType);
		sel.selectByVisibleText(prop.getProperty("paymentType"));
		
	}
	public void selectPaymentTerms() {
		paymentTerms.click();
		paymentTermsSearch.clear();
		paymentTermsSearch.sendKeys(prop.getProperty("paymentTermsSearch"),Keys.TAB,Keys.ENTER);
	}
	
	

}
