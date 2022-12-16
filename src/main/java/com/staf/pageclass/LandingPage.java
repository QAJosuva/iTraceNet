package com.staf.pageclass;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class LandingPage extends WebDriverBase {
	public LandingPage(WebDriver driver,Properties prop) {
		this.driver = driver;
		this.prop=prop;
		PageFactory.initElements(driver,this);
	} 
	@FindBy(xpath="//div[@class='mat-tooltip-trigger landing-widgets-title']")
	List<WebElement> vendors;
	
	@FindBy(xpath = "//div[@class='card-header']/span")
	WebElement organozationLAB;
	
	public void selectVendor() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(organozationLAB));
			
		  try {
			for(int i=0;i<vendors.size();i++) {
			  if(vendors.get(i).getText().contains(prop.getProperty("vendorName"))){
			  vendors.get(i).click();		 
			  
			  } }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
		
	}
	
	
	

}
