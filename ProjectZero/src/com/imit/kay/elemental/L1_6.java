package com.imit.kay.elemental;

import java.util.Scanner;

public class L1_6 {

	static double a1, b1, c1, a2, b2, c2;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		System.out.println("Pls, input array of coeffs in format \n a1 b1 c1 \n a2 b2 c2");
		a1=sc.nextDouble();
		b1=sc.nextDouble();
		c1=sc.nextDouble();
		a2=sc.nextDouble();
		b2=sc.nextDouble();
		c2=sc.nextDouble();

		if(a1==0 && b1==0 && c1!=0 || a2==0 && b2==0 && c2!=0)
			System.out.println("Incorrect conditions");
		else if(a1==0 && b1==0 || a2==0 && b2==0)
			System.out.println("Infinity solves count");
		else if(a1==0 && a2==0)
			XAnySolve();
		else if(b1==0 && b2==0)
			YAnySolve();
		else if(a1==0)
			A1NullSolve();
		else if(a2==0)
			A2NullSolve();
		else if(b1==0)
			B1NullSolve();
		else if(b2==0)
			B2NullSolve();
		else if(b1*a2-a1*b2==0)
			System.out.println("Infinity solves count");	
		else
			GeneralSolve();
		System.out.println("");
		}
		
	}
	
	static void GeneralSolve()
	{
		double y=(a1*c2-c1*a2)/(b1*a2-a1*b2);
		double x=-(c1+b1*y)/a1;
		System.out.format("x: %.2f \ny: %.2f",x, y);
	}
	
	static void A1NullSolve()
	{
		double y=-c1/b1;
		double x=-(c2+b2*y)/a2;
		System.out.format("x: %.2f \ny: %.2f",x, y);
	}
	
	static void A2NullSolve()
	{
		double y=-c2/b2;
		double x=-(c1+b1*y)/a1;
		System.out.format("x: %.2f \ny: %.2f",x, y);
	}
	
	static void B1NullSolve()
	{
		double x=-c1/a1;
		double y=-(c2+a2*x)/b2;
		System.out.format("x: %.2f \ny: %.2f",x, y);
	}
	
	static void B2NullSolve()
	{
		double x=-c2/a2;
		double y=-(c1+a1*x)/b1;
		System.out.format("x: %.2f \ny: %.2f",x, y);
	}

	static void XAnySolve()
	{
		double y=-c1/b1;
		if(y!=-c2/b2)
			System.out.println("Incorrect conditions");
		else
			System.out.format("x: any solve \ny: %.2f",y);
	}
	
	static void YAnySolve()
	{
		double x=-c1/a1;
		if(x!=-c2/a2)
			System.out.println("Incorrect conditions");
		else
			System.out.format("x: %.2f \ny: any solve", x);
	}
	

}
