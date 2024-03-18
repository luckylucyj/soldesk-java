package com.peisia.c.upgradefor;

import java.util.ArrayList;

public class AnimalTwo {
	public static void main(String[] args) {
//		ArrayList<String> animalt=new ArrayList<>();
//		animalt.add("고양이");
//		animalt.add("개");
//		animalt.add("토끼");
//		 
//		for(int i=0; i<animalt.size(); i++) {
//			System.out.println(animalt.get(i));
//		}
//		
//		for(String x:animalt) {
//			System.out.println(x);
//		}
//		
//		int a[]= {1,2,3};
//		
//		Cat cat1=new Cat("키티",5);
//		Cat cat2=new Cat("키티",5);
//		
//		ArrayList<Cat>cats=new ArrayList<>();
//		cats.add(cat1);
//		cats.add(cat2);
//		for(Cat x:cats) {
//			System.out.println("고양이 이름:"+x.name);
//			System.out.println("고양이 나이:"+x.age);
//		}
		
		ArrayList<String>animalt=new ArrayList<>();
		animalt.add("고양이");
		animalt.add("개");
		animalt.add("토끼");
		
		for(int i=0; i<animalt.size();i++) {
			System.out.println(animalt.get(i));
//			animalt.get(i);
		}
		
		for(String x:animalt) {
			System.out.println(x);
		}
		
		int a[]= {1,2,3};
		for(int n:a) {
			System.out.println(n);
		}
	}
}
