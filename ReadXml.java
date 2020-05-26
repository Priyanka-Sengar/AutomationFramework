package PreferredLease;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadXml {

	public static void main(String[] args) throws DocumentException {
		// Creating WebDriver Instance		
	    WebDriver driver;			
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");				
	    driver = new ChromeDriver();					
	    driver.get("http://demo.guru99.com/test/guru99home/");					
	    driver.manage().window().maximize();			
	// Reading XML File    		
	    File inputFile = new File("C:\\Users\\208199\\Desktop\\Locator.xml");									
	    SAXReader saxReader = new SAXReader();					
	    Document document = saxReader.read(inputFile);							
	    String mobileTesting = document.selectSingleNode("//menu/mobiletesting").getText();
	    System.out.println(mobileTesting);
	    //div[@class='canvas-middle']//h4						
	    String emailTextBox = document.selectSingleNode("//menu/email").getText();		//div[@class='rt-block']//h2
	    
	    String signUpButton = document.selectSingleNode("//menu/signup").getText();		//div[@id='site-name']//a[contains(@title,'Home')]					

	//Navigating to Mobile Testing and back		
	    driver.findElement(By.xpath(mobileTesting)).click();					
	    driver.navigate().back();			
	//Entering Form Data		
	driver.findElement(By.id(emailTextBox)).sendKeys("testguru99@gmail.com");						
	driver.findElement(By.id(signUpButton)).click();	

	}

}
