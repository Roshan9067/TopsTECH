package com;
public class Palindrome {
	public static void main(String[] args) {
		
		int num=10;
		int count = 0;
		
		if(num > 0) {
			
			for(int i = 1; i<=num;i++) {
				if(num%i==0)
				count++;
			}
			
			if(count==2) {
				System.out.println("prime");
			}else {
				System.out.println("not");
			}
			
			
		}else {
			System.out.println("not");
		}
		
	}

}

