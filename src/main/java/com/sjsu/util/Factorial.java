package com.sjsu.util;

import java.util.Scanner;

public class Factorial 
{
	private static Scanner scan;

	public int findFact(int n)
	{
		int fact=1;
		for(int i=n;i>1;i--)
		{
			fact=fact*i;
		}
		return fact;
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the number=");
		scan = new Scanner(System.in);
		int x = scan.nextInt();

		Factorial f = new Factorial();
		int factorial= f.findFact(x);
		System.out.println(factorial);
	}

}
