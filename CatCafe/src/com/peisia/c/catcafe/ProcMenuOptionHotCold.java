package com.peisia.c.catcafe;

import com.peisia.util.Cw;

public class ProcMenuOptionHotCold {
	public static void run() {
		loop:while(true) {
			switch(KioskObj.cmd) {
			case "1":
				Cw.wn("hot 선택됨. 이전 메뉴로 이동");
				KioskObj.basket.add(new Order(KioskObj.products.get(0),1));
			case "2":
				Cw.wn("hot 선택됨. 이전 메뉴로 이동");
				KioskObj.basket.add(new Order(KioskObj.products.get(0),2));				
				break loop;
			case "x":
				Cw.wn("이전 메뉴 이동");
				break loop;
			}
		}

	}
}
