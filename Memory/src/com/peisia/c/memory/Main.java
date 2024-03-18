package com.peisia.c.memory;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
//		int n = 10;
//		 
		Cat kitty = new Cat("kitty");
		
		Cat yaongi = new Cat("범블비");

		kitty.run();
		kitty.name = "개냥이";

		Cat x;
		x = kitty;

		x.name = "야옹이";

		ArrayList<Cat> cats = new  ArrayList<Cat>();
		cats.add(x);
		cats.add(kitty);
		cats.add(yaongi);
		cats.get(0);
		cats.get(1);
		cats.get(2).run();
	}
}
