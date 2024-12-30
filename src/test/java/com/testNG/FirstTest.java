package com.testNG;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTest {

	@Test
	public void TestGoogle() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "E://chromedriver-win32//chromedriver.exe/");
		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR Totorial", Keys.ENTER);
		String expectedTitle = "HYR Totorial - Google Search";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		Thread.sleep(5000);
		System.out.println(actualTitle);
		driver.quit();

	}

	@Test
	public void TestFaceBook() throws Exception {
		// System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "E://chromedriver-win32//chromedriver.exe/");
		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("HYR Totorial", Keys.ENTER);
		Thread.sleep(5000);

		SoftAssert softAssert=new SoftAssert();
		// Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to FaceBook";
		softAssert.assertEquals(actualTitle, expectedTitle, "Title Mismatched");

		// URL Assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		softAssert.assertNotEquals(actualUrl, expectedUrl, "Url Mismatched");

		// Text Assertion
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "";
		softAssert.assertEquals(actualText, expectedText, "Text Mismatched");

		// Border Assertion
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(240 40 73)";
		softAssert.assertEquals(actualBorder, expectedBorder, "border color mismatched");
//		driver.quit();

		// ErroMessage Assertion
		String actualErroMessage = driver.findElement(By.xpath("//div[@id='email_container']/div[2]"))
				.getText();
		String expectedErroMessage = "The email address or mobile number you entered isn't connected to an account. ";
		softAssert.assertEquals(actualErroMessage, expectedErroMessage, "ErroMessage mismatched");
		driver.quit();
		
		softAssert.assertAll();

	}

}
