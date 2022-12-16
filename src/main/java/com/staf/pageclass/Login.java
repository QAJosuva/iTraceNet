
package com.staf.pageclass;

import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.staf.webdrivermanager.WebDriverBase;

public class Login extends WebDriverBase {

	public Login(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='userType']")
	WebElement selectType;

	@FindBy(xpath = "//input[@id='userid']")
	WebElement username;

	@FindBy(xpath = "//input[@id='login-password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-login pull-left']")
	WebElement loginButton;

	public void selectType() {

		Select sel = new Select(selectType);
		sel.selectByVisibleText(prop.getProperty("selectType"));
		

	}

	public WebElement enterUserName() {
		username.sendKeys(prop.getProperty("Usename"));
		return username;

	}

	public WebElement enterPassword() {
		password.sendKeys(prop.getProperty("password"));
		return password;

	}

	public void clickOnLogin() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter captcha : ");
		String name = scan.nextLine();
		driver.findElement(By.xpath("//input[@placeholder='Captcha']")).sendKeys(name);
		loginButton.click();

	}

}
