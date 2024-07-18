package com.tutorialsninja.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTestCases11to20 {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		RegistrationTestCases11to20 test = new RegistrationTestCases11to20();
		

		/*String[] invalidTelephones = test.InvalidTelephoneData();
		 * for (String telephone : invalidTelephones) {
		 * test.registerAccountUsingInvalidTelephoneNumberTC_RF_0011 (telephone);
		 * }*/
		
		// test.RegisteringAnAccountByUsingTheKeyboardKeysTC_RF_012();
		
		// test.RegisterAccountPageHaveTheProperPlaceholdersTC_RF_013();
		
		// test.verifyAllMandatoryFieldsInTheRegisterAccountPageAreMarkedWithRedColorAstrikSymbolTC_RF_014();

	    // test.VerifyWhetherTheMandatoryFieldsInTheRegisterAccountPageAreAcceptingOnlySpacesTC_RF_016();

	    // test.VerifyWhetherThePasswordFieldsInTheRegisterAccountPageAreFollowingPasswordComplexityStandardsTC_RF_017();
	
	    // test.VerifyWhetherTheFieldsInTheRegisterAccountPageAreAccordingTheClientRequirementsTC_RF_018();
	
		// test.VerifyWhetherTheLeadingAndTrailingSpacesEnteredIntoTheRegisterAccountFieldsAreTrimmedTC_RF_019();	
	
	    // test.VerifyWhetherThePrivacyPolicyCheckboxOptionIsNotSelectedByDefaultTC_RF_020();
		
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

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();

	}

	public void tearDownMethod() {
		if (driver != null)
			driver.quit();

	}

	public void registerAccountUsingInvalidTelephoneNumberTC_RF_0011(String telephoneNumber)
			throws InterruptedException {

		setUpMethod("Chrome");

		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandedNewEmail());

		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("Pinky@034567");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();

		WebElement ff = driver.findElement(By.id("input-telephone"));
		ff.sendKeys(telephoneNumber);
		Thread.sleep(10);

		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ActualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";
		System.out.println(ActualUrl + " :this is actualUrl \n" + expectedUrl + " :This is expected URL");

		if (ActualUrl.equalsIgnoreCase(expectedUrl)) {

			System.out.println(" ActualUrl equals with the expectedUrl we on the registerPage and Test Passed.");

			String actualWarningMessage = driver
					.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
			String expectedWarningMessage = "Invalid telephone number is entered";

			if (actualWarningMessage.equals(expectedWarningMessage)) {
				System.out.println("Warning message Displayed");
			} else {
				System.out.println("Warning message not Displayed");
			}

		} else {
			System.out.println("ActualUrl notEquals with the expectedUrl Test got failed.");
		}

		tearDownMethod();

	}

	
	
	
	
	public void RegisteringAnAccountByUsingTheKeyboardKeysTC_RF_012() {

		setUpMethod("Chrome");

		Actions actions = new Actions(driver);

		for (int i = 0; i < 23; i++) {
			actions.sendKeys(Keys.TAB).perform();

		}

		actions.sendKeys("vijay").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("abcdefgrh").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(brandedNewEmail()).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("7689065433").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("Vijay@034").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("Vijay@034").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.ARROW_LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER)
				.build().perform();

		String expectedUrl = driver.getCurrentUrl();

		String ActualUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";

		if (ActualUrl.equalsIgnoreCase(ActualUrl)) {

			System.out.println(expectedUrl + " : expectedUrl\n" + ActualUrl + ": actualUrl ");
			System.out.println("Actual Url and Expected Url matching and we are landed on the AccountSuccess Page.");

		}

		else {

			System.out.println(" we are not on the AccountSuccess page");
		}
		tearDownMethod();
	}

	
	
	
	
	
	
	
	public void RegisterAccountPageHaveTheProperPlaceholdersTC_RF_013() {

		setUpMethod("Chrome");

		WebElement firstNameField = driver.findElement(By.id("input-firstname"));

		String actualFirstNamePlaceHolderText = firstNameField.getAttribute("placeholder");

		String expectedFirstNamePlaceHolderText = "First Name";

		if (actualFirstNamePlaceHolderText.equalsIgnoreCase(expectedFirstNamePlaceHolderText)) {

			System.out.println("FirstNamefiled-PlaceHolder text is Displayed");

			WebElement lastNameField = driver.findElement(By.id("input-lastname"));
			String actualLastNamePlaceHolderText = lastNameField.getAttribute("placeholder");
			String expectedLastNamePlaceHolderText = "Last Name";

			if (actualLastNamePlaceHolderText.equalsIgnoreCase(expectedLastNamePlaceHolderText)) {

				System.out.println("LastNamefield-PlaceHolder text is Displayed");

				WebElement emailField = driver.findElement(By.id("input-email"));

				String actualEmailFieldPlaceHolderText = emailField.getAttribute("placeholder");

				String expectedEmailFieldPlaceHolderText = "E-Mail";

				if (actualEmailFieldPlaceHolderText.equalsIgnoreCase(expectedEmailFieldPlaceHolderText)) {

					System.out.println("EmailField-PlaceHolder text is Displayed");

					WebElement telePhoneField = driver.findElement(By.id("input-telephone"));
					String actualTelephonFieldPlaceHolderText = telePhoneField.getAttribute("placeholder");

					String expectedTelephonFieldPlaceHolderText = "Telephone";

					if (actualTelephonFieldPlaceHolderText.equalsIgnoreCase(expectedTelephonFieldPlaceHolderText)) {

						System.out.println("TelePhoneField-PlaceHolder text is Displayed");

						WebElement passwordField = driver.findElement(By.id("input-password"));
						String actualPasswordFieldPlaceHolderText = passwordField.getAttribute("placeholder");
						String expectedPasswordFieldPlaceHolderText = "Password";

						if (actualPasswordFieldPlaceHolderText.equalsIgnoreCase(expectedPasswordFieldPlaceHolderText)) {

							System.out.println("PasswordField-PlaceHolder text is Displayed");

							WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
							String actualconfirmPasswordFieldPlaceHolderText = confirmPasswordField
									.getAttribute("placeholder");
							String expectedConfirmPasswordFieldPlaceHolderText = "Password Confirm";

							if (actualconfirmPasswordFieldPlaceHolderText
									.equalsIgnoreCase(expectedConfirmPasswordFieldPlaceHolderText)) {

								System.out.println("ConfirmPasswordField-PlaceHolder text is Displayed");

							}

							else {

								System.out.println("ConfirmPasswordField-PlaceHolder text is Not Displayed");
							}
						}

						else {

							System.out.println("PasswordField-PlaceHolder text  is Not Displayed");
						}

					}

					else {

						System.out.println("TelePhoneField-PlaceHolder text  is Not Displayed");

					}

				} else {
					System.out.println("EmailField-PlaceHolder text  is Not Displayed");

				}

			} else {

				System.out.println("LastNameField-PlaceHolder text is  Not Displayed");
			}

		} else {

			System.out.println("FirstNameField-PlaceHolder text is Not Displayed");

		}

	}

	
	
	
	
	public void verifyAllMandatoryFieldsInTheRegisterAccountPageAreMarkedWithRedColorAstrikSymbolTC_RF_014() {

		setUpMethod("Chrome");

		WebElement firstNameField = driver.findElement(By.xpath("//label[@for='input-firstname']"));

		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		String actualFirstNameFieldAsteriskSymbol = (String) javaScript.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNameField);

		if (actualFirstNameFieldAsteriskSymbol.contains("*")) {
			System.out.println("FirstNameField contains the * symbol");

			String actualFirstNameFieldAsteriskSymbolColor = (String) javaScript.executeScript(
					"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",
					firstNameField);

			String expectedFirstNameFieldAsteriskSymbolColor = "rgb(255, 0, 0)";

			if (actualFirstNameFieldAsteriskSymbolColor.equalsIgnoreCase(expectedFirstNameFieldAsteriskSymbolColor)) {
				System.out.println("FirstNameField Asterisk Symbol Color is Red");

				WebElement lastNameField = driver.findElement(By.xpath("//label[@for='input-lastname']"));
				String actualLastNameFieldAsteriskSymbol = (String) javaScript.executeScript(
						"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",
						lastNameField);

				if (actualLastNameFieldAsteriskSymbol.contains("*")) {
					System.out.println("LastNameField contains the * symbol");

					String actualLastNameFieldAsteriskSymbolColor = (String) javaScript.executeScript(
							"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",
							lastNameField);

					String expectedLastNameFieldAsteriskSymbolColor = "rgb(255, 0, 0)";

					if (actualLastNameFieldAsteriskSymbolColor
							.equalsIgnoreCase(expectedLastNameFieldAsteriskSymbolColor)) {
						System.out.println("LastNameField Asterisk Symbol Color is Red");

						WebElement emailField = driver.findElement(By.xpath("//label[@for='input-email']"));
						String actualEmailFieldAsteriskSymbol = (String) javaScript.executeScript(
								"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",
								emailField);

						if (actualEmailFieldAsteriskSymbol.contains("*")) {
							System.out.println("EmailField contains the * symbol");

							String actualEmailFieldAsteriskSymbolColor = (String) javaScript.executeScript(
									"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');",
									emailField);

							String expectedEmailFieldAsteriskSymbolColor = "rgb(255, 0, 0)";

							if (actualEmailFieldAsteriskSymbolColor
									.equalsIgnoreCase(expectedEmailFieldAsteriskSymbolColor)) {
								System.out.println("EmailField Asterisk Symbol Color is Red");
							} else {
								System.out.println("EmailField Asterisk Symbol Color is Not Red");
							}
						} else {
							System.out.println("EmailField does not contain the * symbol");
						}
					} else {
						System.out.println("LastNameField Asterisk Symbol Color is Not Red");
					}
				} else {
					System.out.println("LastNameField Asterisk Symbol is Not Displayed");
				}
			} else {
				System.out.println("FirstNameField Asterisk Symbol Color is Not Red");
			}
		} else {
			System.out.println("FirstNameField Asterisk Symbol is Not Displayed");
		}
		tearDownMethod();
	}

	
	
	
	
	
	public void VerifyWhetherTheMandatoryFieldsInTheRegisterAccountPageAreAcceptingOnlySpacesTC_RF_016() {
		setUpMethod("Chrome");

		
		driver.findElement(By.id("input-firstname")).sendKeys("    ");
		driver.findElement(By.id("input-lastname")).sendKeys("    ");
		driver.findElement(By.id("input-email")).sendKeys("    ");
		driver.findElement(By.id("input-telephone")).sendKeys("     ");
		driver.findElement(By.id("input-password")).sendKeys("   ");
		driver.findElement(By.id("input-confirm")).sendKeys("      ");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]"));
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		List<WebElement> warningMessages = driver.findElements(By.xpath(
				"//div[@class='text-danger']  | //div[@class='alert alert-danger alert-dismissible'][contains(text(),'Warning: You must agree to the Privacy Policy!')]"));

		System.out.println("Register-TC_RF_004");

		for (WebElement e : warningMessages) {
			System.out.println("- " + e.getText());

		}

		if (warningMessages.contains("Telephone must be between 3 and 32 characters!")) {

			System.out.println("Proper Telephone Warning message is displayed and Test Passed.");
		} else {

			System.out.println("Proper Telephone Warning message is Not displayed and Test Failed.");

		}
		tearDownMethod();
	}
	
	
	
	
	
	
    
	public void VerifyWhetherThePasswordFieldsInTheRegisterAccountPageAreFollowingPasswordComplexityStandardsTC_RF_017() throws InterruptedException {
		
		setUpMethod("Chrome");

		
		
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandedNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String ActualurlOfThePage = driver.getCurrentUrl();
	    String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/register";
		
	    if(ActualurlOfThePage.equalsIgnoreCase(expectedUrl)) {
	    	
	    	System.out.println("We are still on the RegisterPage And We need to check the Warning Message-Test Passed.");
	    	
	    }else {
	    	
	    	System.out.println("We are not in the RegisterPage And We did not get any Warning Message-Test Failed.");
	    }
	    tearDownMethod();
		
      	}
	
	
	
	
	
	
	
	
	
	public void VerifyWhetherTheFieldsInTheRegisterAccountPageAreAccordingTheClientRequirementsTC_RF_018() {
		
		setUpMethod("Chrome");
		
		WebElement firstNameFiled = driver.findElement(By.xpath("//input[@class='form-control']"));
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		
		String script = "var elem = arguments[0];" +
                "var style = window.getComputedStyle(elem);" +
                "var height = style.getPropertyValue('height');" +
                "var parentWidth = elem.parentElement.clientWidth;" +
                "var width = (elem.clientWidth / parentWidth) * 100 + '%';" +
                "return {" +
                "   height: height," +
                "   width: width" +
                "};";

		  java.util.Map<String, String> dimensions = (java.util.Map<String, String>) javaScript.executeScript(script, firstNameFiled);

	
		  
		  String height = dimensions.get("height");
	        String width = dimensions.get("width");
	        System.out.println("Element Height: " + height);
	        System.out.println("Element Width: " + width);

	}
	
	
	
	
	
	
	
