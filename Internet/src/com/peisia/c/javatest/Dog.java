package com.peisia.c.javatest;

public class Dog {
	String name; //문자열 변수는 클래스 String형으로 지정해야함.
	int age;//신기하게 int는 대문자가 아님. 소문자로 시작되는 형들로 숫자형 변수는 이렇게
	long id;// 숫자형 변수인데 int보다 많은 큰 수를 담을 수 있음.
	float inch=3.5f;//숫자는 숫자인데 실수(쩜 몇 하는 수들) 변수. 자료갑에 f붙임 주의
	double pi=3.145342;//숫자는 숫자인데 실수(쩜 몇 하는 수들) 변수. 더 큰 수 담을 수 있음.
	boolean isMine=false; //자바도 불린형 있음. 똑같음. 단 종류가 명시되야 함.
	void info() {
		String s="고양이 이름은 "+name+"이고 나이는 "+age+" 살 이에용";
		System.out.println(s);
	}
}
