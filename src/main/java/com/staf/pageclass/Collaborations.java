package com.staf.pageclass;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class Collaborations extends WebDriverBase {

	public Collaborations(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='mat-radio-container'])[1]")
	WebElement radioBTNYES;
	@FindBy(xpath = "(//span[@class='mat-radio-container'])[2]")
	WebElement radioBTNO;
	@FindBy(xpath = "//input[@id='collaborations-collabName']")
	WebElement Name;
	@FindBy(xpath = "//input[@id='collaborations-percShareHolders']")
	WebElement percentageOfShareHolder;
	@FindBy(xpath = "//input[@id='collaborations-collabRelationship']")
	WebElement relationShip;

	public void checkpageCol() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Collaborations')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Collaborations')]")).click();

	}

	public void selectRadioBTN() throws InterruptedException {
		String selectRadioNTN = prop.getProperty("RadioButton");
		if (selectRadioNTN.equals("Yes")) {
			radioBTNYES.click();
			Thread.sleep(2000);
			Name.sendKeys(prop.getProperty("Name"));
			percentageOfShareHolder.sendKeys(prop.getProperty("percentageOfShareHolder"));
			Thread.sleep(2000);
			relationShip.sendKeys(prop.getProperty("relationShip"));
		}
		else if(selectRadioNTN.equals("NO")) {
			radioBTNO.click();
			
		}
		driver.findElement(By.xpath("//a[contains(text(),'Company Details')]")).click();

	}

}
