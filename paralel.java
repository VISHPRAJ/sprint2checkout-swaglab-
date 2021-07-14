package checkoutstepDefinions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.configFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class paralel {
	WebDriver driver;
	//String baseUrl="https://www.saucedemo.com/";
	configFileReader ConfigFileReader;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", ConfigFileReader.getDriverPath());

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ConfigFileReader.getApplicationURL());
		
	}

	@When("user enters username")
	public void user_enters_username() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}

	@When("user enters password")
	public void user_enters_password() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@When("user click on login")
	public void user_click_on_login() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("user is on homepage")
	public void user_is_on_homepage() {
	   
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {
	    driver.quit();
	}


}
