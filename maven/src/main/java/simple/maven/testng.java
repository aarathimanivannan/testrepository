package simple.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testng {

	WebDriver driver;
	
	@BeforeClass
	public void lauchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();;
	}
	
	
	@Test
	
	public void launchURL() {
		driver.get("https://www.lumens.com/");
		 
		driver.findElement(By.xpath("//*[@id='ltkpopup-close-button']"));
		
	}
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	}
}

