package rahulshettyAcademy.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAcademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement countryDropdown;
	
//	List<WebElement> autoSuggestive = driver.findElements(By.xpath("//section/button"));
	
	@FindBy(xpath = "//section/button")
	List<WebElement> autoSuggestive;
	
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrderButton;
	
	//Action method for send keys("ind")
	
	public void sendKeysToFindCountry(String countryName) {
		
		countryDropdown.sendKeys(countryName);
	}
	
	public void selectDesiredCountryFromList(String desiredCountry) {
		
		autoSuggestive.stream().filter(s->s.getText().equalsIgnoreCase(desiredCountry)).forEach(s->s.click());
	}
	
//	driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	
	public void clickOnPlaceOrderButton() {
		
	    placeOrderButton.click();
	}
	

}
