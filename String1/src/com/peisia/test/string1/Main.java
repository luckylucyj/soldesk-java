package com.peisia.test.string1;

public class Main {
	public static void main(String[] args) {

		String cat="고양이";
		String cat1="고양이";
		
		if(cat==cat1) {
			System.out.println("같음");
		}
		
		String dog =new String("개");
		String dog1 =new String("개");
		
		if(dog==dog1) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		
		
		if(dog.equals(dog1)) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
	}
}
