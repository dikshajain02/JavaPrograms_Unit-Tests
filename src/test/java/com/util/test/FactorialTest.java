package com.util.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sjsu.util.Factorial;

import org.testng.Reporter;
import org.testng.Assert;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


//Testing through HashMap- Data Provider

@Test(groups="{smoke,regression}")
public class FactorialTest {

	//method to read file and put it in HashMap
	public HashMap<Integer, Integer> readfile(String filename) 
	{
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		try
		{
			Scanner scan = new Scanner(new File(filename));
			String Str;
			while(scan.hasNext())
			{
				Str = scan.nextLine();
				String[] keyvalue = Str.split(":");
				hm.put((Integer.parseInt(keyvalue[0])), Integer.parseInt(keyvalue[1]));
			}
			scan.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		//System.out.println(hm);
		return hm;	
	}

	//method to convert Map to Object Array
	@DataProvider(name = "test1")
	public Object[][] convert_MapToArray() 
	{
		FactorialTest fact = new FactorialTest();
		HashMap<Integer, Integer> map=fact.readfile("src\\test\\resources\\TestData.txt");
		Object[][] arr = new Object[map.size()][2]; 
		Set entries = map.entrySet(); 
		Iterator entriesIterator = entries.iterator(); 
		int i = 0; 
		while(entriesIterator.hasNext())
		{ 
			Map.Entry mapping = (Map.Entry) entriesIterator.next(); 
			arr[i][0] = mapping.getKey(); 
			arr[i][1] = mapping.getValue(); 
			i++; 
		}
		return arr;

	}

	@Test (dataProvider = "test1")
	public void validNumTest(int input, int expectedOutput ) throws NullPointerException, NumberFormatException
	{
		try
		{
			Reporter.log("\nBegin validNumTest", true);

			//call to developers API
			Factorial f = new Factorial();
			int out = f.findFact(input);

			//Validations
			Assert.assertEquals(out, expectedOutput);
			Reporter.log("Complete validNumTest" , true);
		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException Caught: String cannot be null");
		}	
		catch(NumberFormatException e)
		{
			System.out.println("NumberFormatException Caught: Input is not the Integer type");
		}
	}
}




