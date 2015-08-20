package personal.gitexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MainPage {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	@Test
	public void testManagerid()
	{
		driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lpage=PageFactory.initElements(driver,LoginPage.class);
		hpage=lpage.login("mngr17242", "Dell@123");
		String mId=hpage.getManagerId();
		System.out.println(mId);
		lpage=hpage.logOut();
		
	}
	@AfterTest
	public void Closesession()
	{
		driver.close();
		driver.quit();
	}
	

}
