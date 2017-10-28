package com.org.assign;

import java.util.Scanner;

public class AddAB {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		if((a>=0 && a<=9) && (b>=0 && b<=9)){
			System.out.println(a + b);
		}else{
			System.out.println("The input range of a & b is between 0 to 9");
		}
		s.close();
	}
}
