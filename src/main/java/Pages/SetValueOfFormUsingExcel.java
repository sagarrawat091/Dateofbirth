package Pages;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.GettingValueFromExcel;

public class SetValueOfFormUsingExcel {
	static Select day,month,year;
	// fill detail in the form
	public void setvalueUsingExcelFile(WebDriver driver) throws InterruptedException {
		// getting WebElement of register button
		WebElement registerbtn = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		
		// click on register button
		registerbtn.click();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// getting the firstName WebElement
		WebElement firstName = driver.findElement(By.name("firstname"));
		
		// --getting from excel file--
		firstName.sendKeys(GettingValueFromExcel.getFirstName());
		
		// getting the lastName element
		WebElement lastName = driver.findElement(By.name("lastname"));
		
		// getting lastName from excel file
		lastName.sendKeys(GettingValueFromExcel.getLastName());
		
		// getting the mobileNumber element
		WebElement mobileNumber = driver.findElement(By.name("reg_email__"));
		
		// getting value from excel file
		mobileNumber.sendKeys(GettingValueFromExcel.getMobileNum());
		
		// getting the password element
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		
		// getting value from excel file
		password.sendKeys(GettingValueFromExcel.getPassword());
	}

	public void selectdateUsingExcelFile(WebDriver driver) {
		// getting the day element and select the day by visible text
		WebElement days = driver.findElement(By.id("day"));
		
		// getting day element
		day = new Select(days);
		
		// getting value from excel file
		day.selectByVisibleText(GettingValueFromExcel.getday());
		
		// getting month element
		WebElement months = driver.findElement(By.id("month"));
		month = new Select(months);
		
		// selecting month
		month.selectByValue(GettingValueFromExcel.getMonth());
		
		// getting the year element
		WebElement Years = driver.findElement(By.id("year"));
		year = new Select(Years);
		
		// selecting year
		year.selectByValue(GettingValueFromExcel.getYear());
	}

	//for verification of date of birth
	public void verifyDobUsingExcel()
	{
		int expectedday = Integer.parseInt(day.getFirstSelectedOption().getText());//getting day value from  webpage
		
		int expectedmonth = Integer.parseInt(month.getFirstSelectedOption().getAttribute("value"));//getting month value from webpage
		
		int expectedYear = Integer.parseInt(year.getFirstSelectedOption().getText());//getting  year value from webpage
		
		// getting expected date from WebPage
		String expectedDate = day.getFirstSelectedOption().getText() + "/"+ month.getFirstSelectedOption().getAttribute("value") + "/" + year.getFirstSelectedOption().getText();
		
		// getting actual date from Excel file
		String actualDate = GettingValueFromExcel.getday() + "/" + GettingValueFromExcel.getMonth() + "/"+ GettingValueFromExcel.getYear();
		
		System.out.println("the date of birth you choose "+actualDate);
		
		// checking that the DOB is valid or invalid
		try {
			
			// checking that the actual dOB is equal to expected DOB
			if (LocalDate.of(expectedYear, expectedmonth, expectedday) != null)
				if (expectedDate.equals(actualDate)) {
					System.out.println("test case passed");
				} else {
					System.out.println("test case failed!!!");
				}
		} catch (Exception e) {
			System.out.println("Test Case failed");//when undesired date is entered like 30/02/2003
			
			System.out.println("Verification for DOB=>Invalid date of birth");
		}

	}

}
