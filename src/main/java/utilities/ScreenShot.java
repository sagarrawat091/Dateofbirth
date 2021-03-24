package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShot
{
	// taking the screenshot of whole web page 
	public static void takingScreenShot(WebDriver driver,String timing) throws Exception
	{
		TakesScreenshot sht = (TakesScreenshot) driver;
		File src = sht.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "\\Program_Output\\" +timing+ ".png";
		File target = new File(filepath);
		FileUtils.copyFile(src, target);
	}
	//taking the screenshot of the main section
	public static void sectionScreenShot(WebDriver driver) throws Exception
	{
		WebElement element = driver.findElement(By.className("_8ien"));
		File src = element.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "\\Program_Output\\section.png";
		File target = new File(filepath);
		FileUtils.copyFile(src, target);
	}

}
