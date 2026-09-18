package rahulshettyAcademy.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAcademy.AbstractComponents.AbstractComponents;

public class Landingpage extends AbstractComponents {
	
	
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		
		// intializing locators by page factory in constructor because it will get call first
		//Page factory is exclusively for drive.findElement constructions
		PageFactory.initElements(driver, this);    
	}
	
	
	//driver.findElement(By.id("userEmail")).sendKeys("robinsforwork@gmail.com");
	
	@FindBy(id="userEmail")
	WebElement emailElement;
	
	//driver.findElement(By.id("userPassword")).sendKeys("Robin$2603");
	
	@FindBy(id = "userPassword")
	WebElement passwordElement;
	
	//driver.findElement(By.cssSelector("#login")).click();
	
	@FindBy(css="#login")
	WebElement loginButton;
	
	
	// now create methods to call Actions like send key, click , etc
	
	public void enterDetails(String email, String pass)
	{
		emailElement.sendKeys(email);
		passwordElement.sendKeys(pass);
		loginButton.click();
	}
	
	//driver.get("https://rahulshettyacademy.com/client");
	
	public void goTo(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	

}
