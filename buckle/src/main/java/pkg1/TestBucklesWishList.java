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


public class TestBucklesWishList extends MyMain {
	
	static WebDriver driver;
	static WebDriverWait wait;
	

	
	@BeforeTest
	public static void initMyTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		wait = new WebDriverWait(driver, Duration.ofMillis(5000)); // 5 seconds timeout
		
		
	}
	
	
	
	@Test(priority = 1)
	public static void testCaseAtc() throws InterruptedException {
		
		driver.get("https://www.buckle.com/");
		
		
		driver.findElement(By.cssSelector("#menu-Men")).click();
		
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.flex-fill > div > div > div.dropdown.nav-item.show.dropdown > div > div > div:nth-child(1) > div > div.nav-menu.px-5.py-4 > div > div > div > div:nth-child(1) > div.d-flex.flex-row.submenu-links > div:nth-child(1) > a:nth-child(2)")).click();

		
		
		driver.findElement(By.cssSelector("#\\31 6674BBLA9104 > div > div.product-badge-div > a > span.product-brand")).click();

		driver.findElement(By.cssSelector("#center-content > div.info-container > div.info > form > div > div.product-options.mb-2 > fieldset.size-info > div.size-options-container > button:nth-child(2)")).click();
		
		
		driver.findElement(By.cssSelector("#center-content > div.info-container > div.info > form > div > div.product-options.mb-2 > fieldset.dimension-info > div.dimension-options-container > button:nth-child(2)")).click();
		
		

		
		String productName = driver.findElement(By.cssSelector("#product-name-id")).getText();

		driver.findElement(By.cssSelector("#center-content > div.main-product-image > div.pdp-image-container > div > div > div > button > i")).click();

		
		driver.findElement(By.cssSelector("#header > nav > div > div.menu-bar > div > div.d-flex.flex-row.align-items-center > div:nth-child(3) > a > span.icon.icon-favorite")).click();
		
		
		
	

			
			String actualURL = driver.getCurrentUrl();
			Assert.assertTrue("https://www.buckle.com/favorites".equalsIgnoreCase(actualURL), "URL doesn't match");
			
			Thread.sleep(3000);
			
			
		
			
			
			driver.findElement(By.cssSelector("#favorites-container > div > div.products.favorited-products > div.row > div.product-wrap.px-2.col-md-3.col-sm-4.col-6")).click();

			
			
			String productNameWishList = driver.findElement(By.cssSelector("#product-name-id")).getText();

			
		
			
			Assert.assertTrue(productNameWishList.equalsIgnoreCase(productName), "not same pruduct");

	}
	
	

	
	
	
	
	
	
	@AfterTest
	public static void endTest() throws InterruptedException {
        Thread.sleep(5000);
      driver.quit();
    }

}
