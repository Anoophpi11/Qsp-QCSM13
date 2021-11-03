package demo.actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private WebElement usernameTextFeild;
	
	@FindBy(name="pwd")
	private WebElement passowrdTextFeild;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginbutton;
	
	
	//business logic
	public void login(String username, String passowrd)
	{
		usernameTextFeild.sendKeys("admin");
		passowrdTextFeild.sendKeys("manager");
		loginbutton.click();
		
	}

	
}
