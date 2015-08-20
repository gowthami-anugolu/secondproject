package personal.gitexample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(how = How.XPATH,  using="//table[@align='center']/tbody/tr[3]/td")
	private WebElement manageId;
	
	@CacheLookup
	@FindBy(linkText="Log out")
	private WebElement logout;
	
	public String getManagerId(){
		return manageId.getText();
	}
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public LoginPage logOut(){
		logout.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		return PageFactory.initElements(driver, LoginPage.class);
	}


}
