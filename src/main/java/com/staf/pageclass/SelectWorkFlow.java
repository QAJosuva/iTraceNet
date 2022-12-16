package com.staf.pageclass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectWorkFlow {
	public WebDriver driver;
	public Properties prop;

	public SelectWorkFlow(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='WorkflowId']")
	WebElement selectWrkFloLB;
	@FindBy(xpath = "//button[@id='Proceed']")
	WebElement proccedBTN;

	public void visibityofSelWrkFlLb() {
		try {
			Select sel = new Select(selectWrkFloLB);
			sel.selectByVisibleText(prop.getProperty("SelectWorkFlow"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnPrcBTN() {
		try {
			proccedBTN.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
