package com.sjsu.util;

import java.util.Scanner;

public class Palindrome {
	
	public String palicompare(String r)
	{
		StringBuffer sb=new StringBuffer(r);  // faster for execution and modify later as well whereas String is read only and non-modifiable
		sb.reverse();

		String ne=sb.toString();
		
		if(ne.equals(r))
		{
			System.out.println("Palindrome");
			return ne;
		}
		else
		{
			System.out.println("Not a palindrome");
			return ne;
		}
	}

	private static Scanner s;

	public static void main(String[] args)
	{
		
		s = new Scanner ( System.in);
		System.out.println("enter the string=");
		String str= s.next();
		
		String str1=str.toLowerCase();
		
		Palindrome pl = new Palindrome();
		pl.palicompare(str1);
	}
}

