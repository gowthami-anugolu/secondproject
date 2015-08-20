package personal.gitexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	@FindBy(name="uid")
	private WebElement UserName;
	@FindBy(name="password")
	private WebElement Password;
	@FindBy(name="btnLogin")
	private WebElement ClickLogin;
	
	private void setuname(String uname)
	{
		UserName.sendKeys("mngr17242");
	}
	private void setpassword(String pw)
	{
		Password.sendKeys("Dell@123");
	}
	private void clickbtn()
	{
		ClickLogin.click();
		
	}
	public HomePage login(String uname,String pw)
	{
	this.setuname(uname);
	this.setpassword(pw);
	this.clickbtn();
	return PageFactory.initElements(driver,HomePage.class);
	}
}
