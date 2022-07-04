package testNGPackage3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGCustomer { 
	// declaration of the webDriver
	WebDriver driver;
	String browser="chrome";
	String url="http://www.techfios.com/billing/?ng=admin/";

	// Element List
	By USER_NAME_FIELD = By.id("username");
	By PASSWORD_FIELD = By.id("password");
	By SIGNIN_BUTTON_FIELD = By.name("login");
	By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\\\"page-wrapper\\\"]/div[2]/div/h2");
	
	By CUSTOMER_MENU_LOCATOR = By.xpath("//span[normalize-space()='Customers']");
	
	By ADD_CUSTOMER_MENU_LOCATOR = By.xpath("//a[normalize-space()='Add Customer']");
	
	By ADD_CONTACT_HEADER_LOCATOR = By.xpath("//h5[normalize-space()='Add Contact']");
	
	
	By FULL_NAME_LOCATOR = By.xpath("//input[@id='account']");
	By COMPANY_DROPDOWN_LOCATOR = By.xpath("//*[@id=\'cid\']");
	By EMAIL_LOCATOR = By.xpath("//input[@id='email']");
	By PHONE_LOCATOR =By.xpath("//input[@id='phone']");
	By ADDRESS_LOCATOR = By.name("address");
	By CITY_LOCATOR = By.name("city");
	By STATE_LOCATOR = By.name("state");
	By ZIP_LOCATOR = By.id("zip");
	By COUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id=\"country\"]");
	By SIGNIN_BUTTON = By.name("login");
	 By GROUP_DROPDOWN_FIELD = By.xpath("//*[@id=\'group\']");
	 By CURRENCYY_DROPDOWN_FIELD = By.xpath("//SELECT[@ID='currency']");
	 
	// Test Data
			String userName = "demo@techfios.com";
			String password = "abc123";
			String fullname = "Sidy Camus";
			String company = "Techfios";
			String email = "s3c@techfios.com";
			String phone = "214214568900";
			String address = "6542 adress of public rd";
			String city = "Dallas";
			String state = "state";
			String zip = "75265";
			String country = "United States";
			String currency = "USD";
			
			
			
			
			//@BeforeSuite
			public void readConfig() {
				
			// FileReader //Scanner //InputStream //BufferedReader
			
					try{
						InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
						Properties prop = new Properties();
						prop.load(input);
						browser = prop.getProperty("browser");
						System.out.println("Browser used: " + browser);
						url = prop.getProperty("url");
						
					}catch(IOException e) {
						e.getStackTrace();
					}
					
				}			
	
			@BeforeMethod
			public void init() {
				
				if(browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
					driver = new ChromeDriver();
				}else if(browser.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}

				
				driver.manage().deleteAllCookies();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}
			
			//@Test
			public void myLogin() {
		   	System.out.println("test method");
			// identify user name element & data insertion
			driver.findElement(USER_NAME_FIELD).sendKeys(userName);
			// identify password element & data insertion
			driver.findElement(PASSWORD_FIELD).sendKeys(password);
			// identify sign in element & click
			driver.findElement(SIGNIN_BUTTON).click();
			//assertion
			System.out.println("This is the account opening part");
			// clicking on Bank & Cash
			driver.findElement(By.partialLinkText("Bank & Cash")).click();
			driver.findElement(By.partialLinkText("New Account")).click();
			//Thread.sleep(5000);
			//file upload
			//identify the elemnt, use sendkeys as long as it is tag input
			//driver.findElement("")).sendkeys;
			//any other ytage you will have to use robot class
			
			// filing out the new account information
			System.out.println("This is ti fill out the account information");
			driver.findElement(By.id("account")).sendKeys("Saving Account");
			driver.findElement(By.id("description")).sendKeys("I am keeeping my saving here");
			driver.findElement(By.id("balance")).sendKeys("$129,000");
			driver.findElement(By.id("account_number")).sendKeys("214723387300");
			driver.findElement(By.id("contact_person")).sendKeys("Bintu C");
			driver.findElement(By.id("ib_url")).sendKeys("www.techfios.com/billing/?ng=admin/");
			//Thread.sleep(3200);
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		    //driver.findElement(By.partialLinkText("alert alert-success fade in"));
			//WebElement expected= driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]"));
			//String actualUrl="";
	        
				
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
			driver.findElement(By.partialLinkText("Dashboard")).click();
		    //driver.findElement(By.xpath("//div[@id='page-wrapper']//input[@id='account']")).sendKeys("Sidy");	
			
			
			driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			driver.findElement(By.linkText("Add Customer")).click();
			
			
			
			
			
			
			
			
			
			
			
			driver.findElement(FULL_NAME_LOCATOR).sendKeys(fullname);
			
			//driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
			
			//driver.finElement(By.name());					
			
			//.....Assert.assertTrue("Wrong Page!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
			
//			Assert.assertEquals("Dashboard page not found!!", "Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
//			System.out.println(driver.findElement(DASHBOARD_HEADER_FIELD).getText());
			
			//Assert.assertEquals("Dashboard page not found!!", "Dashboard- iBilling", driver.getTitle());
//			System.out.println(driver.getTitle());
			
			//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
			
			//By COUNTRY_DROPDOWN_FIELD = By.xpath("//*[@id=\"cid\"]");
			
			Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_LOCATOR));
			sel.selectByVisibleText("Apple");
			
			//homework
			sel.getOptions();
			driver.findElement(EMAIL_LOCATOR).sendKeys(email);
			driver.findElement(PHONE_LOCATOR).sendKeys(phone);
			driver.findElement(ADDRESS_LOCATOR).sendKeys(address);
			driver.findElement(CITY_LOCATOR).sendKeys(city);
			driver.findElement(STATE_LOCATOR).sendKeys(state);
			driver.findElement(ZIP_LOCATOR).sendKeys(zip);
			      //Drop Down to handle list of countries	    
			Select sel2 = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
			sel2.selectByVisibleText("Guinea");
			//driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']")).sendKeys("QA training");
			driver.findElement(By.id("submit")).click();
			
			//Drop Down to handle list of currencies
			Select sel3 = new Select(driver.findElement(CURRENCYY_DROPDOWN_FIELD));
				sel3.selectByVisibleText("USD");
				//Drop Down to handle list of countries
				// By GROUP_DROPDOWN_FIELD = By.xpath("//*[@id=\'group\']");
					Select sel4 = new Select(driver.findElement(GROUP_DROPDOWN_FIELD));
					sel4.selectByVisibleText("SQL");
					//driver.findElement(By.xpath("//*[@id=\\'submit\\']\"")).click();
					
					
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
					driver.findElement(By.partialLinkText("Dashboard")).click();
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
					driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
					driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")).click();
			        
			        
			        driver.findElement(By.xpath("//input[@id='foo_filter']")).sendKeys("2140002010");
			
			        driver.findElement(By.xpath("//input[@id='foo_filter']")).sendKeys("2140002010");
					
					
					
					
			}
			   @AfterMethod
				public void tearDown() {
					driver.close();
					driver.quit();
				}
		
			
			
}