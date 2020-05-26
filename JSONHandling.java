package PreferredLease;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSONHandling {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void testAut() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
		readWriteJSON();
	}
//	@AfterTest
//	public void afterTest() {
//		driver.close();
//	}
	public String login(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[@class='ico-login']")).click();
		driver.findElement(By.name("Email")).sendKeys(username);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")).click();
		if(driver.findElements(By.xpath("//input[@id='vote-poll-1']")).size()>0)
		{
			String uname = driver.findElement(By.xpath("//a[@href='/customer/info']")) .getText();
			if(uname.equals(username))
				driver.findElement(By.xpath("//a[@href='/logout']")).click();
		}
		else 
		{
			driver.findElement(By.xpath("//a[@href='/login']")).click();
			return "Invalid User";
		}
		return "Valid User";
	}
	

	public void readWriteJSON() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonParser = new JSONParser();
		try  {
			FileReader reader = new FileReader("Testdata.json");
			//Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONArray usersList = (JSONArray) obj;
			System.out.println("Users List-> "+usersList); //This prints the entire json file
			System.out.println(usersList.size());
			for(int i=0;i<usersList.size();i++) {
				JSONObject users = (JSONObject) usersList.get(i);
				System.out.println("Users -> "+users);//This prints every block - one json object
				JSONObject user = (JSONObject) users.get("users");
				String username = (String) user.get("username");
				driver.findElement(By.xpath(username)).click();
			
				System.out.println("User -> "+user); //This prints each data in the block
//				String username = (String) user.get("username");
				String password = (String) user.get("password");
				String result = login(username,password);
				user.put("result", result);
				//Write JSON file
				try (FileWriter file = new FileWriter("Testdata1.json")) {
					file.append(usersList.toJSONString());
					file.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}