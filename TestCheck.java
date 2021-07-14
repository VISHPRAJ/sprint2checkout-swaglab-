package testng.testng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelUtils;
import dataProvider.configFileReader;
import pomwithPageFactory.CheckoutPage;

public class TestCheck {
	WebDriver driver;
	CheckoutPage checkoutpage;
	configFileReader ConfigFileReader;
	 WebElement FirstName;
	 WebElement LastName;
	 WebElement zip;
	 WebElement Continue;
	 WebElement finish;
	 WebElement complete;
  @Test(dataProvider = "dp")
  public void f(String firstName, String lastName,String Zip) {
	  FirstName.sendKeys(firstName);
	  LastName.sendKeys(lastName);
	  zip.sendKeys(Zip);
	  Continue.click();
	  finish.click();
	  complete.click();
	  Assert.assertEquals(firstName,FirstName.getText());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", ConfigFileReader.getDriverPath());
	  driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ConfigFileReader.getApplicationURL());
		checkoutpage=new CheckoutPage(driver);
		checkoutpage.enterusername();
		checkoutpage.enterpassword();
		checkoutpage.clicklogin();
		checkoutpage.clickaddtocart();
		checkoutpage.clickcart();
		checkoutpage.clickcheckout();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	  Object[][] testobjArray=ExcelUtils.getTableArray("C:\\Users\\user\\OneDrive\\Documents\\Test.xlsx","Sheet1"); 
	  return testobjArray;
  }
}
