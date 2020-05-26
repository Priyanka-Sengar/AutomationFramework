package PreferredLease;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Windowswitch {
	
	public static void main(String args[]) throws IOException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver=  new ChromeDriver();
		driver.get("https://www.makemytrip.com/hotels/");
		driver.findElement(By.xpath("//p[text()=' Login or Create Account']")).click();
		System.out.println(driver.findElement(By.xpath("//section[@class='modalMain ']//li[@class='active']")).getText());
		if(driver.findElement(By.xpath("//section[@class='modalMain ']//li[@class='active']")).getText().equals("PERSONAL ACCOUNT"))
		{
			System.out.println(driver.findElement(By.xpath("//li[text()=' MyBiz Account ']")).getText());
			driver.findElement(By.xpath("//li[text()=' MyBiz Account ']")).click();

			driver.findElement(By.xpath("//a[text()=' Create New Account ']")).click();
			System.out.println(driver.getCurrentUrl());
			/*String mainWindow=driver.getWindowHandle();
			System.out.println(mainWindow);
			Set<String> set =driver.getWindowHandles();
			//System.out.println(set);
			for(String handle : set)
			{
				System.out.println("Switching to window - > " + handle);
				//			 driver.switchTo().defaultContent("https://mybiz.makemytrip.com/v2/");
//						driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
				//driver.get("<a href="http://google.com">http://google.com</a>");

//				driver.switchTo().defaultContent();
*/				
			    WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
			    driver.get("https://mybiz.makemytrip.com/v2/");

				System.out.println(driver.findElement(By.xpath("//div[text()='Why Businesses Prefer myBiz?']")).getText());

				/*WebElement element = driver.findElement(By.xpath("//a[text()='Request demo']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();

				String uuid = UUID.randomUUID().toString();

				//Now this uuid enter to your text box
				driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys(uuid);
				int random = (int) Math.random( );
				String phoneHumber=String.valueOf(random);
				driver.findElement(By.xpath("//input[contains(@name,'phoneNumber')]")).sendKeys(phoneHumber);
				Date date1=new Date();
				String email="Username1"+date1+"@gmail.com";
				driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys(email);
				driver.findElement(By.xpath("//div[contains(text(),'Annual Travel budget of the company')]")).sendKeys("10");
				driver.findElement(By.xpath("//div[contains(text(),'Annual Travel budget of the company')]")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//button[contains(text(),'Schedule a Demo')]")).click();//Switch to the desired window first and then execute commands using driver
				//driver.get("<a href="http://google.com">http://google.com</a>");
			}

			if(driver.findElement(By.xpath("//h2[text()='Success']")).isDisplayed())
			{
				driver.findElement(By.xpath("//div[contains(@class,'sc-TOsTZ ')]//button")).click();
			}
		}
	}*/
			}
			}

}
