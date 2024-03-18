package com.peisia.c.javatest;

public class JavaTest {
	public static void main(String[] args) {

		Dog duri = new Dog();// 클래스형 변수를 선언할 때 var, let이 아닌 클래스명으로 해야 한다. -am 9:41

		duri.name = "두리";
		duri.age = 3;
		duri.info();
	}
}
