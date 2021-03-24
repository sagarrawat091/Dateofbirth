package utilities;

import java.util.Properties;

public class getValueFromProperties
{
	static Properties prop=readFromProperties.readproperties();
	//getting url value form the property file
	public static String geturl()
	{
		return prop.getProperty("url");
		
	}
	//getting firstname value form the property file 
	public static String getFirstName()
	{
		return prop.getProperty("firstName");
	}
	//getting  lastname form the property file
	public static String getLastName()
	{
		return prop.getProperty("lastName");
	}
	//getting mobile number value form the property file
	public static String getMobileNumber()
	{
		return prop.getProperty("mobileNumber");
	}
	//getting password value form the property file
	public static String getPassword()
	{
		return prop.getProperty("password");
	}
	//getting day value form the property file
	public static String getday()
	{
		return prop.getProperty("day");
	}
	//getting month value form the property file
	public static String getMonth()
	{
		return (prop.getProperty("month"));
	}
	//getting year value form the property file
	public static String getYear()
	{
		return prop.getProperty("year");
	}


}
