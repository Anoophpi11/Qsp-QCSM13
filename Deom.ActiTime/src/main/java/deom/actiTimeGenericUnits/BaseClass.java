package deom.actiTimeGenericUnits;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import demo.actiTimePOM.HomePage;
import demo.actiTimePOM.LoginPage;

public class BaseClass {
	
	WebDriver driver=null;
	PropertyUtils utils =new PropertyUtils();
	
	
	@BeforeSuite
	public void ConfigBfs()
	{
		//used for data base connection
	}
	
	@BeforeTest
	public void ConfigBt()
	{
		//used for parallelexecution
	}
	@BeforeClass
	public void ConfigBc()
	{
		
		String browzerName = utils.getPropertyData("PORPFILEPATH", "Browzer");
		System.out.println(browzerName);
		String url = utils.getPropertyData(".PORPFILEPATH", "url");
		
		if(browzerName.equals("chrome"))
		{
		System.setProperty("CHROMEKEY","CHROMEPATH");
		    driver=new ChromeDriver(); 
		}
		
		else if(browzerName.equals("firefox"))
		{
			System.setProperty("FIREFOXKEY","FIREFOXPATH");
			 driver=new FirefoxDriver(); 
		}
		else
		{
			throw new SessionNotCreatedException("browzer is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	
	}
	@BeforeMethod
     public void cofigBm()
     {
		String username = utils.getPropertyData("PORPFILEPATH", "username");
		String passoword =utils.getPropertyData("PORPFILEPATH", "passowrd");

		LoginPage loginpage=new LoginPage(driver); 
		loginpage.login(username, passoword);
     }
	
	@AfterMethod
	public void cofigAm()
	{
		HomePage logout=new HomePage(driver);
		logout.logout();
	}
	
	@AfterClass
	public void ConfigAc()
	{
		//close the browzer
		driver.quit();
	}
	
	@AfterTest
	public void ConfigAt()
	{
		//closing all the parallel connection 
	}
	
	@AfterSuite
	public void ConfigAs()
	{
		//closing DataBase connection
	}

}




























