package com.peisia.c.kiosk;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Production> basket=new ArrayList<Production>();
		System.out.println("============================================");
		System.out.println("================= 고양이카페       ===========");
		System.out.println("============================================");
		//ctrl + shift + o(영문자). 자동 임포트.
		Production p1=new Production("치즈 케익", 6000);
		Production p2=new Production("티라미슈", 7000);
		Production p3=new Production("샌드위치",5000);
		
		Scanner sc = new Scanner(System.in);
		String cmd;

		loop_a:
		while(true) {
			System.out.print("명령:[1.음료/2.디저트/e.종료]");
			cmd = sc.next();
			switch(cmd) {
			case "1":
				System.out.println("==================================");
				System.out.println("============= 음료 리스트    =======");
				System.out.println("==================================");
//
//				p1.info();
//				p2.info();
				loop_b:
				while(true) {
					System.out.print("명령:[1.아아/2.뜨아/x.이전메뉴]");
					cmd = sc.next();					
					switch(cmd) {
					case "1":
						System.out.println("아아가 1개 선택됐습니다.");
						break;
					case "2":
						System.out.println("뜨아가 1개 선택됐습니다.");
						break;
					case "x":
						break loop_b;
					}
				}
				
				break;
			case "2":
				System.out.println("==================================");
				System.out.println("============= 디저트 리스트    =======");
				System.out.println("==================================");
				loop_c:
					while(true) {
					System.out.println("명령:[1.치즈케익/2.티라미슈/3.샌드위치/e.이전메뉴]");
					cmd=sc.next();
					switch(cmd) {
					case "1":
						System.out.println("치즈케익이 선택됐습니다.");
						basket.add(p1);
						break;
					case "2":
						System.out.println("티라미슈가 선택됐습니다");
						basket.add(p2);
						break;
						
					case "3":
						System.out.println("샌드위치가 선택되었습니다.");
						basket.add(p3);
						break;
					case"e":
						break loop_c;
					}
					
				}
//				System.out.println(p1.price+p2.price);
				break;
			
				
			case "e":
				System.out.println("프로그램 종료");
				
				int count=basket.size();
				System.out.println("장바구니에 담긴 상품 갯수:"+count);
				
				int sum=0;
				for(int i=0; i<count;i++) {
					sum=sum+basket.get(i).price;
				}
				System.out.println("계산하신 금액은 :"+sum+"원 입니다");
				break loop_a;
			}
		}
		System.out.println("프로그램 종료");
	}

}

