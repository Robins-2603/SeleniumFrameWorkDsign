package rahulshettyAcademy.PageObjectModel;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyAcademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		// intializing locators by page factory in constructor because it will get call first
				//Page factory is exclusively for drive.findElement constructions
		PageFactory.initElements(driver, this);
		
	}
	
	
	// Grabbing all the items 
			//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy (css = ".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	//Creating Action method 
	public List<WebElement> getProductList() {
		
		waitForEllementToAppear(productsBy);
		return products;
	}
	
	public List<WebElement> getProductByName(String name) {
		
		List<WebElement> zara = products.stream().filter(s->s.getText().contains(name)).collect(Collectors.toList());
		return zara;
	}
	
	By addToCartBy = By.xpath(".//button[@class = 'btn w-10 rounded']");
	By toast = By.cssSelector("#toast-container");
	
	public void addProductToCart(String name) {
		List<WebElement> zara = getProductByName(name);
		zara.stream().forEach(s->s.findElement(addToCartBy).click());
		
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		waitForEllementToAppear(toast);
	}
	

}
