package com.peisia.c.catcafe;

import java.util.ArrayList;
import java.util.Scanner;

public class KioskObj {
	public static ArrayList <Order> basket=new ArrayList<>();
	public static ArrayList <Product> products=new ArrayList<>();
	public static Scanner sc=new Scanner(System.in);
	public static String cmd=sc.next();
	
	public static void productLoad() {
		products.add(new Product("커피",1000));
		products.add(new Product("오렌지 쥬스",2000));
		products.add(new Product("마카롱",3000));
	}
	
} 
