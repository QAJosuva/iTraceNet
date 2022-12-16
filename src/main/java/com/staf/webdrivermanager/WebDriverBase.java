package com.staf.webdrivermanager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

public class WebDriverBase {
	public WebDriver driver;
	public Properties prop = new Properties();
	private static final Logger log = Logger.getLogger(WebDriverBase.class);

	public void getBrowser() throws IOException, InterruptedException, AWTException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspace\\AUT\\src\\test\\resources\\Config.property");
		prop.load(file);
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			log.info("Chrome brower is opened");
//			ChromeOptions options=new ChromeOptions();	
			
//			options.addArguments("--disable-notification");
//			options.addArguments("--disable-geolocation");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("registrationurl"));
		/*
		 * Thread.sleep(2000); Actions act = new Actions(driver); try {
		 * act.sendKeys(Keys.ESCAPE).build().perform(); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		try {
			Robot rd=new Robot();
			rd.keyPress(KeyEvent.VK_ESCAPE);	
			rd.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			System.out.println("Not Performed");
			e.printStackTrace();
		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
}
