package com.imit.kay.elemental;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class L1_7 {
	/*100 1e-9
	* -1 1e-9*/
	public static void main(String[] args) {
		/* 7.	7. Напишите программу вычисления функции exp(x) разложением в ряд Тейлора с заданной точностью.
		Программа должна суммировать члены ряда до тех пор, пока модуль очередного члена ряда не станет меньше точности..*/
		Scanner sc=new Scanner(System.in);
		double x=sc.nextDouble();
		double precision=sc.nextDouble();
		
		System.out.println(Exp(x, precision).toString());
	}
//http://www.java-study.ru/87-java-big-chisla.html - about BigDecimal and BigInteger java
	static BigDecimal Exp(double x, double precison)
	{
		if(x<0)
			return (new BigDecimal(1)).divide(Exp(-x, precison),25, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal e=new BigDecimal(0);
		BigDecimal v=new BigDecimal(1);
		BigDecimal bigPrecision=new BigDecimal(precison);
		BigDecimal bigX=new BigDecimal(x);
		for(int i=1;v.compareTo(bigPrecision)>=0;i++)
		{
			e=e.add(v);
			BigDecimal xPow=new BigDecimal(1);
			for(int j=0;j<i;j++)
				xPow=xPow.multiply(bigX);
			BigDecimal fact=new BigDecimal(Fact(BigInteger.valueOf(i)));
			v=xPow.divide(fact, 25, BigDecimal.ROUND_HALF_UP);			
		}		
		return e;
	}
	
	static BigInteger Fact(BigInteger i)
	{
		if(i.compareTo(BigInteger.valueOf(1))==0)
			return i;
		return i.multiply(Fact(i.subtract(BigInteger.valueOf(1))));
	}
}
