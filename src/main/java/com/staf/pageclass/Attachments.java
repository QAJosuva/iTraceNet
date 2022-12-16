package com.staf.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;
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

public class Attachments extends WebDriverBase {
	public Attachments(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Attachments')]")
	WebElement ladel;
	@FindBy(xpath = "//*[@class='btn btn-transparent plus-btn']")
	WebElement addDocument;
	@FindBy(xpath = "//button[@class='mat-tooltip-trigger btn view-btn pull-right']")
	WebElement continueButton;
	@FindBy(xpath = "//input[@id='docType-12']")
	WebElement documentType;
	@FindBy(xpath = "//*[@class='mat-tooltip-trigger fa fa-upload mr-2 upload-icon']")
	List<WebElement> uploadicon;
	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	WebElement uploadBTN;
	@FindBy(xpath = "//div[contains(text(),'File uploaded successfully.')]")
	WebElement toasterMSG;
	@FindBy(xpath = "//*[@class='mat-tooltip-trigger fa fa-download mr-2 download-icon']")
	List<WebElement> downloadButton;
	@FindBy(xpath = "//*[@class='mat-tooltip-trigger fa fa-trash delete-icon']")
	List<WebElement> deleteBTN;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	WebElement confirmDelete;

	public void checkpageATT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Attachments')]"))));
		addDocument.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", continueButton);
		Thread.sleep(2000);

	}

	public void enterDocumentType() {
		documentType.clear();
		documentType.sendKeys(prop.getProperty("documentType"));
	}

	public void uploadFile() throws AWTException, InterruptedException {
		int up = uploadicon.size();
		driver.findElement(By.xpath("(//*[@class='mat-tooltip-trigger fa fa-upload mr-2 upload-icon'])[" + up + "]"))
				.click();

		StringSelection stringSelection = new StringSelection("C:\\Users\\user\\Downloads\\img.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		uploadBTN.click();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(toasterMSG));

	}

	public void downoadFile() throws InterruptedException {

		int download = downloadButton.size();
		driver.findElement(
				By.xpath("(//*[@class='mat-tooltip-trigger fa fa-download mr-2 download-icon'])[" + download + "]"))
				.click();

	}

	public void saveedFile() {
		File f = new File("C:\\Users\\user\\Downloads\\img.png");
		if (f.exists())

			System.out.println("Exists");
		else
			System.out.println("Does not Exists");
	}

	public void deleteFile() throws InterruptedException {
		int del = deleteBTN.size() - 1;
		driver.findElement(By.xpath("(//*[@class='mat-tooltip-trigger fa fa-trash delete-icon'])[" + del + "]"))
				.click();
		Thread.sleep(2000);
		confirmDelete.click();

	}

}
