package com.staf.pageclass;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.webdrivermanager.WebDriverBase;

public class VendorOnboarding extends WebDriverBase {

	public VendorOnboarding(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Invite Vendor grid
	 */
	@FindBy(xpath = "//div[@class='card-header']/span")
	WebElement applocationLaunchLAB;
	@FindBy(xpath = "//li[@class='nav-item nav-dropdown ng-star-inserted']")
	List<WebElement> vendorOnBoarding;
	@FindBy(xpath = "//div[@class='landing-widgets-title']")
	List<WebElement> selectVendortype;
	@FindBy(xpath = "//select[@name='tempateId']")
	WebElement Templete;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "(//div[@class='form-group']/input)[1]")
	WebElement vendorName;
	@FindBy(id = "countryPhoneCode")
	WebElement countryCode;
	@FindBy(xpath = "(//div[@class='col-md-8']/input)[1]")
	WebElement phoneNumber;

	/**
	 * ERP Refference Data grid
	 */

	@FindBy(xpath = "//input[@name='vendorType']")
	WebElement vendorTypeERP;
	@FindBy(xpath = "//input[@name='planningGroup']")
	WebElement planningGroputERP;
	@FindBy(xpath = "//input[@name='vendorGroup']")
	WebElement VendorGroupERP;

	/**
	 * Attachments
	 */
	@FindBy(xpath = "//input[@name='attachment']")
	List<WebElement> attachmentTextERP;

	@FindBy(xpath = "(//div[@class='mat-slide-toggle-thumb-container'])[4]")
	WebElement attachmentRadioBtnERP;

	@FindBy(xpath = "//i[@class='mat-tooltip-trigger fa fa-plus plus-icon ng-star-inserted']")
	WebElement addNewAttachERP;
	@FindBy(xpath = "//span[@class='submit-text']")
	WebElement inviteButnERP;

	/**
	 * Invite Vendor grid
	 * 
	 * @throws InterruptedException
	 */

	public WebElement clickOnVendorOnBoardingNV() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(applocationLaunchLAB));
		Thread.sleep(4000);
		try {
			for (int i = 0; i < vendorOnBoarding.size(); i++) {
				if (vendorOnBoarding.get(i).getText().equalsIgnoreCase("Vendor Onboarding")) {
					vendorOnBoarding.get(i).click();
				}
			}
		} catch (StaleElementReferenceException e) {

			e.printStackTrace();

		}
		return null;

	}

	public void selectVendorTypeNV() {
		for (int i = 0; i < selectVendortype.size(); i++) {
			try {
				if (selectVendortype.get(i).getText().equalsIgnoreCase(prop.getProperty("vendorType"))) {
					selectVendortype.get(i).click();

				}
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public void selectTempleteNV() {
		try {
			Select sel = new Select(Templete);
			sel.selectByVisibleText("Vendor Registration Master Form");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public WebElement enterEmailIdNV() throws InterruptedException {
		try {
			email.sendKeys(prop.getProperty("EmailNV"));
			email.sendKeys(Keys.TAB);
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return email;
	}

	public void enterVendorNameNV() {
		try {
			vendorName.clear();
			vendorName.sendKeys(prop.getProperty("VendorNameNV"));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void selectCountryCodeNV() {
		try {
			Select sel = new Select(countryCode);
			sel.selectByVisibleText("India (+91)");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterPhoneNumberNV() throws InterruptedException {
		try {
			phoneNumber.clear();
			phoneNumber.sendKeys(prop.getProperty("PhoneNumberNV"));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ERP Refference Data grid
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void clickOnVendorTypeERP() throws AWTException, InterruptedException {

		try {
			vendorTypeERP.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='search-items']/a[contains(text(),'Domestic Vendor ')])[1]"))
					.click();
		} catch (Exception e) {
			System.out.println("clicked By JavascriptExecutor");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", vendorTypeERP);

		}

		try {
			String ReconText = driver.findElement(By.xpath("//input[@name='reconciAcctDesc']")).getText();
			if (vendorTypeERP.getText().equals(prop.getProperty("tx1")) || ReconText.equals("")) {
				System.out.println("true");
			} else
				System.out.println("False");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void planningGroupERP() throws AWTException, InterruptedException {
		try {
			planningGroputERP.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='search-items']/a[contains(text(),'"
					+ prop.getProperty("planningGroupSearchERP") + "')]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void vendorGroupERP() throws AWTException, InterruptedException {
		try {
			VendorGroupERP.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='search-items']/a[contains(text(),'"
					+ prop.getProperty("VendorGroupSearchERP") + "')]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickOnAttachRadioBTN() throws AWTException, InterruptedException {
		Thread.sleep(2000);

		for (int i = 0; i < attachmentTextERP.size(); i++) {
			try {
				if (attachmentTextERP.get(i).getText().equalsIgnoreCase("PF Registration Certificate")) {
					System.out.println(attachmentTextERP.get(i).getText());
					System.out.println(attachmentTextERP.get(i).getText());
					driver.findElement(By.xpath("(//label[@class='mat-slide-toggle-label'])[" + i + "]")).click();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
			// Robot rd = new Robot();
//				rd.keyPress(KeyEvent.VK_TAB);
//				rd.keyRelease(KeyEvent.VK_TAB);
//				rd.keyPress(KeyEvent.VK_SPACE);
//				rd.keyRelease(KeyEvent.VK_SPACE);
//				System.out.println("--------------");

		}

	}

	public void addNEWattachERP() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addNewAttachERP);

		try {
			addNewAttachERP.click();
		} catch (ElementClickInterceptedException e) {

			e.printStackTrace();
		}
		Thread.sleep(3000);
		int size = attachmentTextERP.size();
		System.out.println(size);
		attachmentTextERP.get(size - 1).sendKeys(prop.getProperty("newAttachmentName"));

	}

	public void clickOnInviteBTN() {
		try {
			inviteButnERP.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
