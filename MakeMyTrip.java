package PreferredLease;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String args[]) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		Date todaysDate = new Date();
   DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   String testDateString = df.format(todaysDate);
		String[] dateParts = testDateString.split("/");
		String day = dateParts[0]; 
		String month = dateParts[1];
		String year = dateParts[2];
		int i=Integer.parseInt(day);  
		//Printing value of i  
		int j= i + 6;
		String dateAdv=String.valueOf(j);
		System.out.println(dateAdv);
	//	System.out.println(j);
		List<WebElement> p=driver.findElements(By.xpath("//div[contains(@class,'DayPicker-Day')][contains(@aria-disabled,'false')]//div//p"));
		/*int t= p.size();
		System.out.println(t);*/
	
		for(int k=0;k<p.size();k++)
		{
			
			System.out.println(p.get(k).getText());
			
			if(dateAdv.equals(p.get(k).getText()))
			{
			
				p.get(k).click();
				break;
				
			}
		}
		




}
}

