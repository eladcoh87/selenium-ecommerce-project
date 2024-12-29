package pkg1;


import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class TestBucklesLogin extends MyMain {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	static String firstName = "dav3434";
	static String email = "dfd3434529999123@gmail.com";
	static String password = "B53@lofvA4V343";
	static String phoneNumber = "97240368906";
	
	@BeforeTest
	public static void initMyTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		wait = new WebDriverWait(driver, Duration.ofMillis(5000)); // 5 seconds timeout
		
		
	}
	
	
	
	@Test(priority = 1)
	public static void testCaseLogin() throws InterruptedException {
		
		driver.get("https://www.buckle.com/");
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button > span.icon.icon-profile")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-button")));
		
		driver.findElement(By.cssSelector("#login-username")).sendKeys(email);
		driver.findElement(By.cssSelector("#login-password")).sendKeys(password);
		
		driver.findElement(By.cssSelector("#login-button")).click();
		
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button")).click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#account-menu-welcome > span")));
		String actualString = driver.findElement(By.cssSelector("#account-menu-welcome > span")).getText();
		assertTrue(actualString.contains(firstName));
		
		

		driver.findElement(By.cssSelector("#account-menu > div > div > a")).click();
		
		
		
	}
	
	
	
	
	@Test(priority = 2)
	public static void testCaseBadEmail() throws InterruptedException {
		
		driver.get("https://www.buckle.com/");
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button > span.icon.icon-profile")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-button")));
		
		driver.findElement(By.cssSelector("#login-username")).sendKeys("blakfj35111km@gmail.com");
		driver.findElement(By.cssSelector("#login-password")).sendKeys(password);
		
		driver.findElement(By.cssSelector("#login-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-form > div.fade.alert.alert-danger.show > p")));

		String badEmailErrorMsg =	driver.findElement(By.cssSelector("#login-form > div.fade.alert.alert-danger.show > p")).getText();
		String badEmailErrorMsgShouldBe = "Your credentials were invalid. Please try again.";

		
		Assert.assertTrue(badEmailErrorMsg.equalsIgnoreCase(badEmailErrorMsgShouldBe), "wrong error msg - test failed");

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public static void endTest() throws InterruptedException {
		System.out.println("after test function");
        Thread.sleep(5000);
      driver.quit();
    }

}
