package rahulshettyAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// This will be the parent class to all page object classes
//because this will be holding all of these reusable stuff
public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartButton;

	public void waitForEllementToAppear(By findBy) {
		
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	
//	driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	
	public void goToCart() {
		
		cartButton.click();
	}

}
