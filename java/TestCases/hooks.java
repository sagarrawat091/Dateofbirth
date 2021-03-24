package TestCases;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	
	@After("@first")
	public void afterValidation()
	{
		System.out.println("after the first anoataion");
	}
	
	@Before("@first")
	public void beforeValidation()
	{
		System.out.println("before the first anoataion");
	}

}
