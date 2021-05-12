package Resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;

	public WebDriver intializeDriver() throws Exception {
		
		Properties prop = new Properties();
		
		FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\maven\\src\\main\\java\\Resources\\Config.properties");
		
		prop.load(file_path);
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files\\softwares\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Program Files\\softwares\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		return driver;

	}
	


}
