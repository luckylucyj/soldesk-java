package com.peisia.c.inherit;

public class Character extends GameObj {
	int hp;
//	int attack;

	public Character(String name, int grade, int hp) {
		super(name, grade);// super 함수는 무조건 맨 처음에 와야함.
		this.hp = hp;
	}
}
