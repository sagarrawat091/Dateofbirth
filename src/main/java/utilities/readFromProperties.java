package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readFromProperties
{
	public static Properties readproperties()
	{
		FileInputStream fis = null;
		String pathofproperty = System.getProperty("user.dir")+"\\Resources\\data.properties";
		try
		{
			fis = new FileInputStream(pathofproperty);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//initiating the property object
		Properties prop=new Properties();
		try
		{
			//loading
			prop.load(fis);
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//return the property object
		return prop;
	}

	
}
