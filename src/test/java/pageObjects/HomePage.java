package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public  HomePage(WebDriver driver ) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountDropDownMenuOption;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginOption;
	
	
	
	
	public HomePage clickOnmyAccountDropDownMenuOption() {
		
		myAccountDropDownMenuOption.click();
		return new HomePage(driver);
	}
	
	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public LoginPage navigateToLoginPage() {
		clickOnmyAccountDropDownMenuOption();
	return	clickOnLoginOption();
		
	}
}
