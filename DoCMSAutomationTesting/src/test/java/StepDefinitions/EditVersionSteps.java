package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditVersionSteps {
	
	WebDriver driver = null;
	
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dimas\\eclipse-workspace\\DoCMSAutomationTesting\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize(); // menampilkan jendela browser full screen
	}
	
	
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

	public void user_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
	
	}
	
	
	public void user_is_navigated_to_the_home_page() {
		
		driver.findElement(By.xpath("//*[@id=\"v-step-metadata-4\"]")).isDisplayed();
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
	
	@When("user click skip metadata tour")
	public void user_click_skip_metadata_tour(){
		driver.findElement(By.xpath("//*[@id=\"v-step-46f34eda\"]/div[2]/button[1]")).click();
	}
	
	@And("user clicks on manage content button")
	public void user_clicks_on_manage_content_button() {
		driver.findElement(By.xpath("//*[@id=\"v-step-3\"]")).click();
	}
	
	@When("user click skip manage content tour")
	public void user_click_skip_manage_content_tour(){
		driver.findElement(By.xpath("//*[@id=\"v-step-88d83ff6\"]/div[2]/button[1]")).click();
	}
	
    @And("user clicks on edit icon")
	public void user_clicks_on_edit_icon() {
    	driver.findElement(By.xpath("//*[@id=\"v-step-manage-1\"]/div[1]/div/div[3]/div/div[2]/button[1]/span")).click();
    }
	
    @When("user enters {word}")
	public void user_enters_NewVersionName (String NewVersionName){
    	if(NewVersionName.equals("<blank>")){
    		NewVersionName = "";
    	}
    	System.out.print(NewVersionName);
    	//driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/form/div/div[1]/div/div/div[1]/div")).sendKeys(NewVersionName);
    	//driver.findElement(By.id("input-122")).clear();
    	driver.findElement(By.id("input-127")).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(By.id("input-127")).sendKeys(Keys.DELETE);
    	driver.findElement(By.id("input-127")).sendKeys(NewVersionName);
    }
	
    @And("user clicks on save button")
	public void user_clicks_on_save_button () {
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/form/div/div[2]/button[2]/span")).click();
    }
	
    @Then("user got message edited success")
	public void user_got_message_edited_success() {
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div/div[1]")).isDisplayed();
    	//driver.close();
    }
	
}