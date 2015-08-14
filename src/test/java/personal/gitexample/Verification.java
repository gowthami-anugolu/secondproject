package personal.gitexample;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Verification {

	
	WebDriver driver;
	
	@BeforeTest
	public void initiateBrowser(){
		
		driver = new FirefoxDriver();
		driver.get("https://www.paytm.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testVerifications(){
		
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		boolean isPresent = driver.findElement(By.xpath("//a[@class='fr btn btn-primary sell-on-paytm']")).isDisplayed();
	
		SoftAssert sa = new SoftAssert();
//		Assert.assertTrue(title.contains("paytm"), " No Pay tm in the title");
		sa.assertTrue(title.contains("Paytm"), " No Pay tm in the title");
		System.out.println("one");
//		Assert.assertTrue(url.contains(".com"), " No .COM in the url");
		sa.assertTrue(url.contains(".com"), " No .COM in the url");
		System.out.println("two");
//		Assert.assertTrue(isPresent, " Become seller is not present");
		sa.assertTrue(isPresent, " Become seller is not present");
		
		System.out.println("END");
		sa.assertAll();
	}
	
	@AfterTest
	public void closeSession(){
		driver.close();
		driver.quit();
	}
}
