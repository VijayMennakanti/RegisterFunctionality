package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginFunctionality {

	WebDriver driver;
	Properties prop;
	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;

	@BeforeMethod
	public void setUpMethod() {

		WebDriverManager.chromedriver().setup();
		try {
			prop = new Properties();

			File file = new File(System.getProperty("user.dir") + "\\src\\test\\Resources\\Project.properties");
			FileReader fr = new FileReader(file);
			prop.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String browserName = "Chrome";

		if (browserName.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(prop.getProperty("url"));

		homepage= new HomePage(driver);
		loginpage=homepage.navigateToLoginPage();
		

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null)
			driver.quit();

	}

	@Test
	public void VerifyLoggingIntoTheApplicationUsingValidCredentials() {

		
		loginpage.enterTextIntoTheEmailField(prop.getProperty("validemail"));
		loginpage.enterTextIntoThePasswordField(prop.getProperty("validpassword"));
		myaccountpage=	loginpage.clickOnLoginButton();

		

		String expectedEditYourInformationText = "Edit your account information";

		Assert.assertEquals(myaccountpage.loginStatusChecking(), expectedEditYourInformationText);

	}

}
