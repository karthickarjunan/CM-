package com.cm.checkin;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	public static final String CHROME_DRIVER = "C:\\Users\\jeeva\\eclipse-workspace1\\CM-ApplicationAutomation\\chromedriver.exe";

	
	public static void RobotPopup(String uname, String pass) throws Exception {
		Robot rb = new Robot();
		StringSelection username = new StringSelection(uname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		StringSelection pwd = new StringSelection(pass);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

	}

	public static void RobotEnter() throws Exception {
		Thread.sleep(1500);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

	}

	public static void VShortWait() throws Exception {
		Thread.sleep(2000);

	}

	public static void ShortWait() throws Exception {
		Thread.sleep(4000);

	}

	public static void LongWait() throws Exception {
		Thread.sleep(10000);

	}
	public static void Click(WebElement element)  {
	element.click();

	}
	public static void Type(WebElement element,String value) {
		element.clear();
		element.sendKeys(value);

	}
	
	
	//Webelements
	
	public static WebElement btnLanguageEnglish(WebDriver driver) {
		WebElement btnLanguageEnglish = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"enUSEdition\"]")));
		return btnLanguageEnglish;

	}

	public static WebElement btnCheckInHome(WebDriver driver) {
		WebElement btnCheckInHome = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class=\"magnet-icon ac-tab-checkin ac-1x\"]")));

		return btnCheckInHome;

	}

	public static WebElement inpFirstname(WebDriver driver) {
		WebElement inpFirstname = driver.findElement(By.id("checkin_first_name"));
		return inpFirstname;

	}

	public static WebElement inpLastname(WebDriver driver) {
		WebElement inpLastname = driver.findElement(By.id("checkin_last_name"));
		return inpLastname;

	}

	public static WebElement inpDeparture(WebDriver driver) {
		WebElement inpDeparture = driver.findElement(By.id("checkin_location"));
		return inpDeparture;

	}

	public static WebElement inpPnr(WebDriver driver) {
		WebElement inpPnr = driver.findElement(By.id("checkin_aeroplan_or_pnr"));
		return inpPnr;

	}

	public static WebElement btnCheckIn(WebDriver driver) {
		WebElement btnCheckIn = driver.findElement(By.id("checin_submit_button"));
		return btnCheckIn;

	}

	public static WebElement btnContinueCheckin(WebDriver driver) {
		WebElement btnContinueCheckin = (new WebDriverWait(driver, 60)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continue check-in')]")));
		return btnContinueCheckin;

	}

	public static WebElement btnCheckinNow(WebDriver driver) {
		WebElement btnCheckinNow = driver.findElement(By.xpath("//span[text()='Check in now']"));
		return btnCheckinNow;

	}

	public static WebElement btnNoToAll(WebDriver driver) {
		WebElement btnNoToAll = driver.findElement(By.xpath("//button[text()='No to all']"));
		return btnNoToAll;

	}

	public static WebElement btnContinueCheckin2(WebDriver driver) {
		WebElement btnContinueCheckin2 = driver.findElement(By.xpath("//*[contains(text(),'Continue check-in')]"));
		return btnContinueCheckin2;

	}

	public static WebElement btnIAgree(WebDriver driver) {
		WebElement btnIAgree = driver.findElement(By.xpath("//span[text()='I agree']"));
		return btnIAgree;

	}

	public static WebElement btnRemainCurrentCabin(WebDriver driver) {
		WebElement btnRemainCurrentCabin = driver.findElement(By.xpath("//button[text()='Remain in current cabin']"));
		return btnRemainCurrentCabin;

	}

	public static WebElement btnContinue(WebDriver driver) {
		WebElement btnContinue = driver.findElement(By.xpath("//span[text()='Continue']"));
		return btnContinue;

	}

	public static WebElement btnContinue2(WebDriver driver) {
		WebElement btnContinue2 = driver.findElement(By.xpath("//span[text()='Continue']"));
		return btnContinue2;

	}

	public static WebElement btnContinue3(WebDriver driver) {
		WebElement btnContinue3 = driver.findElement(By.xpath("//span[text()='Continue']"));
		return btnContinue3;

	}

	public static WebElement chkEmail(WebDriver driver) {
		WebElement chkEmail = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-3\"]"));
		return chkEmail;

	}
	public static WebElement chkEmail1(WebDriver driver) {
		WebElement chkEmail = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1-input\"]"));
		return chkEmail;

	}
	

	public static WebElement chkMobile(WebDriver driver) {
		WebElement chkMobile = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-4\"]"));
		return chkMobile;

	}
	public static WebElement chkMobile1(WebDriver driver) {
		WebElement chkMobile = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-2\"]"));
		return chkMobile;

	}

	public static WebElement inpEmail(WebDriver driver) {
		WebElement inpEmail = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
		return inpEmail;

	}

	public static WebElement inpMobile(WebDriver driver) {
		WebElement inpMobile = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
		return inpMobile;

	}

	public static WebElement inpCountryCode(WebDriver driver) {
		WebElement inpCountryCode = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
		return inpCountryCode;

	}

	public static WebElement btnCopy(WebDriver driver) {
		WebElement btnCopy = driver.findElement(By.xpath("//button[contains(text(),'Copy to all passengers')]"));
		return btnCopy;

	}

	public static WebElement btnContinue4(WebDriver driver) {
		WebElement btnContinue4 = driver.findElement(By.xpath("//span[text()='Continue']"));
		return btnContinue4;

	}
	public static WebElement btnContinueWithoutCheckedBags(WebDriver driver) {
		WebElement btnContinueWithoutCheckedBags = driver.findElement(By.xpath("//span[text()='Continue without checked bags']"));
		return btnContinueWithoutCheckedBags;

	}
	public static WebElement drpDeliveryMethod(WebDriver driver) {
		WebElement drpDeliveryMethod = driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]"));
		return drpDeliveryMethod;

	}
	public static WebElement selectSMS(WebDriver driver) {
		WebElement selectSMS = driver.findElement(By.xpath("//span[text()='SMS text']"));
		return selectSMS;

	}
	public static WebElement btnContinueLast(WebDriver driver) {
		WebElement btnContinueLast = driver.findElement(By.xpath("//span[text()='Continue']"));
		return btnContinueLast;

	}
	public static WebElement msgCheckedin(WebDriver driver) {
		WebElement msgCheckedin = driver.findElement(By.xpath("//span[text()='You are checked-in']"));
		return msgCheckedin;

	}
	//span[text()='You are checked-in']
	
	
	//*[@id="mat-select-0"]
	//span[text()='Continue without checked bags']

	// public static final String USERNAME = "chandra.sakthtivel";
//	public static final String PASSWORD = "amadeus12";

	
	
}
