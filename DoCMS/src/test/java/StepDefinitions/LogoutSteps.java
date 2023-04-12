package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
		
		WebDriver driverOut = null;
		
		public void browser_is_open() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dimas\\eclipse-workspace\\DoCMSAutomationTesting\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driverOut = new ChromeDriver(options);
			
			driverOut.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driverOut.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driverOut.manage().window().maximize(); // menampilkan jendela browser full screen
		}
		
		
		public void user_is_on_login_page() {
			
			driverOut.navigate().to("http://103.172.204.236:8080/login/");
		
		}
		
	//	@When("user enters username and password")
	//	public void user_enters_username_and_password() {
	//		
	//		driver.findElement(By.name("username")).sendKeys("emil");
	//		driver.findElement(By.name("password")).sendKeys("anything");
	//		
	//	}
		
		public void user_enters_username_and_password(String username, String password) {
			if(username.equals("<blank>")){
				username = "";
			} 
			if(password.equals("<blank>")){
				password = "";
			} 
			driverOut.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys(username);
			driverOut.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys(password);
	
		}
	
		public void user_clicks_on_login_button() {
			
			driverOut.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
		
		}
		
		
		public void user_is_navigated_to_the_home_page() {
			
			driverOut.findElement(By.xpath("//*[@id=\"v-step-metadata-4\"]")).isDisplayed();
	//	driver.close();
	//	driver.quit();
		}
		
		@Given("browser is on metadata page")
		public void browser_is_on_metadata_page() {
			this.browser_is_open();
			this.user_is_on_login_page();
			this.user_enters_username_and_password("dimaswisnu", "dimaswisnu");
			this.user_clicks_on_login_button();
			this.user_is_navigated_to_the_home_page();
		}
			
		@When("user clicks on logout button")
		public void user_clicks_on_logout_button() {
			
			driverOut.findElement(By.xpath("//*[@id=\"v-step-5\"]")).click();
		
		}
		
		@Then ("user is navigated to the login page")
		public void user_is_navigated_to_the_login_page() {
			
			driverOut.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/div/div[1]")).isDisplayed();
//		driver.close();
//		driver.quit();
		}
		
}