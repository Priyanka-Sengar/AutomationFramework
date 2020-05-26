	package PreferredLease;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Lease {
	
	
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo-directlink.preferredlease.com/");
		driver.findElement(By.id("UserNameTextBox")).sendKeys("TexDel5");
		driver.findElement(By.id("PasswordTextBox")).sendKeys("admin123");
		driver.findElement(By.id("LoginButton")).submit();
		driver.findElement(By.id("AddNewAppLink")).click();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\208199\\Documents\\Test.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(0);
				System.out.println(cell);
				// System.out.println(sheet.getRow(1).getCell(0));
		//		XSSFCell amazon= sheet.getRow(1).getCell(0);
				String firstName = workbook.getSheetAt(1).getRow(1).getCell(0).getStringCellValue();
		//		String str1 = Integer.toString(value); 
				String lastName= workbook.getSheetAt(1).getRow(1).getCell(1).getStringCellValue();
				
				String zipCode= workbook.getSheetAt(1).getRow(1).getCell(2).getStringCellValue();
				System.out.println(firstName);
		driver.findElement(By.id("ContentPlaceHolder1_UC_Step1_pFirstNameTextBox")).sendKeys(firstName);
		driver.findElement(By.id("ContentPlaceHolder1_UC_Step1_pLastNameTextBox")).sendKeys(lastName);
		driver.findElement(By.id("ContentPlaceHolder1_UC_Step1_pZipTextBox")).sendKeys(zipCode);
		
		
		

	}

}
