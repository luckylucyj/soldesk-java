package com.peisia.c.kiosk;

//public class Production {
//
//	//변수들
//	String name;
//	int price;
//	
//	//오버로딩 : 함수이름이 같지만 매개변수의 갯수나 형만 달리해서 중복 추가하는 것.
//	
//	//생성자함수 - 그중에 매개변수 2개짜리
//	Production( String name,int price){
//		this.name = name;
//		this.price = price;
//	}
//
//	
//	//함수들
////	public static void main(String[] args) {
////		
////	}
//	
//	public void info() {
//		System.out.println(name+" 가격:"+price+"원");
//	}
//	
//}

public class Production{
	String name;
	int price;
	Production(String name,int price){
		this.name=name;
		this.price=price;
	}
	
	public void info() {
		System.out.println(this.name+" 을 주문하셨습니다. 가격은"+this.price+" 입니다.");
	}
}

