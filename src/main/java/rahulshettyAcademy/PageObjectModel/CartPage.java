package rahulshettyAcademy.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.implementation.bind.annotation.Super;
import rahulshettyAcademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	
	
//	List<WebElement> cartItem =  driver.findElements(By.cssSelector("div[class = 'cartSection'] h3"));
	
	@FindBy(css = "div[class = 'cartSection'] h3")
	List<WebElement> cartItem;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton ;
	
	
	
	
	
	public boolean findDesiredProduct(String name) {
		boolean item =  cartItem.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
		return item;
	}
	
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	// creating method for click action on checkout button
	public void clickCheckoutButton() {
		
		checkoutButton.click();
	}
	
	
}
