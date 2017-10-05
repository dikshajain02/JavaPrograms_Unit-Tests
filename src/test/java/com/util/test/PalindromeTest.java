package com.util.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sjsu.util.Palindrome;

import org.testng.Assert;
import org.testng.Reporter;


//Testing with Hard-coding the test data

@Test(groups="{sanity,regression}")
public class PalindromeTest 
{

	@DataProvider(name = "test1")
	public Object[][] createData() 
	{
		return new Object[][] {
			{"madam", "madam" } ,
			{ "", ""} ,
			{ "1234321","1234321"},
			{"*%#^#%*","*%#^#%*"},
			{"a","a"},
			{"0201dad1020","0201dad1020"},
			{null,""},
			{"diksha","ahskid"}
		};

	}

	@Test (dataProvider = "test1")
	public void validStringTest(String input, String expectedOutput)
	{
		try
		{
			Reporter.log("\nBegin validStringTest", true);

			//call to developers API
			Palindrome pali = new Palindrome();
			String out = pali.palicompare(input);

			//Validations
			Assert.assertEquals(out, expectedOutput);

			Reporter.log("Complete validStringTest" , true);
		}
		catch(NullPointerException e)
		{
			System.out.print("NullPointerException Caught: String cannot be null");
		}
	}

}



