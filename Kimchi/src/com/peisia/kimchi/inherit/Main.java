package com.peisia.kimchi.inherit;

public class Main {
	public static void main(String[] args) {
		Son son = new Son();
		son.kimchi();
		
		Father f;
		f=(Father)son;
		son.kimchi();
	}
}
