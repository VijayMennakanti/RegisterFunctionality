package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

WebDriver driver;
	
	public  MyAccountPage(WebDriver driver ) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//a[text()='Edit your account information']")
	WebElement EditYourInformationText;
	
	public String loginStatusChecking() {
		
		String actualEditYourInformationText = EditYourInformationText.getText();
		
		return actualEditYourInformationText;
	}
	
	
}