public void VerifyWhetherTheLeadingAndTrailingSpacesEnteredIntoTheRegisterAccountFieldsAreTrimmedTC_RF_019() throws IOException, InterruptedException {
	
	
	setUpMethod("Chrome");
	driver.findElement(By.id("input-firstname")).sendKeys("       vijay     ");
	driver.findElement(By.id("input-lastname")).sendKeys("        kumar   ");
	driver.findElement(By.id("input-email")).sendKeys(       brandedNewEmail()   );
	driver.findElement(By.id("input-telephone")).sendKeys("    8685849390    ");
	driver.findElement(By.id("input-password")).sendKeys("  12345  ");
	driver.findElement(By.id("input-confirm")).sendKeys("  12345  ");
	driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
	driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	String actualUrl = driver.getCurrentUrl();
	
	System.out.println(actualUrl);
	  if(actualUrl.equalsIgnoreCase("https://tutorialsninja.com/demo/index.php?route=account/success")) {
	  
	  System.out.println("We are on the SuccessPage but The leading and trailing spaces entered into these fields are not getting trimmed");
      driver.navigate().back(); 
      
      WebDriverWait myWait=new WebDriverWait(driver, Duration.ofMillis(5));
      WebElement firstNameField = driver.findElement(By.id("input-firstname"));
      myWait.until(ExpectedConditions.visibilityOf(firstNameField));
      
	  
	  File screenShotFile = ((TakesScreenshot)
	  driver).getScreenshotAs(OutputType.FILE);
	  
	  String screenShotPath = ("./Leading&Trailing/screenshot_" + "registerPage"+
	  ".png"); FileHandler.copy(screenShotFile, new File(screenShotPath));
	  
	  System.out.println("ScreenShot Saved: " + screenShotPath);
	  }
	  else {
		  
		  System.out.println("registerPage");
	  }
	 
	
	  tearDownMethod();
	 
}	
	




  public void VerifyWhetherThePrivacyPolicyCheckboxOptionIsNotSelectedByDefaultTC_RF_020() {
	  
	  
	  setUpMethod("Chrome");
	  
	  
	 WebElement privacyPolicy = driver.findElement(By.xpath("(//input[@value='1'])[3]"));
	 
	 if(!privacyPolicy.isSelected()) {
		 
		 System.out.println("Privacy Policy checkbox not selected defaultly-TestPassed.");
	 }
	  
	 else {
		 
		 System.out.println("Privacy Policy checkbox selected defaultly-TestFailed.");
	 }
  }




	

  

	public String brandedNewEmail() {

		Date date = new Date();
		return "pinky" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

	}

	public String[] InvalidTelephoneData() {

		return new String[] { "111", "abcde" };

	}

}