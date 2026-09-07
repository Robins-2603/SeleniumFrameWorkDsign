package rahulshettyAcademy.SeleniumFrameWorkDsign;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// we will start writing the selenium code here afterwards we will convert it into framework standards.

public class Standalone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//Logging in to website
		
		driver.findElement(By.id("userEmail")).sendKeys("robinsforwork@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Robin$2603");
		driver.findElement(By.cssSelector("#login")).click();
		
		// Grabbing all the items 
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//find "ZARA COAT 3" from list and add it into cart
		List<WebElement> zara = products.stream().filter(s->s.getText().contains("ZARA")).collect(Collectors.toList());
		
		zara.stream().forEach(s->System.out.println(s.getText()));
		
		zara.stream().forEach(s->s.findElement(By.xpath(".//button[@class = 'btn w-10 rounded']")).click());

		/*
		WebElement zara = products.stream().filter(s->s.findElement(By.xpath("//b[contains(text(),'ZARA')]")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
		
		System.out.println(zara.getText());
		*/
		
		// checking the toast container and animation after clicking on "Add to cart"
		//using explicit wait to check this toast container
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//verifying the Item in Cart
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
	}

}
