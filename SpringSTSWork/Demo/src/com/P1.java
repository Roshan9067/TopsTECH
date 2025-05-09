package com;

import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
//		
//		int a = 1; int b = 2;
//		
//		System.out.println(a+" "+b);
//		
//		int c;
//		c=a;
//		a=b;
//		b=c;
//		
//		a=a+b;
//		b=a-b;
//		a=a-b;
//		
//		System.out.println(a+" "+b);
		
		
	int rev = 0;
//		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number:- ");
		int num = sc.nextInt();
		while(num!=0) {
			rev = rev*10 + num%10;
			num = num / 10;
		}
		System.out.println(rev);
		
		
		//StringBuffer sb = new StringBuffer();
		
	}

}

