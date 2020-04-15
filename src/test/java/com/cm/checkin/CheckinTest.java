package com.cm.checkin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckinTest extends BaseTest {
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
		//sfinal String COUNTRYCODE = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Countrycode");
		//sfinal String MOBILE = ReadExcelDataUtility.ReadExcelData("Sheet1", TESTCASENAME, "Mobile");

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
		Type(inpFirstname(driver),FIRSTNAME);
		Type(inpLastname(driver),LASTNAME);
		Type(inpDeparture(driver),DEPARTURE);
		RobotEnter();
		Type(inpPnr(driver), PNR);
		Click(btnCheckIn(driver));
		ShortWait();
		driver.switchTo().frame("ssci-iframe");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnContinueCheckin(driver));
		Click(btnContinueCheckin(driver));
		Click(btnCheckinNow(driver));
		VShortWait();
		Click(btnNoToAll(driver));
		Click(btnContinueCheckin2(driver));
		VShortWait();
		Click(btnIAgree(driver));
		Click(btnRemainCurrentCabin(driver));
		Click(btnContinue(driver));
		ShortWait();
		Click(btnContinue2(driver));
		Click(btnContinue3(driver));
		Click(chkEmail(driver));
		Click(chkMobile(driver));
		Type(inpEmail(driver),EMAIL);
		Type(inpCountryCode(driver), "India (+91)");
		Type(inpMobile(driver), "1234567890");
		Click(btnCopy(driver));
		Click(btnContinue4(driver));

	}
}
