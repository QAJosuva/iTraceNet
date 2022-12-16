package com.staf.pageclass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class Declaration extends WebDriverBase {

	public Declaration(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	
	 

	@FindBy(xpath = "//a[contains(text(),'Declaration')]")
	WebElement ladel;
	@FindBy(css = ".mat-tooltip-trigger.btn.view-btn.pull-right.mr-2.ng-star-inserted")
	WebElement backButton;
	@FindBy(css = "label[for='declaration-input'] span[class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	WebElement dc1;
	@FindBy(css = "label[for='underTakingAck-input'] span[class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	WebElement dc2;
	@FindBy(css = "label[for='ack1-input'] span[class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	WebElement dc3;
	

	@FindBy(xpath = "//input[@id='declaration-nameOfApplicant']")
	WebElement nameOfApplication;
	@FindBy(xpath = "//input[@id='declaration-applierCompanyName']")
	WebElement companyName;
	@FindBy(xpath = "//input[@id='declaration-placeOfApplicant']")
	WebElement place;
	@FindBy(xpath = "//input[@id='declaration-applicationDate']")
	WebElement date;

	public void checkpageDD() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Declaration')]"))));
		Thread.sleep(2000);
		dc1.click();
		dc2.click();
		dc3.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		

	}
	public void enterApplicationName() {
		nameOfApplication.clear();
		nameOfApplication.sendKeys(prop.getProperty("nameOfApplication"));
	}
	public void enteCompanyName() {
		companyName.clear();
		companyName.sendKeys(prop.getProperty("companyName"));
	}
	public void entePlace() {
		place.clear();
		place.sendKeys(prop.getProperty("place"));
	}


}
