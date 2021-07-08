package pomwithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public WebDriver driver;
    @FindBy(how=How.ID,using="user-name") WebElement username;
    @FindBy(how=How.ID,using="password") WebElement password;
    @FindBy(how=How.ID,using="login-button") WebElement loginbutton;
    @FindBy(how=How.ID,using="add-to-cart-sauce-labs-backpack") WebElement addtocart;
    @FindBy(how=How.CLASS_NAME,using="shopping_cart_link") WebElement cart;
    @FindBy(how=How.ID,using="checkout") WebElement checkout;
    @FindBy(how=How.ID,using="first-name") WebElement FirstName;
    @FindBy(how=How.ID,using="last-name") WebElement LastName;
    @FindBy(how=How.ID,using="postal-code") WebElement zip;
    @FindBy(how=How.ID,using="continue") WebElement Continue;
    @FindBy(how=How.ID,using="finish") WebElement finish;
    @FindBy(how=How.ID,using="checkout_complete_container") WebElement complete;
    
    public CheckoutPage(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    public void enterusername(){
    	username.sendKeys("standard_user");
    }
    public void enterpassword(){
    	password.sendKeys("secret_sauce");
    }
    public void clicklogin(){
    	loginbutton.click();
    }
    public void clickaddtocart(){
    	addtocart.click();
    }
    public void clickcart(){
    	cart.click();
    }
    public void clickcheckout(){
    	checkout.click();
    }
    public void enterfirstname(){
    	FirstName.sendKeys(FirstName);
    }
    public void enterlastname(){
    	LastName.sendKeys(LastName);
    }
    public void enterzip(){
    	zip.sendKeys("700006");
    }
    public void clickcontinue(){
    	Continue.click();
    }
    public void clickfinish(){
    	finish.click();
    }
    public void clickcomplete(){
    	complete.click();
    }




}
