package com.cm.checkin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckinTest1 extends BaseTest {
	public static void main(String[] args) throws Exception {

		// test data
		final String TESTCASENAME = "abc";
		final String APP_URL = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Url");
		final String USERNAME = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Username");
		final String PASSWORD = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Password");
		final String PNR = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Pnr");
		final String FIRSTNAME = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Firstname");
		final String LASTNAME = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Lastname");
		final String DEPARTURE = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Departure");
		final String EMAIL = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Email");
		// final String COUNTRYCODE = ReadExcelDataUtility.ReadExcelData("Sheet1",
		// TESTCASENAME, "Countrycode");
		// final String MOBILE = ReadExcelDataUtility.ReadExcelData("Sheet1",
		// TESTCASENAME, "Mobile");

		// check in
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(APP_URL);
		RobotPopup(USERNAME, PASSWORD);
		Click(btnLanguageEnglish(driver));
		LongWait();
		Click(btnCheckInHome(driver));
		Type(inpFirstname(driver), FIRSTNAME);
		Type(inpLastname(driver), LASTNAME);
		Type(inpDeparture(driver), DEPARTURE);
		RobotEnter();
		Type(inpPnr(driver), PNR);
		Click(btnCheckIn(driver));
		ShortWait();
		driver.switchTo().frame("ssci-iframe");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();",
		// btnContinueCheckin(driver));
		// Click(btnContinueCheckin(driver));
		Click(btnCheckinNow(driver));
		VShortWait();
		Click(btnNoToAll(driver));
		Click(btnContinueCheckin2(driver));
		VShortWait();
		Click(btnIAgree(driver));
		
		try
		{
		Click(btnRemainCurrentCabin(driver));
		}
		catch(Exception e) {}
		Click(btnContinue(driver));
		VShortWait();
		// Click(btnContinue2(driver));
		// Click(btnContinue3(driver));

		// code for single 0r  multiple pax
		try {
			try {
				Click(chkEmail1(driver));
				Click(chkMobile1(driver));
				Type(inpEmail(driver), EMAIL);
				Type(inpCountryCode(driver), "India (+91)");
				Type(inpMobile(driver), "1234567890");
			} catch (Exception e) {
				Type(inpEmail(driver), EMAIL);
				Type(inpCountryCode(driver), "India (+91)");
				Type(inpMobile(driver), "1234567890");
			}

		} catch (Exception e) {
			Click(chkEmail(driver));
			Click(chkMobile(driver));
			Type(inpEmail(driver), EMAIL);
			Type(inpCountryCode(driver), "India (+91)");
			Type(inpMobile(driver), "1234567890");
			Click(btnCopy(driver));
		}
		Click(btnContinue4(driver));
		Click(btnContinueWithoutCheckedBags(driver));
		Click(drpDeliveryMethod(driver));
		Click(selectSMS(driver));
		Click(btnContinueLast(driver));
		String Actual = msgCheckedin(driver).getText();
		String Expected = "You are checked-in";
		Assert.assertEquals(Expected, Actual);
		System.out.println("Successfully Checked-in");
		driver.quit();
	}
}
