package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public  LoginPage(WebDriver driver ) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-email")
	WebElement emailAddressFiled;
	
	@FindBy(id="input-password")
	WebElement passwordFiled;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	
	public void enterTextIntoTheEmailField(String emailText) {
		
		emailAddressFiled.sendKeys(emailText);
	}
	
	public void enterTextIntoThePasswordField(String passwordText) {
		passwordFiled.sendKeys(passwordText);
		
	}
	
	public MyAccountPage clickOnLoginButton() {
		loginButton.click();
		return new MyAccountPage(driver);
	}
	
}
