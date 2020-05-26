package PreferredLease;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;

//imported Jars for fetching data from Excel
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// imported Jars for fetching data from XML
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

//imported Jars for fetching data from JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataDrivenTest {

	public static void main(String[] args) throws IOException, ParseException, DocumentException {
				
	  
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("Testdata.json");
		
		//Read JSON file add json plugin to eclicpe
		Object obj = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) obj;
		System.out.println("Users List-> "+usersList);
		System.setProperty( "webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver=  new ChromeDriver();

		for(int i=0;i<usersList.size();i++) {//This prints the entire json file
			JSONObject users = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) users.get("users");
			String url = (String) user.get("url");
			driver.get(url);
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
			driver.findElement(By.xpath((String)user.get("departure"))).click();
			List<WebElement> datepicker=driver.findElements(By.xpath((String) user.get("dateField")));
			for(int j=0;j<datepicker.size();j++)
			{
				if((curreDateString).equals(datepicker.get(j).getText()))
				{
					datepicker.get(j).click();
					break;
				}
			}
			  //Read excelFile

			File file =    new File("C:\\Users\\208199\\Documents\\ExcelTestData1.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			 Workbook workBook = null;
			 workBook = new XSSFWorkbook(inputStream);
			 Sheet workSheet = workBook.getSheet("Sheet1");
			 int rowCount = workSheet.getLastRowNum()-workSheet.getFirstRowNum();
			
//			for (int k = 1; k < rowCount+1; k++) {
//
//		        Row row = workSheet.getRow(k);
//
//		        //Create a loop to print cell values in a row
//
//		        for (int j = 1; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console

		        	driver.findElement(By.xpath(workSheet.getRow(1).getCell(1).getStringCellValue())).click();
					System.out.println(driver.findElement(By.xpath(workSheet.getRow(2).getCell(1).getStringCellValue())).getText());
					driver.findElement(By.xpath(workSheet.getRow(3).getCell(1).getStringCellValue())).click();
					Date date1=new Date();
					LocalDateTime now = LocalDateTime.now();
					String day2 = new SimpleDateFormat("dd").format(date1);  
					int random=(int) (Integer.parseInt(day2)*Math.random());
					int second = now.getSecond();
					String email="userTest"+random+second+"@gmail.com";
					driver.findElement(By.xpath(workSheet.getRow(4).getCell(1).getStringCellValue())).sendKeys(email);
					driver.findElement(By.xpath(workSheet.getRow(5).getCell(1).getStringCellValue())).sendKeys("Priya09@");

					WebElement element =driver.findElement(By.xpath(workSheet.getRow(6).getCell(1).getStringCellValue()));
					element.click();
//					System.out.println(driver.findElement(By.xpath(workSheet.getRow(7).getCell(1).getStringCellValue())).getText());
					int randomMobile = (int) (Math.random( )*1000000000);
					System.out.println(randomMobile);
					String phoneHumber=String.valueOf(randomMobile).substring(0,9);
					driver.findElement(By.xpath(workSheet.getRow(7).getCell(1).getStringCellValue())).click();
					WebElement state=driver.findElement(By.xpath(workSheet.getRow(8).getCell(1).getStringCellValue()));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);
					state.click();
					driver.findElement(By.xpath(workSheet.getRow(10).getCell(9).getStringCellValue())).sendKeys("9"+phoneHumber);
					//		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
					//		ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshot\\fullimage.jpg"));
					//Read xml
					
					File inputFile = new File("C:\\Users\\208199\\Desktop\\Locator.xml");									
				    SAXReader saxReader = new SAXReader();					
				    Document document = saxReader.read(inputFile);

					String uuid = UUID.randomUUID().toString();
					String firstName = document.selectSingleNode("//menu/firstname").getText();
					String LastName = document.selectSingleNode("//menu/lastName").getText();
					String submit = document.selectSingleNode("//menu/signup").getText();
					driver.findElement(By.xpath(firstName)).sendKeys(uuid);	
					driver.findElement(By.xpath(LastName)).sendKeys(uuid);
					driver.findElement(By.xpath(submit)).click();

		        }

		       
		    

			


		}
	}


