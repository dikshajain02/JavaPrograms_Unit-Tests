package com.sjsu.util;

import java.util.Scanner;

public class ReverseString 
{
	private static Scanner scan;

	public String Reverse (String org)
	{	
		int i;
		int l = org.length();
		String rev="";
		
		if(l==1)
		{
			
			System.out.println("String after reversing =" +org);
			return org;
		}
		
		else
		{
			for(i=l-1; i>=0; i--)
			{
				rev = rev+ org.charAt(i);
			}
			System.out.println("Reverse String =" +rev);
			return rev;
		}
	}
	
	public static void main(String[] args)
	{
		String original;
		scan = new Scanner(System.in);
		System.out.println("Enter The string=");
		original = scan.nextLine();
		
		ReverseString rev = new ReverseString();
		rev.Reverse(original);
	}
	
}