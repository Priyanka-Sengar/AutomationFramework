package PreferredLease;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkartp {
	
	
	public static void main(String args[]){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
	WebDriver driver=  new ChromeDriver();
	driver.get("http://se3.adam.com/content.aspx?productid=117&isarticlelink=false&pid=1&gid=003997");
	driver.manage().window().maximize();
	String title = driver.getTitle(); 
	String mainWindow=driver.getWindowHandle();
	System.out.println(mainWindow);
	WebElement element = driver.findElement(By.xpath("//div//font//a"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	element.click();
	Set<String> set =driver.getWindowHandles();
	//System.out.println(set);
	for(String handle : set)
	{
	System.out.println("Switching to window - > " + handle);
	System.out.println("Navigating to google.com");
	driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
	//driver.get("<a href="http://google.com">http://google.com</a>");
	}
	 
	}

	}




	


