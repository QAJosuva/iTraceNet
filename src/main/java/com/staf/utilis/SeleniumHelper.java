package com.staf.utilis;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.gherkin.model.Scenario;

public class SeleniumHelper{
	private static Logger logger=Logger.getLogger(SeleniumHelper.class);
	 WebDriver driver;
	public Properties properties;
	
	public SeleniumHelper(WebDriver driver) {
		this.driver=driver;
		this.driver.manage().window().maximize();
	}
	public Boolean isEnabled(WebElement ele) {
		boolean temp=false;
		try {
			if(ele.isEnabled()) {			
				temp=true;
				return temp;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return temp;
		
	}
	public void clear(WebElement ele) {
		try {
			ele.clear();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public static void setScenerio(Scenario scenario) {
		
	}
	
	public void screenshot() throws IOException {
		File ScreenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenshotFile,new File("user.dir)"+"//target//screenshot//name.png" ));
	}

}
