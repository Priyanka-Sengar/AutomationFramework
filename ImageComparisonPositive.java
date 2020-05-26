package PreferredLease;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparisonPositive 
{
    WebDriver driver;
     
    @Test
    public void imageComaparision() throws IOException
    {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\208199\\Downloads\\chromedriver.exe");
		WebDriver driver=  new ChromeDriver();;
        driver.get("http://demo.automationtesting.in/Register.html");
         
        WebElement logoImage = driver.findElement(By.cssSelector("#imagetrgt"));
         
        BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Images\\ElementScreenshot.png"));
        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
        BufferedImage actualImage = logoImageScreenshot.getImage();
                 
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        Assert.assertFalse(diff.hasDiff(),"Images are Same");
                 
        driver.quit();
    }
}

