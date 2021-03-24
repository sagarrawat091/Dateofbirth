package Pages;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.getValueFromProperties;

public class SetValueOfFormUsingProperties 
{
	static Select day,month,year;
	
	// fill detail in the form
		public void setvalueUsingProperties(WebDriver driver) throws InterruptedException {
			
			//getting WebElement of register button
			WebElement registerbtn = driver.findElement(By.xpath("//a[text()='Create New Account']"));
			
			//click on register button
			registerbtn.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			// getting the firstName WebElement
			WebElement firstName = driver.findElement(By.name("firstname"));
			
			//sending value from properties file
			firstName.sendKeys(getValueFromProperties.getFirstName());
			
			// getting the lastName element 
			WebElement lastName = driver.findElement(By.name("lastname"));
			
			//getting from properties file
			lastName.sendKeys(getValueFromProperties.getLastName()); 
			
			// getting the mobileNumber element
			WebElement mobileNumber = driver.findElement(By.name("reg_email__"));
			
			//getting value from properties file
			mobileNumber.sendKeys(getValueFromProperties.getMobileNumber());
			
			// getting the password element
			WebElement password = driver.findElement(By.name("reg_passwd__"));
			
			//getting value from property file
			password.sendKeys(getValueFromProperties.getPassword());
			 
		}

		public void selectdateUsingProperties(WebDriver driver) 
		{
			// getting the day element and select the day by visible text
			WebElement days = driver.findElement(By.id("day"));
			
			//getting day element
			day = new Select(days);
			
			//getting value from property file
			day.selectByVisibleText(getValueFromProperties.getday());
			
			//getting month element 
			WebElement months = driver.findElement(By.id("month"));
			
			month = new Select(months);
			
			//getting value from property file
			month.selectByValue(getValueFromProperties.getMonth());
			
			// getting the year element
			WebElement Years = driver.findElement(By.id("year"));
			year = new Select(Years);
			
			//getting value from property file
			year.selectByValue(getValueFromProperties.getYear());
			
		}
		//for verification of date of birth
		public void verifyDobUsingPropertiesfile() throws Exception {

			int expectedday = Integer.parseInt(day.getFirstSelectedOption().getText());//getting  year value from Webpage
			
			int expectedmonth = Integer.parseInt(month.getFirstSelectedOption().getAttribute("value"));////getting  month value from Webpage
			
			int expectedYear = Integer.parseInt(year.getFirstSelectedOption().getText());//getting  year value from webpage
			// getting expected date from WebPage
			String expectedDate = day.getFirstSelectedOption().getText() + "/"+ month.getFirstSelectedOption().getAttribute("value") + "/" + year.getFirstSelectedOption().getText();
			// getting actual date from properties file
			String actualDate = getValueFromProperties.getday() + "/" + getValueFromProperties.getMonth() + "/"+ getValueFromProperties.getYear();
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
				System.out.println("Test Case failed");
				System.out.println("Verification for DOB=>Invalid date of birth");
			}

		}

}
