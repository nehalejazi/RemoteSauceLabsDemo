package GridTest.SauceLabs;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	@Parameters({"browser","platformName"})
	@BeforeMethod
	public void setup(String browserName,String platformName,Method name)
	{
		System.out.println("Browser name is "+browserName);
		String methodname = name.getName();
		MutableCapabilities saouceOptions = new MutableCapabilities();
		saouceOptions.setCapability("name", methodname);
		saouceOptions.setCapability("build", "POM Build");
		saouceOptions.setCapability("seleniumVersion", "3.141.59");
		saouceOptions.setCapability("username", "learn5151");
		saouceOptions.setCapability("accessKey", "4056cbd0-e3a6-46fc-9794-9b85768e05b1");
		saouceOptions.setCapability("tags", "Running from POM");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", saouceOptions);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", platformName);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");
		}
		// https://naveenanimation20:f418309b-b7b4-424d-825c-0d4a78b90bb5@ondemand.us-west-1.saucelabs.com:443/wd/hub
		try {
			//Url on sauec lab is = https://learn5151:4056cbd0-e3a6-46fc-9794-9b85768e05b1@ondemand.eu-central-1.saucelabs.com:443/wd/hub
			driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}

}
