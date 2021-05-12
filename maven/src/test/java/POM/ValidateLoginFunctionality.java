package POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Resources.Base;

public class ValidateLoginFunctionality extends Base{
	
	@BeforeSuite
	public void initiatizedriver() throws Exception {
		
		driver = intializeDriver();
	}
	
  @Test
  
  public void launchURL() throws Exception {
	  
	  Properties prop = new Properties();
		
		FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\maven\\src\\main\\java\\Resources\\Config.properties");
		
		prop.load(file_path);
		
	  driver.get(prop.getProperty("url"));
	  
	  driver.findElement(By.xpath(prop.getProperty("ClosePopup"))).click();
	  
	  Actions actions = new Actions(driver);
	  WebElement acc = driver.findElement(By.xpath(prop.getProperty("Account")));
	  actions.moveToElement(acc).build().perform();
	  Thread.sleep(3000);
	  acc.click();
	  
	  WebElement Signinbtn = driver.findElement(By.xpath(prop.getProperty("SignInBtn")));
	  actions.moveToElement(Signinbtn).build().perform();
  	  Thread.sleep(3000);
	  Signinbtn.click();
//register
	  
	 // driver.findElement(By.xpath(prop.getProperty("Login"))).click();
	  
	  
	  File src=new File("C:\\Users\\91994\\Documents\\credentials.xlsx");
	  FileInputStream input=new FileInputStream(src); 
	  XSSFWorkbook wb=new XSSFWorkbook(input); 
	  XSSFSheet sheet=wb.getSheet("Sheet1"); 
	 
	  String uname= sheet.getRow(1).getCell(0).getStringCellValue();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(uname);
	  
	  
	 
	  
  }
}
