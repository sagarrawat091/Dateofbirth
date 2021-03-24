package TestCases;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import Pages.SetValueOfFormUsingExcel;
import Pages.SetValueOfFormUsingProperties;
import utilities.DriverSetup;
import utilities.GettingValueFromExcel;
import utilities.ScreenShot;
import utilities.getValueFromProperties;

public class SelectFromDropDown {

	static WebDriver driver;
	static String baseUrl,browser;
	static int choice;
	getValueFromProperties prop1 = new getValueFromProperties();

	// getting WebDriver
	public WebDriver setDriver(String browser) {
		System.out.println("hello world0");
		driver = DriverSetup.getWebDriver(browser);
		return driver;
	}

	// getting and navigate Url
	public void navigateUrl(WebDriver driver, String url) {
		baseUrl = url; //getting url
		driver.get(baseUrl);
	}
	
	//save output to output.txt
	public void SaveConsoleOutputTofile() throws FileNotFoundException {
		PrintStream outputfile = new PrintStream(new FileOutputStream("C:\\Users\\logan\\eclipse-workspace\\FBDobFromDropDown\\Program_Output\\OutPut.txt"));
		System.setOut(outputfile);
		System.out.println("you choose "+browser+" browser");
		if(choice==1)
		{
			System.out.println("You choose property file");
		}
		else
		{
			System.out.println("You choose excel file");
		}
		System.out.println("Screenshots  before, after and main section are captured and stored in Program_Output folder");
		System.out.println("All the testcase ouptut is redirected to Output.txt file inside Program_Output folder");
	}
		

	// close the browser
	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) throws Exception {

		SelectFromDropDown obj = new SelectFromDropDown(); // creating the object of selectfromdropdown
		
		System.out.println("Enter the Browser Name");

		Scanner sc = new Scanner(System.in); // creating the object of scanner class
		browser= sc.nextLine();
		

		System.out.println("press 1 for properites file and press 2 for excel file");

		choice = sc.nextInt(); // getting the choices of user		

		driver = obj.setDriver(browser);// calling driver
		
		obj.SaveConsoleOutputTofile(); //calling saveconsole method
		
		if (choice == 1) {
			
			// navigate Url
			obj.navigateUrl(driver, getValueFromProperties.geturl());

			// maximize the window
			driver.manage().window().maximize();

			// implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// taking screenshot when page is loaded
			ScreenShot.takingScreenShot(driver, "before");

			// filling the form using properties file
			// creating the object SetValueOfFormUsingProperties class
			SetValueOfFormUsingProperties pobj = new SetValueOfFormUsingProperties();
			
			// set the value using properties
			pobj.setvalueUsingProperties(driver);
			
			// select the date of birth
			pobj.selectdateUsingProperties(driver);

			// taking screenshot after filling all details
			ScreenShot.takingScreenShot(driver, "After");

			// taking screenshot of the main section
			ScreenShot.sectionScreenShot(driver);

			// verify using property file
			pobj.verifyDobUsingPropertiesfile();
		}
		else
		{
			
			// Initiate the excel sheet
			GettingValueFromExcel.readExcel();

			// navigate url
			obj.navigateUrl(driver, getValueFromProperties.geturl());

			// maximize the window
			driver.manage().window().maximize();

			// implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// taking screenshot when page is loaded
			ScreenShot.takingScreenShot(driver, "before");

			// filling the form using excel file
			// creating the object SetValueOfFormUsingExcel class
			SetValueOfFormUsingExcel excelobj = new SetValueOfFormUsingExcel();
			
			// enter the details in form using Excel file
			excelobj.setvalueUsingExcelFile(driver);
			
			// select the date of birth using excel file
			excelobj.selectdateUsingExcelFile(driver);

			// taking screenshot after filling all details
			ScreenShot.takingScreenShot(driver, "After");

			// taking screenshot of the main section
			ScreenShot.sectionScreenShot(driver);
			
			// verify using excel file
			excelobj.verifyDobUsingExcel();
		}
		

		// close the browser
		obj.closeBrowser();

		// close scanner object
		sc.close();
		
		
	}

}
