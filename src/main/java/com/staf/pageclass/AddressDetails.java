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

public class AddressDetails extends WebDriverBase {
	public AddressDetails(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Address Details')]")
	WebElement addressDetails;
	@FindBy(xpath = "//select[@id='td-addressType-0-0']")
	WebElement addressType;
	@FindBy(xpath = "//input[@id='td-countryDesc-1-0']")
	WebElement country;
	@FindBy(xpath = "(//input[@name='drop-search'])[2]")
	WebElement countrySearch;
	@FindBy(xpath = "//input[@id='td-stateCodeDesc-2-0']")
	WebElement state;
	@FindBy(xpath = "(//input[@name='drop-search'])[3]")
	WebElement stateSearch;
	@FindBy(xpath = "//input[@id='td-city-3-0']")
	WebElement city;
	@FindBy(xpath = "//input[@id='td-pinCode-4-0']")
	WebElement pinCode;
	@FindBy(xpath = "//textarea[@id='td-street-5-0']")
	WebElement street;
	@FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/button[1]")
	WebElement streetEyeButton;
	@FindBy(xpath = "//textarea[@id='td-street']")
	WebElement streetCheck;
	@FindBy(xpath = "//body[1]/app-root[1]/app-default-layout-container[1]/div[1]/main[1]/div[1]/app-dynamic-vendor-forms[1]/div[13]/div[1]/div[1]/div[3]/div[2]/button[1]")
	WebElement saveButton;
	@FindBy(xpath = "//textarea[@id='td-addressLine1-6-0']")
	WebElement addressLine1;
	@FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/button[1]")
	WebElement addressLine1EyeButton;
	@FindBy(xpath = "//textarea[@id='td-street']")
	WebElement addressLline1Check;
	@FindBy(xpath = "//textarea[@id='td-addressLine2-7-0']")
	WebElement addressLine2;
	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/button[1]")
	WebElement addressLine2EyeButton;
	@FindBy(xpath = "//body/app-root[1]/app-default-layout-container[1]/div[1]/main[1]/div[1]/app-dynamic-vendor-forms[1]/div[13]/div[1]/div[1]/div[2]/div[1]")
	WebElement addressLline2Check;
	@FindBy(xpath = "//body/app-root[1]/app-default-layout-container[1]/div[1]/main[1]/div[1]/app-dynamic-vendor-forms[1]/div[13]/div[1]/div[1]/div[2]/div[1]")
	WebElement textCheck;
	@FindBy(xpath = "//textarea[@id='td-addressLine3-8-0']")
	WebElement addressLine3;
	@FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/button[1]")
	WebElement addressLine3EyeButton;
	@FindBy(xpath = "//textarea[@id='td-addressLine2']")
	WebElement addressLline3Check;
	@FindBy(xpath = "//button[@class='mat-tooltip-trigger btn view-btn pull-right']")
	WebElement continueButton;

	public void checkpageAD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//th[contains(text(),'Address Type')]"))));
		Select sel = new Select(addressType);
		sel.selectByVisibleText(prop.getProperty("addressType"));

	}

	public void selectCountry() {
		country.click();
		countrySearch.sendKeys(prop.getProperty("countrySearch"));
		countrySearch.sendKeys(Keys.TAB, Keys.ENTER);
	}

	public void selectState() throws InterruptedException {
		state.click();
		Thread.sleep(2000);
		stateSearch.sendKeys(prop.getProperty("stateSearch"), Keys.TAB, Keys.ENTER);

	}

	public void selectCity() {
		city.sendKeys(prop.getProperty("city"));
	}

	public void enterPinCode() {
		pinCode.clear();
		pinCode.sendKeys(prop.getProperty("pinCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,0)", "");
	}

	public void enterStreet() throws InterruptedException {
		street.sendKeys(prop.getProperty("street"));
		streetEyeButton.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton);
//		driver.findElement(By.xpath("//*[@id=\"teaxtAreaModal\"]/div/div/div[3]/div[2]/button")).click();
//		if (streetCheck.getText().equals(prop.getProperty("street"))) {
//			Thread.sleep(3000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", saveButton);
//
//		} else {
//
//		}

	}

	public void enterAddressLine1() throws InterruptedException {
		addressLine1.sendKeys(prop.getProperty("addressLine1"));
		Thread.sleep(2000);
		addressLine1EyeButton.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton);
		
//		if (textCheck.getText().equals(prop.getProperty("addressLine1"))) {
//			Thread.sleep(3000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", saveButton);
//
//		} else {

//		}
//		saveButton.click();

	}

	public void enterAddressLine2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		addressLine2.sendKeys(prop.getProperty("addressLine2"));
		Thread.sleep(2000);
		addressLine2EyeButton.click();
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;d
		js.executeScript("arguments[0].click();", saveButton);
//		if (textCheck.getText().equals(prop.getProperty("addressLine2"))) {
//			Thread.sleep(3000);
//			js.executeScript("arguments[0].click();", saveButton);
//		} else {
//
//		}

	}

	public void enterAddressLine3() throws InterruptedException {
		addressLine3.sendKeys(prop.getProperty("addressLine3"));
		Thread.sleep(2000);
		addressLine3EyeButton.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton);
		Thread.sleep(2000);
//		if (textCheck.getText().equals(prop.getProperty("addressLine3"))) {
//			Thread.sleep(3000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", saveButton);
//		} else {
//
//		}

	}

}
