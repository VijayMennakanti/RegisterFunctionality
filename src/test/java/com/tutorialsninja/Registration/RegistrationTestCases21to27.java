package com.tutorialsninja.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
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
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class RegistrationTestCases21to27 {

	WebDriver driver;

	WebDriverWait mywait;

	public static void main(String[] args) throws IOException, InterruptedException {

		RegistrationTestCases21to27 test = new RegistrationTestCases21to27();
		
     // test.RegisteringTheAccountWithoutSelectingThePrivacyPolicyCheckboxOptionTC_RF_021();
		
     // test.VerifyThePasswordTextEnteredIntoThePasswordAndPasswordConfirmFieldofRegisterAccountFunctionalityIsToggledToHideItsVisibilityTC_RF_022();

     // test.VerifyNavigatingToOtherPagesUsingTheOptionsLinksProvidedOnTheRegisterAccountPageTC_RF_023();
		
     // test.VerifyRegistringAccountByFillingPasswordFieldAndNotFillingPasswordConfirmFieldTC_RF_024();
		
     // test.VerifyBreadcrumbPageHeadingPageURLPageTitleOfRegisterAccountPageTC_RF_025();
		
	//	test.VerifyRegisterAccountFunctionalityInAllTheSupportedEnvironmentsTC_RF_027();
		
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
		if (driver != null)
			driver.quit();

	}

	public String brandedNewEmail() {

		Date date = new Date();
		return "pinky" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

	}

	public void RegisteringTheAccountWithoutSelectingThePrivacyPolicyCheckboxOptionTC_RF_021() {

		setUpMethod("Chrome");
		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandedNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("Pinky@034567");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		WebElement privacyPolicyWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]"));

		mywait.until(ExpectedConditions.visibilityOf(privacyPolicyWarningMessage));
		System.out.println(privacyPolicyWarningMessage.getText());

		String actualprivacyPolicyWarningMessageText = privacyPolicyWarningMessage.getText();
		String expectedPrivacyPolicyWarningMessageText = "Warning: You must agree to the Privacy Policy!";

		if (actualprivacyPolicyWarningMessageText.equalsIgnoreCase(expectedPrivacyPolicyWarningMessageText)) {

			System.out.println("-PrivacyPolicyWarningMessage is Displayed-Test Passed.");

		} else {

			System.out.println("-PrivacyPolicyWarningMessage is Not Displayed-Test Failed.");

		}

		tearDownMethod();
	}
	

	public void VerifyThePasswordTextEnteredIntoThePasswordAndPasswordConfirmFieldofRegisterAccountFunctionalityIsToggledToHideItsVisibilityTC_RF_022()
			throws IOException {

		setUpMethod("Chrome");
		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("Pinky@034567");

		WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
		confirmPasswordField.sendKeys("Pinky@034567");

		// Get the attribute values
		String passwordValue = passwordField.getAttribute("value");
		String confirmPasswordValue = confirmPasswordField.getAttribute("value");

		if (passwordValue.equals(confirmPasswordValue) && passwordValue.equals("Pinky@034567")) {
			System.out.println("Password is masked as ****");

			File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String screenShotPath = ("./ToggledPassword/screenshot_"
					+ "RegisterAccountFunctionalityIsToggledToHideItsVisibility" + ".png");
			FileHandler.copy(screenShotFile, new File(screenShotPath));

			System.out.println("ScreenShot Saved: " + screenShotPath);

		} else {
			System.out.println("Password is not *****");

		}
	}
	
	

	public void VerifyNavigatingToOtherPagesUsingTheOptionsLinksProvidedOnTheRegisterAccountPageTC_RF_023()
			throws InterruptedException {

		setUpMethod("Chrome");
		WebElement loginPagelink = driver.findElement(By.xpath("//a[text()='login page']"));
		loginPagelink.click();
		String actualLoginPageUrl = driver.getCurrentUrl();
		String expectedLoginPageUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";

		if (actualLoginPageUrl.equalsIgnoreCase(expectedLoginPageUrl)) {
			System.out.println("- We are in Login Page");

			driver.navigate().back();

			WebElement privacyPolicyLink = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
			privacyPolicyLink.click();

			String actualPrivacyPolicyUrl = driver.getCurrentUrl();
			String expectedPrivacyPolicyUrl = "https://tutorialsninja.com/demo/index.php?route=information/information&information_id=3";

			if (actualPrivacyPolicyUrl.equalsIgnoreCase(expectedPrivacyPolicyUrl)) {
				System.out.println("- We are in Privacy Policy Page");
				driver.navigate().back();

				WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[text()='Forgotten Password']"));
				forgotPasswordLink.click();

				String actualforgotPasswordLink = driver.getCurrentUrl();
				String expectedforgotPasswordLink = "https://tutorialsninja.com/demo/index.php?route=account/forgotten";

				if (actualforgotPasswordLink.equalsIgnoreCase(expectedforgotPasswordLink)) {
					System.out.println("- We are in the Forgot Password Page");
					driver.navigate().back();

					WebElement downloadLink = driver.findElement(By.xpath("//a[text()='Downloads']"));

					downloadLink.click();

					driver.findElement(By.id("input-email")).sendKeys("vijaymennkanti034@gmail.com");
					driver.findElement(By.id("input-password")).sendKeys("Vijay@034", Keys.ENTER);

					String actualDownloadPageUrl = driver.getCurrentUrl();

					String expectedDownloadPageUrl = "https://tutorialsninja.com/demo/index.php?route=account/download";

					if (actualDownloadPageUrl.equalsIgnoreCase(expectedDownloadPageUrl)) {

						System.out.println("-We are in the Download-Page");
						driver.navigate().back();
						driver.navigate().back();

					} else {

						System.out.println("-We are NOT in the Download-Page");

					}

				}

				else {
					System.out.println("- We are NOT in the Forgot Password Page");
				}
			} else {
				System.out.println("- We are NOT in the Privacy Policy Page");
			}
		} else {
			System.out.println("- We are NOT in the Login Page");
		}
		tearDownMethod();
	}
	
	
	

	public void VerifyRegistringAccountByFillingPasswordFieldAndNotFillingPasswordConfirmFieldTC_RF_024() {

		setUpMethod("Chrome");

		driver.findElement(By.id("input-firstname")).sendKeys("vijay");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(brandedNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8685849390");
		driver.findElement(By.id("input-password")).sendKeys("Pinky@034567");
		driver.findElement(By.id("input-confirm")).sendKeys("");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='1'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualConfirmPasswordText = driver
				.findElement(By.xpath("//div[text()='Password confirmation does not match password!']")).getText();

		String expectedConfirmPasswordText = "Password confirmation does not match password!";

		if (actualConfirmPasswordText.equalsIgnoreCase(expectedConfirmPasswordText)) {

			System.out.println("-Warning-Message is Displayed and Test-Passed.");

		} else {

			System.out.println("-Warning-Message is Not Displayed and Test-Failed.");
		}

		tearDownMethod();

	}

	
	
	
	
	public void VerifyBreadcrumbPageHeadingPageURLPageTitleOfRegisterAccountPageTC_RF_025() {

		setUpMethod("Chrome");

		WebElement accountBreadCrumb = driver.findElement(By.xpath("//a[text()='Account']"));
		String actualAccountBreadCrumbText = accountBreadCrumb.getText();

		String expectedAccountBreadCrumbText = "Account";

		if (actualAccountBreadCrumbText.equalsIgnoreCase(expectedAccountBreadCrumbText)) {

			System.out.println("-Proper \"Account\" BreadCrumb Text is Displayed: " + actualAccountBreadCrumbText);

			WebElement registerBreadCrumb = driver.findElement(By.xpath("(//a[text()='Register'])[2]"));
			String actualRegisterBreadCrumbText = registerBreadCrumb.getText();
			String expectedRegisterBreadCrumbText = "Register";

			if (actualRegisterBreadCrumbText.equalsIgnoreCase(expectedRegisterBreadCrumbText)) {

				System.out
						.println("-Proper \"Register\" BreadCrumb Text is Displayed: " + actualRegisterBreadCrumbText);

				WebElement pageHeading = driver.findElement(By.xpath("//div[@id='content']/h1"));
				String actualPageHeadingText = pageHeading.getText();
				String expectedPageHeadingText = "Register Account";

				if (actualPageHeadingText.equalsIgnoreCase(expectedPageHeadingText)) {

					System.out
							.println("-Proper \"PageHeading\" BreadCrumb Text is Displayed: " + actualPageHeadingText);

					String actualUrl = driver.getCurrentUrl();

					String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";

					if (actualUrl.equalsIgnoreCase(expectedUrl)) {

						System.out.println("-Actual-Url matches with the Expected-Url :" + actualUrl);

						String actualPageTitle = driver.getTitle();

						String expectedPageTitle = "Register Account";

						if (actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {

							System.out.println("-Proper \"PageTitle\" is Displayed: " + actualPageTitle);

							System.out.println("-Hence Test Passed.");
						}

						else {

							System.out.println("-Proper \"PageTitle\" is NOT Displayed.");
							System.out.println("-Hence Test Failed");
						}

					}

					else {

						System.out.println("-Actual-Url NOT matches with the Expected-Url ");

					}
				} else {

					System.out.println("-Proper \"PageHeading\" BreadCrumb Text is NOT Displayed.");
				}
			} else {

				System.out.println("-Proper \"Register\" BreadCrumb Text is NOT Displayed.");
			}

		} else {

			System.out.println("-Proper \"Account\" BreadCrumb Text is NOT Displayed.");

		}
		tearDownMethod();
	}

	
	
	
	public void VerifyRegisterAccountFunctionalityInAllTheSupportedEnvironmentsTC_RF_027() {

		String[] browsers = { "Chrome", "Firefox", "Edge" };

		for (String browser : browsers) {

			setUpMethod(browser);
			String actualTitleOfTheRegisterPage = driver.getTitle();
			String expectedTitleOfTheRegisterPage = "Register Account";

			if (actualTitleOfTheRegisterPage.equalsIgnoreCase(expectedTitleOfTheRegisterPage)) {

				System.out.println("-We are in the RegisterPage-" + browser + "Driver");

			} else {

				System.out.println("-We are NOT in the RegisterPage-" + browser + "Driver");
			}
			tearDownMethod();
		}

	}

}
