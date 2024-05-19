package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTest extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="testdatasheet")
	public static void LoginTest(String username,String password) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

}
