package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dimas\\eclipse-workspace\\DoCMS\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
	}
	
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		
		driver.navigate().to("http://103.172.204.236:8080/login/");
	
	}
	
//	@When("user enters username and password")
//	public void user_enters_username_and_password() {
//		
//		driver.findElement(By.name("username")).sendKeys("emil");
//		driver.findElement(By.name("password")).sendKeys("anything");
//		
//	}
	
	@When("user enters {word} and {word}")
	public void user_enters_username_and_password(String username, String password) {
		if(username.equals("<blank>")){
			username = "";
		} 
		if(password.equals("<blank>")){
			password = "";
		} 
		driver.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys(password);

	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
	
	}
	
	
	@Then ("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		
		driver.findElement(By.xpath("//*[@id=\"v-step-metadata-4\"]")).isDisplayed();
//	driver.close();
//	driver.quit();
	}
	
	@Then ("login page show error")
	public void login_page_show_error() {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/i")).isDisplayed();
		driver.close();
//	driver.quit();
	}
}