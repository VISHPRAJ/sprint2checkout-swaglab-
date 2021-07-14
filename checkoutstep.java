package checkoutstepDefinions;

import java.awt.Desktop.Action;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.ActionMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import dataProvider.configFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomwithPageFactory.CheckoutPage;

public class checkoutstep {
	WebDriver driver;
	//String baseUrl="https://www.saucedemo.com/";
	CheckoutPage checkoutpage;
	configFileReader ConfigFileReader;
	WebElement FirstName;
	WebElement LastName;
	WebElement zip;
	@Before
	@Given("the user is on checkout page")
	public void the_user_is_on_checkout_page() {
		//Properties properties=new Properties();
		//String url=properties.getProperty("url");
		ConfigFileReader=new configFileReader();
		System.setProperty("webdriver.chrome.driver", ConfigFileReader.getDriverPath());
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(ConfigFileReader, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ConfigFileReader.getApplicationURL());
		
		checkoutpage=new CheckoutPage(driver);
		checkoutpage.enterusername();
		checkoutpage.enterpassword();
		checkoutpage.clicklogin();
		checkoutpage.clickaddtocart();
		checkoutpage.clickcart();
		checkoutpage.clickcheckout();
		
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    //driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    //driver.findElement(By.id("login-button")).click();
	   // driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	   // driver.findElement(By.className("shopping_cart_link")).click();
	   // driver.findElement(By.id("checkout")).click();
	    
	}
	    
    
	@When("user enter first name as {string}")
	public void user_enter_first_name_as(String firstName) {
	   // driver.findElement(By.id("first-name")).sFirstName;
		FirstName.sendKeys(firstName);
	    Actions a= new Actions(driver);
	    a.sendKeys(Keys.TAB).build().perform();
	    AssertJUnit.assertEquals(FirstName.getText(), "Vishal");
	}

	@When("user enter last name as {string}")
	public void user_enter_last_name_as_(String lastName){
		//driver.findElement(By.id("last-name")).sendKeys(LastName);
		LastName.sendKeys(lastName);
		Actions a= new Actions(driver);
		  a.sendKeys(Keys.TAB).build().perform();
	    
	}

	@When("user enter zip\\/postal cade as {string}")
	public void user_enter_zip_postal_cade_as(String Zip) {
		//driver.findElement(By.id("postal-code")).sendKeys(zip);
		zip.sendKeys(Zip);
	}

	@When("click on continue")
	public void click_on_continue() {
	   // driver.findElement(By.id("continue")).click();
	 checkoutpage.clickcontinue();
	}

	@When("user navigate to checkout overview page")
	public void user_navigate_to_checkout_overview_page() {
	    
	}

	@When("user click on finish")
	public void user_click_on_finish() {
	   // driver.findElement(By.id("finish")).click();
		checkoutpage.clickfinish();
	
	}

	@Then("user navigate to checkout complete page")
	public void user_navigate_to_checkout_complete_page() {
	}

	@Then("user click on back home to come in home page")
	public void user_click_on_back_home_to_come_in_home_page() {
	    //driver.findElement(By.id("checkout_complete_container")).click();
		 checkoutpage.clickcomplete();;
	}
    @After
	@Then("user click on close the window")
	public void user_click_on_close_the_window() {
		driver.quit();
	}

}
