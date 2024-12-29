package pkg1;


import static org.testng.Assert.assertTrue;

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


public class TestBucklesAtc extends MyMain {
	
	static WebDriver driver;
	static WebDriverWait wait;
	

	
	@BeforeTest
	public static void initMyTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		wait = new WebDriverWait(driver, Duration.ofMillis(5000)); // 5 seconds timeout
		
		
	}
	
	
	
	
	public static void testCaseAtc() throws InterruptedException {
		
		driver.get("https://www.buckle.com/");
		
		
		driver.findElement(By.cssSelector("#menu-Men")).click();
		
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.flex-fill > div > div > div.dropdown.nav-item.show.dropdown > div > div > div:nth-child(1) > div > div.nav-menu.px-5.py-4 > div > div > div > div:nth-child(1) > div.d-flex.flex-row.submenu-links > div:nth-child(1) > a:nth-child(2)")).click();

		
		
		driver.findElement(By.cssSelector("#\\31 6674BBLA9104 > div > div.product-badge-div > a > span.product-brand")).click();

		driver.findElement(By.cssSelector("#center-content > div.info-container > div.info > form > div > div.product-options.mb-2 > fieldset.size-info > div.size-options-container > button:nth-child(2)")).click();
		
		
		driver.findElement(By.cssSelector("#center-content > div.info-container > div.info > form > div > div.product-options.mb-2 > fieldset.dimension-info > div.dimension-options-container > button:nth-child(2)")).click();

		driver.findElement(By.cssSelector("#add-to-bag-button")).click();
		 Thread.sleep(3000);
		driver.findElement(By.cssSelector("#miniCartViewBag")).click();
		
		
	
			
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue("https://www.buckle.com/cart".equalsIgnoreCase(actualURL), "URL doesn't match");
		
		
		
		driver.findElement(By.cssSelector("#checkout-btn")).click();
		
		driver.findElement(By.cssSelector("#checkout-as-guest-submit")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#emailAddress")));
		driver.findElement(By.cssSelector("#emailAddress")).sendKeys("israel2342@gmail.com");
		
		
		driver.findElement(By.cssSelector("#fullName")).sendKeys("israel israeli");
		
		driver.findElement(By.cssSelector("#addressLine1")).sendKeys("1514 Scott Street");
		driver.findElement(By.cssSelector("#city")).sendKeys("West Nyack");
		
		Select dropDown = new Select(driver.findElement(By.id("stateProvinceRegion")));
		
		dropDown.selectByVisibleText("NY");
		driver.findElement(By.cssSelector("#postalCode")).sendKeys("10994");
		
		driver.findElement(By.cssSelector("#phoneNumber")).sendKeys("9725023344");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#checkout-shipping-to-guest-address-submit-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#CheckoutGuestShippingAddressForm > div:nth-child(1) > div:nth-child(7) > div > div > div > div.alert-section.alert-action > button")));

		driver.findElement(By.cssSelector("#CheckoutGuestShippingAddressForm > div:nth-child(1) > div:nth-child(7) > div > div > div > div.alert-section.alert-action > button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-shipping-to-guest-submit")));

		driver.findElement(By.cssSelector("#checkout-shipping-to-guest-submit")).click();

		
		
		
		
		String actualURLChk = driver.getCurrentUrl();
		Assert.assertTrue("https://www.buckle.com/checkout".equalsIgnoreCase(actualURLChk), "URL doesn't match");
		
		
		
	
	}
	
	
	@Test(priority = 2)
	public static void testCaseBadAtc() throws InterruptedException {
		
		driver.get("https://www.buckle.com/");
		
		
		driver.findElement(By.cssSelector("#menu-Men")).click();
		
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.flex-fill > div > div > div.dropdown.nav-item.show.dropdown > div > div > div:nth-child(1) > div > div.nav-menu.px-5.py-4 > div > div > div > div:nth-child(1) > div.d-flex.flex-row.submenu-links > div:nth-child(1) > a:nth-child(2)")).click();

		
		
		driver.findElement(By.cssSelector("#\\31 6674BBLA9104 > div > div.product-badge-div > a > span.product-brand")).click();

		driver.findElement(By.cssSelector("#center-content > div.info-container > div.info > form > div > div.product-options.mb-2 > fieldset.size-info > div.size-options-container > button:nth-child(2)")).click();
		


		driver.findElement(By.cssSelector("#add-to-bag-button")).click();
		 
		
		
		
		String lengthErrorMsg = driver.findElement(By.cssSelector("#dimension-error > span.text-danger")).getText();  
		String lengthErrorMsgShouldBe = "Select a valid length";
		
		Assert.assertTrue(lengthErrorMsgShouldBe.equalsIgnoreCase(lengthErrorMsg), "length message not the message its should be");
	
	}
	
	
	
	
	
	
	
	@AfterTest
	public static void endTest() throws InterruptedException {
        Thread.sleep(5000);
      driver.quit();
    }

}
