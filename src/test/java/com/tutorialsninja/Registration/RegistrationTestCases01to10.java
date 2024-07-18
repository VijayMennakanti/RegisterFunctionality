package com.tutorialsninja.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTestCases01to10 {

	static WebDriver driver;
	static WebDriverWait mywait;
	
   

	public static void main(String[] args) throws IOException, InterruptedException {

		RegistrationTestCases01to10 test = new RegistrationTestCases01to10();

	  //test.registerWithMandatoryFiledTC_RF_001();

		test.verfiyThankyouforregisteringemailTC_RF_002();
		

	  //test.registerByProvidingWithAllFiledsTC_RF_003();

	  //test.VerifyProperNotificationMessagesAreDisplayedWhenYouDontProvideAnyFieldsTC_RF_004();

	 // test.RegisteringAccountwhenYesOptionSelectedForNewsletterTC_RF_005();

	 // test.RegisteringAccountwhenNoOptionSelectedForNewsletterTC_RF_006();

	 // test.differentWaysOfNavigatingToRegisterAccountPageTC_RF_007();

	 // test.RegisteringAccountByEnteringDifferentPasswordsIntoPasswordAndPasswordConfirmFieldsTC_RF_008();

	 // test.RegisteringAccountByProvidingTheExistingAccountDetailsTC_RF_009 ();
		
	 // test.RegisteringAccountByProvidingMultipleInvalidEmailAddressIntoEMailFieldTC_RF_0010();

		
		 
		
		
		
	}

	public void setUpMethod(String driverName) {

		WebDriverManager.chromedriver().setup();

		if (driverName.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (driverName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else if (driverName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}

		mywait = new WebDriverWait(driver, Duration.ofMillis(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

	public void tearDownMethod() {
		if (driver != null) {
			driver.quit();
		}

	}

	public void registerWithMandatoryFiledTC_RF_001() {

		setUpMethod("Chrome");
		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("Pinky@034567");
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String accountHasbeenCreatedText = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"))
				.getText();

		System.out.println("Register-TC_RF_001");
		if (accountHasbeenCreatedText.equals("Your Account Has Been Created!")) {

			System.out.println("-Your Account Has Been Created! Message is Displayed");
			
			WebElement congratsElement = driver.findElement(By.xpath("//div[@id='content']/p[1]"));	
			String CongratulationsMessage = congratsElement.getText();
			
			if(CongratulationsMessage.equalsIgnoreCase("Congratulations! Your new account has been successfully created!")) {
				
				System.out.println("-Congratulations! Your new account has been successfully created!-Message is Displayed.");
			
			
				WebElement questionsElement = driver.findElement(By.xpath("//div[@id='content']/p[3]"));
				String ifYouHaveAnyQuestionMessageText = questionsElement.getText();
				
				if(ifYouHaveAnyQuestionMessageText.equalsIgnoreCase("If you have ANY questions about the operation of this online shop, please e-mail the store owner.")) {
					
					System.out.println("-If you have any questions about the operation of this online shop, please e-mail the store owner-Message is Displyed.");
					
				}
				
				else {
					
					System.out.println("If you have any questions about the operation of this online shop, please e-mail the store owner-Message is Not Displayed.");
				}
				
			}
			else {
				
				System.out.println("-Congratulations! Your new account has been successfully created!-Message is Not Displayed.");	
				
			}

		} else {
			System.out.println("-Your Account Has Been  Created! Message is Not Displayed");
		}

		tearDownMethod();
	}

	public String brandNewEmail() {

		Date date = new Date();
		return "pinky" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

	}

	
	
	public void verfiyThankyouforregisteringemailTC_RF_002() throws InterruptedException {
		setUpMethod("Chrome");
		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys("vijaymennkanti034@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Vijay@034");
		driver.findElement(By.id("input-confirm")).sendKeys("Vijay@034");
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		tearDownMethod();
		
		checkEmailforThanks();
		

	}

	public void checkEmailforThanks() throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait myWait= new WebDriverWait(driver, Duration.ofMillis(10));
		
		driver.get("https://mailosaur.com/app/login?redirect=%2Fapp");
		driver.findElement(By.id("email")).sendKeys("vijaymennkanti034@gmail.com");
	    driver.findElement(By.xpath("//button[text()='Continue']")).click();
	 
	    WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        passwordInput.sendKeys("Vijay@034");

	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    
	    WebElement Inbox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Inboxes'])[4]")));
	    Inbox.click();
	   
	    WebElement searchField =new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
	   
	    searchField.sendKeys("tutorialsninjaEmails",Keys.ENTER);
	    
	    WebElement noResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='table-cell text-center']")));
	   System.out.println(noResult.getText()); 
	    
	   if(!noResult.getText().contains("No results found for tutorialsninjaEmails")) {
		   
		   System.out.println("-Confiramtion Email is sent to the Registered EmailId-Test Passed");
	   }else {
		   System.out.println("-No results found for tutorialsninjaEmails-Test Failed");
		  
	   }
	  
	 
	}

	
	
	
	public void registerByProvidingWithAllFiledsTC_RF_003() {

		setUpMethod("Chrome");

		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("Pinky@034567");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		WebElement accountCreatedElement = driver
				.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));

		System.out.println("Register-TC_RF_003");
		if (accountCreatedElement.isDisplayed()) {
			System.out.println("Text 'Your Account Has Been Created!' is present on the page.");

			WebElement congratsElement = driver.findElement(By.xpath("//div[@id='content']/p[1]"));
			if (congratsElement.isDisplayed()) {
				System.out.println(
						"Text 'Congratulations! Your new account has been successfully created!' is present on the page.");

				WebElement questionsElement = driver.findElement(By.xpath("//div[@id='content']/p[3]"));
				if (questionsElement.isDisplayed()) {
					System.out.println(
							"Text 'If you have ANY questions about the operation of this online shop, please e-mail the store owner.' is present on the page.");

					WebElement confirmationElement = driver.findElement(By.xpath("//div[@id='content']/p[4]"));
					if (confirmationElement.isDisplayed()) {
						System.out.println(
								"Text 'A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.' is present on the page.");
					} else {
						System.out.println(
								"Text 'A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.' is NOT present on the page.");
					}
				} else {
					System.out.println(
							"Text 'If you have ANY questions about the operation of this online shop, please e-mail the store owner.' is NOT present on the page.");
				}
			} else {
				System.out.println(
						"Text 'Congratulations! Your new account has been successfully created!' is NOT present on the page.");
			}
		} else {
			System.out.println("Text 'Your Account Has Been Created!' is NOT present on the page.");
		}

	}
	
	
	
	
	

	public void VerifyProperNotificationMessagesAreDisplayedWhenYouDontProvideAnyFieldsTC_RF_004() {

		setUpMethod("Chrome");
		
		driver.findElement(By.id("input-firstname")).sendKeys("");
		driver.findElement(By.id("input-lastname")).sendKeys("");
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-telephone")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("input-confirm")).sendKeys("");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]"));
		driver.findElement(By.xpath("(//input[@value='1'])[3]"));
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		List<WebElement> warningMessages = driver.findElements(By.xpath(
				"//div[@class='text-danger']  | //div[@class='alert alert-danger alert-dismissible'][contains(text(),'Warning: You must agree to the Privacy Policy!')]"));

		System.out.println("Register-TC_RF_004");
		if (!warningMessages.isEmpty()) {
			System.out.println("Multiple warning messages displayed:");
			System.out.println();

			for (WebElement e : warningMessages) {
				System.out.println("- " + e.getText());
			}
		} else {
			System.out.println("No warning messages displayed.");
		}

		tearDownMethod();

	}
	
	
	
	
	

	public void RegisteringAccountwhenYesOptionSelectedForNewsletterTC_RF_005() {

		setUpMethod("Chrome");

		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("Pinky@034567");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Subscribe / unsubscribe to newsletter')]")).click();

		WebElement SubscribeYesOption = driver.findElement(By.xpath("//input[@value='1']"));

		System.out.println("Register-TC_RF_005");
		if (SubscribeYesOption.isSelected()) {

			System.out.println("Newsletter Subscription-\"Yes-Option\" got Selected by Default");
		} else {

			System.out.println("Newsletter Subscription-\"Yes-Option\" Not Selected by Default");
		}

	}
	
	
	
	
	

	public void RegisteringAccountwhenNoOptionSelectedForNewsletterTC_RF_006() {

		setUpMethod("Chrome");

		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("Pinky@034567");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Subscribe / unsubscribe to newsletter')]")).click();

		WebElement SubscribeNoOption = driver.findElement(By.xpath("//input[@value='0']"));
		System.out.println("Register-TC_RF_006");
		if (SubscribeNoOption.isSelected()) {

			System.out.println("Newsletter Subscription-\"No-Option\" got Selected by Default");
		} else {

			System.out.println("Newsletter Subscription-\"No-Option\" Not Selected by Default");
		}

	}
	
	
	

	public void differentWaysOfNavigatingToRegisterAccountPageTC_RF_007() {

		setUpMethod("Chrome");

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		mywait.until(ExpectedConditions.titleIs("Register Account"));
		String titleOfThePage1 = driver.getTitle();
		System.out.println("Title of the Register Page: " + titleOfThePage1);
		driver.navigate().back();

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		mywait.until(ExpectedConditions.titleIs("Register Account"));
		String titleOfThePage2 = driver.getTitle();
		System.out.println("Title of the Register Page from Login and Continue: " + titleOfThePage2);
		driver.navigate().back();

		driver.findElement(By.xpath("(//a[text()='Register'])[2]")).click();
		mywait.until(ExpectedConditions.titleIs("Register Account"));
		String titleOfThePage3 = driver.getTitle();
		System.out.println("Title of the Register Page from Right Column: " + titleOfThePage3);

		System.out.println("Register-TC_RF_007");
		if (titleOfThePage1.equals(titleOfThePage2) && titleOfThePage2.equals(titleOfThePage3)) {
			System.out.println("All three titles are the same and  Landed in the same Register-Accountant Page.");
		} else {
			System.out.println("Titles are not all the same.");
		}

		tearDownMethod();
	}

	
	
	
	
	public void RegisteringAccountByEnteringDifferentPasswordsIntoPasswordAndPasswordConfirmFieldsTC_RF_008() {

		setUpMethod("Chrome");

		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("abcdefgh");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ActualPasswordDoesNotMatchWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Password confirmation does not match password!')]"))
				.getText();

		String expectedPasswordDoesNotMatchWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Password confirmation does not match password!')]"))
				.getText();
		System.out.println("Register-TC_RF_008");
		if (ActualPasswordDoesNotMatchWarningMessage.equalsIgnoreCase(expectedPasswordDoesNotMatchWarningMessage)) {

			System.out.println("\"Password confirmation does not match password!\" Message is Displayed.");

		} else {

			System.out.println("Warning Message Not Displayed.");
		}
		tearDownMethod();
	}

	
	
	
	public void RegisteringAccountByProvidingTheExistingAccountDetailsTC_RF_009() {

		setUpMethod("Chrome");

		
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys(" Motoori");
		driver.findElement(By.id("input-email")).sendKeys("amotoori1@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys(" 09246812111");
		driver.findElement(By.id("input-password")).sendKeys(" 12345");
		driver.findElement(By.id("input-confirm")).sendKeys(" 12345");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ActualEmailAlreadyExistMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Warning: E-Mail Address is already registered!')]"))
				.getText();

		String ExpectedEmailAlreadyExistMessage = "Warning: E-Mail Address is already registered!";

		System.out.println("Register-TC_RF_009");
		if (ActualEmailAlreadyExistMessage.equalsIgnoreCase(ExpectedEmailAlreadyExistMessage)) {

			System.out.println("\"Warning: E-Mail Address is already registered!\" is Displayed.");
		} else {

			System.out.println("\"Warning: E-Mail Address is already registered!\" is Not Displayed");
		}
		tearDownMethod();
	}

	
	
	
	
	public void RegisteringAccountByProvidingMultipleInvalidEmailAddressIntoEMailFieldTC_RF_0010() throws IOException  {

		setUpMethod("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));



		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys(" Motoori");
		driver.findElement(By.id("input-telephone")).sendKeys(" 09246812111");
		driver.findElement(By.id("input-password")).sendKeys(" 12345");
		driver.findElement(By.id("input-confirm")).sendKeys(" 12345");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();

		System.out.println("Register-TC_RF_010");
		System.out.println();
		String[] invalidEmails = { "amotoori", "amotoori@", " amotoori@gmail", "amotoori@gmail" };

		for (String email : invalidEmails) {

			WebElement emailInput = driver.findElement(By.id("input-email"));

			emailInput.clear();
			emailInput.sendKeys(email);

			driver.findElement(By.xpath("//input[@value='Continue']")).click();

			File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String screenShotPath = ("./ScreenShots/screenshot_" + email + ".png");
			FileHandler.copy(screenShotFile, new File(screenShotPath));

			System.out.println("ScreenShot Saved: " + screenShotPath);
		}

		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);

		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";

		if (actualUrl.equals(expectedUrl)) {

			System.out.println(
					"Account should not be created, instead a proper field level warning message are Displayed.");
		}

		else {

			System.out.println("Field level Warning Messages Not Displayed.");
		}

		tearDownMethod();
	}


		

}
	
	
	
	
	

