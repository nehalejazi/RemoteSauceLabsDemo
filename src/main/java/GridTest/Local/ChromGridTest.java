package GridTest.Local;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromGridTest {
/*
	public static void main(String[] args) throws MalformedURLException {
	
		//1. Definec Desired Capablities.
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		//2. Chrome Option definition
		ChromeOptions options = new ChromeOptions();
		
		options.merge(cap);
		
		String hubUrl = "http://192.168.0.11:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);
		driver.get("http://demowebshop.tricentis.com/");
		System.out.println(driver.getTitle());

	}
	*/

}
