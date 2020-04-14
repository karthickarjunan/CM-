package com.cm.checkin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckinTest extends BaseTest {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.APP_URL);
		RobotPopup(Constant.USERNAME, Constant.PASSWORD);
		WebElement btnLanguageEnglish = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"enUSEdition\"]")));
		btnLanguageEnglish.click();
		LongWait();
		WebElement btnCheckInHome = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class=\"magnet-icon ac-tab-checkin ac-1x\"]")));
		btnCheckInHome.click();
		WebElement inpFirstname = driver.findElement(By.id("checkin_first_name"));
		WebElement inpLastname = driver.findElement(By.id("checkin_last_name"));
		WebElement inpDeparture = driver.findElement(By.id("checkin_location"));
		WebElement inpPnr = driver.findElement(By.id("checkin_aeroplan_or_pnr"));
		WebElement btnCheckIn = driver.findElement(By.id("checin_submit_button"));
		inpFirstname.sendKeys("AMY");
		inpLastname.sendKeys("AMERICAN");
		inpDeparture.sendKeys("YYZ");
		RobotEnter();
		inpPnr.sendKeys("OT9MKP");
		btnCheckIn.click();
		ShortWait();
		driver.switchTo().frame("ssci-iframe");
		WebElement btnContinueCheckin = (new WebDriverWait(driver, 60)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Continue check-in')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnContinueCheckin);
		btnContinueCheckin.click();
		WebElement btnCheckinNow = driver.findElement(By.xpath("//span[text()='Check in now']"));
		btnCheckinNow.click();
		ShortWait();
		WebElement btnNoToAll = driver.findElement(By.xpath("//button[text()='No to all']"));
		btnNoToAll.click();
		WebElement btnContinueCheckin2 = driver.findElement(By.xpath("//*[contains(text(),'Continue check-in')]"));
		btnContinueCheckin2.click();
		VShortWait();
		WebElement btnIAgree = driver.findElement(By.xpath("//span[text()='I agree']"));
		btnIAgree.click();
		WebElement btnRemainCurrentCabin = driver.findElement(By.xpath("//button[text()='Remain in current cabin']"));
		btnRemainCurrentCabin.click();

		WebElement btnContinue = driver.findElement(By.xpath("//span[text()='Continue']"));
		btnContinue.click();
		ShortWait();
		WebElement btnContinue2 = driver.findElement(By.xpath("//span[text()='Continue']"));
		btnContinue2.click();
		ShortWait();
		WebElement btnContinue3 = driver.findElement(By.xpath("//span[text()='Continue']"));
		btnContinue3.click();
		WebElement chkEmail = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-3\"]"));
		chkEmail.click();
		WebElement chkMobile = driver.findElement(By.xpath("//*[@id=\"mat-checkbox-4\"]"));
		chkMobile.click();
		WebElement inpEmail = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
		WebElement inpMobile = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
		WebElement inpCountryCode = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
		WebElement btnCopy = driver.findElement(By.xpath("//button[contains(text(),'Copy to all passengers')]"));
		inpEmail.clear();
		inpEmail.sendKeys("abc@gmail.com");
		inpCountryCode.clear();
		inpCountryCode.sendKeys("India (+91)");
		inpMobile.clear();
		inpMobile.sendKeys("1234567890");
		btnCopy.click();
		btnContinue3.click();

	}
}
