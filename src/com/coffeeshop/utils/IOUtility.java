package com.coffeeshop.utils;
import java.util.Scanner;
public class IOUtility {
	static Scanner s = new Scanner(System.in);
	public static void displayOptions() {
		System.out.println("1.Display Menu\n2.Order dish\n3.Exit.\nEnter your choice");
	}
	
	public static int getIntegerInput() {
		return s.nextInt();
	}
	public static String getStringInput() {
		return s.next();
	}
}
