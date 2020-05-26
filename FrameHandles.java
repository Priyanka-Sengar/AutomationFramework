package PreferredLease;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandles {
	
	
	
	
	public static void main(String args[]){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver=  new ChromeDriver();
	
	driver.get("https://www.softwaretestinghelp.com/");
	 driver.manage().window().maximize();
	//Finding all iframe tags on a web page
	List<WebElement> elements = driver.findElements(By.tagName("iframe"));
	int numberOfTags = elements.size();
	System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
	 
	// Switch to the frame using the frame id
	System.out.println("Switching to the frame");
	driver.switchTo().frame("aswift_0");
	 
	// Print the frame source code
	System.out.println("Frame Source" +driver.getPageSource());
	 
	// Switch back to main web page
	driver.switchTo().defaultContent();
	 
driver.quit();

}
}
