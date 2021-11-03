package demo.actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="logoutLink")
	private WebElement logoutButton;
	
	//business logic
	public void logout()
	{
		logoutButton.click();
	}
	

}
