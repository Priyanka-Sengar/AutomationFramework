package PreferredLease;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Datepicker {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver=  new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		final Calendar calendar = Calendar.getInstance();
		final Date date = calendar.getTime();
		String day = new SimpleDateFormat("dd").format(date);  
		// always 2 digits
		System.out.println(day);
		String month = new SimpleDateFormat("MM").format(date);  // always 2 digits
		int CurrDate=Integer.parseInt(day)+2;
		System.out.println(CurrDate);

		String curreDateString=String.valueOf(CurrDate);
		String year = new SimpleDateFormat("yyyy").format(date);
		driver.findElement(By.xpath("//label[contains(@for,'departure')]/span")).click();
		List<WebElement> datepicker=driver.findElements(By.xpath("//div[contains(@class,'DayPicker-Day')][contains(@aria-disabled,'false')]//div//p"));
		for(int i=0;i<datepicker.size();i++)
		{
			if((curreDateString).equals(datepicker.get(i).getText()))
			{
				datepicker.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//p[text()=' Login or Create Account']")).click();
		System.out.println(driver.findElement(By.xpath("//section[@class='modalMain ']//li[@class='active']")).getText());
//		if(driver.findElement(By.xpath("//section[@class='modalMain ']//li[@class='active']")).getText().equals("PERSONAL ACCOUNT"))
//		{
//			System.out.println(driver.findElement(By.xpath("//li[text()=' MyBiz Account ']")).getText());
//			driver.findElement(By.xpath("//li[text()=' MyBiz Account ']")).click();
//
//			driver.findElement(By.xpath("//a[text()=' Create New Account ']")).click();
//			System.out.println(driver.getCurrentUrl());
//			String mainWindow=driver.getWindowHandle();
//			System.out.println(mainWindow);
//			Set<String> set =driver.getWindowHandles();
//			//System.out.println(set);
//			for(String handle : set)
//			{
//				System.out.println("Switching to window - > " + handle);
//				//			 driver.switchTo().defaultContent("https://mybiz.makemytrip.com/v2/");
////						driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
//				//driver.get("<a href="http://google.com">http://google.com</a>");
//
////				driver.switchTo().defaultContent();
//
//
//				System.out.println(driver.findElement(By.xpath("//div[text()='Why Businesses Prefer myBiz?']")).getText());
//
//				WebElement element = driver.findElement(By.xpath("//a[text()='Request demo']"));
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//				element.click();
//
//				String uuid = UUID.randomUUID().toString();
//
//				//Now this uuid enter to your text box
//				driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys(uuid);
//				int random = (int) Math.random( );
//				String phoneHumber=String.valueOf(random);
//				driver.findElement(By.xpath("//input[contains(@name,'phoneNumber')]")).sendKeys(phoneHumber);
//				Date date1=new Date();
//				String email="Username1"+date1+"@gmail.com";
//				driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys(email);
//				driver.findElement(By.xpath("//div[contains(text(),'Annual Travel budget of the company')]")).sendKeys("10");
//				driver.findElement(By.xpath("//div[contains(text(),'Annual Travel budget of the company')]")).sendKeys(Keys.ENTER);
//				driver.findElement(By.xpath("//button[contains(text(),'Schedule a Demo')]")).click();//Switch to the desired window first and then execute commands using driver
//				//driver.get("<a href="http://google.com">http://google.com</a>");
//			}
//
//			if(driver.findElement(By.xpath("//h2[text()='Success']")).isDisplayed())
//			{
//				driver.findElement(By.xpath("//div[contains(@class,'sc-TOsTZ ')]//button")).click();
//			}
//		}
//
//		else
//		{
//			driver.findElement(By.xpath("//li[text()=' Personal Account ']")).click();
			driver.findElement(By.xpath("//a[text()=' Create New Account ']")).click();
			Date date1=new Date();
			String day2 = new SimpleDateFormat("dd").format(date1);  
			int random=(int) (Integer.parseInt(day2)*Math.random());
			String email="userTest"+random+"@gmail.com";
			driver.findElement(By.xpath("//input[contains(@id,'emailOrPhone')]")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Priya09@");
			
			WebElement element =driver.findElement(By.xpath("//button[@type='submit']//span[text()='Create Account']"));
			element.click();
			System.out.println(driver.findElement(By.xpath("//span[@class='accountCreatedTitle']")).getText());
			int randomMobile = (int) (Math.random( )*1000000000);
			System.out.println(randomMobile);
			String phoneHumber=String.valueOf(randomMobile).substring(0,9);
			driver.findElement(By.xpath("//section[@class='modalMain ']//input[@id='modalPhone']")).sendKeys(phoneHumber);
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshot\\fullimage.jpg"));
			
			String uuid = UUID.randomUUID().toString();
			driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(uuid);	
			driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(uuid);
			driver.findElement(By.xpath("//span[text()='Save and Continue']")).click();
		}



}
