package com.peisia.c.catcafe;

import java.util.ArrayList;
import java.util.Scanner;

import com.peisia.util.Cw;

public class Kiosk {
	ProcMenuDrink procMenuDrink = new ProcMenuDrink();
	
	Product p4;
	public static ArrayList<Product> basket = new ArrayList<Product>();  
	// 자동임포트 단축키: ctrl+shift+o(영문자O)
	public static Scanner sc = new Scanner(System.in);
	public static Product p1 = new Product("아아", 1000);
	public static Product p2 = new Product("뜨아", 1500);
	public static Product p3 = new Product("오렌지쥬스", 2000);
	
	void x() {
		p4=new Product("마카롱",1500);
	}

	public static String cmd;

	public static String next() {
		
		return sc.next();
	}
	
	void run() {
		Disp.title();
		xx: while (true) {
			System.out.print("명령 입력[1.음료선택/2.디저트선택/e.프로그램종료]:");
			cmd = sc.next();
			switch (cmd) {
			case "1":
				ProcMenuDrink.run();
				break;

			case "2":
				ProcMenuDessert.run();
				break;
				
			case "e":
				System.out.println("프로그램종료");

				int count = basket.size();
				System.out.println("장바구니에 담긴 상품 갯수:" + count);

				int sum = 0;
//				for (int i = 0; i < basket.size(); i = i + 1) {
//					sum = sum + basket.get(i).price;
//				}-pm 4:20
				for(Product x:basket) {
					sum=sum+x.price;
				}
				System.out.println("계산하실 금액은 :" + sum + "원 입니다.");

				break xx;
			}
		}
	}
}
