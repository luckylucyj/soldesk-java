package com.peisia.rpggame;

public class Monster {
	String name;
	int hp;
	int attack;
	String race;

	Monster(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		System.out.println(this.name + " 캐릭터가 생성 되었습니다.");
	}

	void info() {
		System.out.println("이름: "+this.name+"["+this.hp+"]");
	}

}
