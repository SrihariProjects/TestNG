package com.testNG;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void InitialiseBrowser(@Optional("chrome")String browserName) {
		switch(browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E://chromedriver-win32//chromedriver.exe/");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			System.setProperty("webdriver.chrome.driver", "E://chromedriver-win32//chromedriver.exe/");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.chrome.driver", "E://chromedriver-win32//chromedriver.exe/");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			break; 
		default:
			System.out.println("Browser name is invalid");
			break;
		}
		
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
	
	@Parameters("url")
	@Test
	public void LaunchApp(String url) throws Exception {
		driver.get(url);
		Thread.sleep(5000);
	}
	
	@Parameters({"username","password"})
	@Test
	public void EnterLoginDetails(String Username, String Password) {
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Parameters("sleep")
	@Test
	public void NavigateToMyInfo(Long sleep) throws Exception {
		Thread.sleep(sleep);
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}
	
	@Test
	public void VerifyMyInfo() throws Exception {
		Thread.sleep(5000);
		boolean actualValue = driver.findElement(By.xpath("//a[text()='Personal Details']")).isDisplayed();
		assertTrue(actualValue);
//		driver.quit();
	}

	@Test
	public void VerifyLogin() {
//		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//img[@alt=\"client brand banner\"]"));
		boolean actualText=element.isDisplayed();
		assertTrue(actualText);
		assertTrue(element.getText().startsWith("Welcome"));
//		System.out.println(element.getText().startsWith("Welcome"));
	}
}
