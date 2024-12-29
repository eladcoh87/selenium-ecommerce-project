package pkg1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



public class TestBuckleRegistration {

	static WebDriver driver;
	static WebDriverWait wait;
	
	static String firstName = "jonjon54";
	static String lastName = "bili";
	static String email = "bil45544d@gmail.com";
	static String password = "B53@lofvA4V343";
	static String phoneNumber = "97240368906";
	
	
	
	static String emailForBadPassword = "sdfsdf124Abb@walla.com";
	static String passForBadPassword = "123a";

	@BeforeTest
	public static void initMyTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		wait = new WebDriverWait(driver, Duration.ofMillis(5000)); // 5 seconds timeout
	}
	
	 @Test(priority = 1)
	public static void testCaseRegistration() throws InterruptedException {
		driver.get("https://www.buckle.com/");
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button > span.icon.icon-profile")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#createAccountButton")));
		driver.findElement(By.cssSelector("#createAccountButton")).click();
		
		
		String actualURL = driver.getCurrentUrl(); 
		Assert.assertTrue("https://www.buckle.com/register?successUrl=/".equalsIgnoreCase(actualURL), "URL doesn't match");
		driver.findElement(By.cssSelector("#cfirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#clastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#cemailAddress")).sendKeys(email);
		
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#phoneNumber")).sendKeys(phoneNumber);
		
		
		Select dropDown = new Select(driver.findElement(By.id("gender")));
		
		dropDown.selectByVisibleText("Male");
		

		driver.findElement(By.cssSelector("#loyaltyEnroll")).click();
		driver.findElement(By.cssSelector("#registration-submit")).click();
		Thread.sleep(3000);
		String afterRegUrl = driver.getCurrentUrl();
		System.out.println(afterRegUrl);
		Assert.assertTrue("https://www.buckle.com/".equalsIgnoreCase(afterRegUrl), "reg did not succed");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button")));
		
		
		
		
		
			driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#account-menu-welcome > span")));
		
				driver.findElement(By.cssSelector("#account-menu > div > div > a")).click();
//			
//		driver.get("https://www.buckle.com/");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button > span.icon-text.d-sm-none.d-lg-inline.ms-1")));
//		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button > span.icon-text.d-sm-none.d-lg-inline.ms-1")).click();
//		
//		System.out.println("befor login");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-username")));
//
//		driver.findElement(By.cssSelector("#login-username")).sendKeys(email);
//		driver.findElement(By.cssSelector("#login-password")).sendKeys(password);
//		driver.findElement(By.cssSelector("#login-button")).click();
//		
//		
//		 Thread.sleep(5000);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button")));
//
//		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button")).click();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#account-menu-welcome > span")));
//
//		String actualString = driver.findElement(By.cssSelector("#account-menu-welcome > span")).getText();
//		assertTrue(actualString.contains(firstName));
//		driver.findElement(By.cssSelector("#account-menu > div > div > a")).click();
//		

		
	
		
		
	
	}
	
	 
	 @Test(priority = 2)
	 public void testCaseBadPassword() throws InterruptedException {
		 
			driver.get("https://www.buckle.com/");
			driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(2) > button > span.icon.icon-profile")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#createAccountButton")));
			driver.findElement(By.cssSelector("#createAccountButton")).click();
			
			String actualURL = driver.getCurrentUrl();
			Assert.assertTrue("https://www.buckle.com/register?successUrl=/".equalsIgnoreCase(actualURL), "URL doesn't match");
			
			driver.findElement(By.cssSelector("#cfirstName")).sendKeys(firstName);
			driver.findElement(By.cssSelector("#clastName")).sendKeys(lastName);
			driver.findElement(By.cssSelector("#cemailAddress")).sendKeys(emailForBadPassword);
			
			driver.findElement(By.cssSelector("#password")).sendKeys(passForBadPassword);
			driver.findElement(By.cssSelector("#phoneNumber")).sendKeys(phoneNumber);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password-error")));

			String passErrorMsg = driver.findElement(By.cssSelector("#password-error > span.error-field-message")).getText();  
			String passErrorMsgShouldBe = "Password must be 8 to 32 characters with numbers, letters, or !@#$%^&*";

			Assert.assertTrue(passErrorMsgShouldBe.equalsIgnoreCase(passErrorMsg), "pass error message not the message its should be");

			Select dropDown = new Select(driver.findElement(By.id("gender")));
			
			dropDown.selectByVisibleText("Male");
			

			driver.findElement(By.cssSelector("#loyaltyEnroll")).click();
			driver.findElement(By.cssSelector("#registration-submit")).click();
			
			Assert.assertTrue("https://www.buckle.com/register?successUrl=/".equalsIgnoreCase(actualURL), "URL doesn't match");
			
			
			
	 }
	 
	
	
	

	@AfterTest
	public static void endTest() throws InterruptedException {
		
        Thread.sleep(5000);
      driver.quit();
    }
	
	

	
	
	
}