package GridTest.SauceLabs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	public void doLogin() {
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.cssSelector("#Email")).sendKeys("test323@testing.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("India321");
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
	}

	@Test(priority = 1)
	public void checkPageTitle() {
		doLogin();
		String title = driver.getTitle();
		System.out.println("Page title is "+title);
		Assert.assertEquals(title, "Demo Web Shop");
	}

	@Test(priority = 2)
	public void checkLoggedUser() {
		doLogin();
		String loggeduser = driver.findElement(By.cssSelector("div[class='header-links'] a[class='account']")).getText();
		System.out.println(loggeduser);
		Assert.assertEquals(loggeduser, "test323@testing.com");
	}

}
