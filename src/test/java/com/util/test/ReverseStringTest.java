package com.util.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.sjsu.util.ReverseString;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.Assert;
import org.testng.Reporter;


//Testing with data from CSV file to data provider
@Test(groups="regression")
public class ReverseStringTest {

	//method to read data from file
	@DataProvider(name="CSVtest")
	public Object[][] CSVReadData() {

		CSVReader reader;
		Map<String,String> hm = new HashMap<String,String>();

		Object data[][]= new Object[6][2];
		int i=0;
		try {
			reader = new CSVReader(new FileReader("src\\test\\resources\\TestReverseData.csv"));
			String [] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				// nextLine[] is an array of values from the line        	
				hm.put(nextLine[0].trim(), nextLine[1].trim());
			}

			for (Entry<String, String> mapEntry : hm.entrySet()) {
				data[i][0] = mapEntry.getKey();
				data[i][1] = mapEntry.getValue();
				i++;
			}

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return data;
	}


	@Test (dataProvider ="CSVtest")
	public void validStringTest(String input, String expectedOutput )
	{
		try
		{
			Reporter.log("\nBegin validStringTest", true);

			//call to developers API
			ReverseString rev = new ReverseString();
			String out = rev.Reverse(input);

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


