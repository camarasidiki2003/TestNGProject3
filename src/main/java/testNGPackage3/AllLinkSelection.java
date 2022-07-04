package testNGPackage3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AllLinkSelection extends TestNGCustomer{
	WebDriver driver;
	String browser="chrome";
	String url="http://www.techfios.com/billing/?ng=admin/";

	@Test
	public void LinksSelection() {
		readConfig();
		init();
		//Get list of web-elements with tagName  - a
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 
		 //Traversing through the list and printing its text along with link address
		 for(WebElement link:allLinks){
		 System.out.println(link.getText() + " - " + link.getAttribute("href"));
		 }
		
	}
}
