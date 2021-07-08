package checkoutstepDefinions;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import javax.swing.ActionMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dataProvider.configFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkoutstep {
	WebDriver driver;
	String baseUrl="https://www.saucedemo.com/";
	
	@Given("the user is on checkout page")
	public void the_user_is_on_checkout_page() {
		configFileReader ConfigFileReader=new configFileReader();
		System.setProperty("webDriver.chrome.driver", ConfigFileReader.getDriverPath());
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConfigFileReader, TimeUnit.SECONDS);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
	    driver.findElement(By.id("checkout")).click();
	    
	}
	    

	@When("user enter first name as {string}")
	public void user_enter_first_name_as(String FirstName) {
	    driver.findElement(By.id("first-name")).sendKeys(FirstName);
	    Actions a= new Actions(driver);
	    a.sendKeys(Keys.TAB).build().perform();
	}

	@When("user enter last name as {string}")
	public void user_enter_last_name_as_(String LastName){
		driver.findElement(By.id("last-name")).sendKeys(LastName);
		Actions a= new Actions(driver);
		  a.sendKeys(Keys.TAB).build().perform();
	    
	}

	@When("user enter zip\\/postal cade as {string}")
	public void user_enter_zip_postal_cade_as(String zip) {
		driver.findElement(By.id("postal-code")).sendKeys(zip);
	}

	@When("click on continue")
	public void click_on_continue() {
	    driver.findElement(By.id("continue")).click();
	}

	@When("user navigate to checkout overview page")
	public void user_navigate_to_checkout_overview_page() {
	    
	}

	@When("user click on finish")
	public void user_click_on_finish() {
	    driver.findElement(By.id("finish")).click();
	}

	@Then("user navigate to checkout complete page")
	public void user_navigate_to_checkout_complete_page() {
	}

	@Then("user click on back home to come in home page")
	public void user_click_on_back_home_to_come_in_home_page() {
	    driver.findElement(By.id("checkout_complete_container")).click();
	}

	@Then("user click on close the window")
	public void user_click_on_close_the_window() {
		driver.close();
		driver.quit();
	}

}
