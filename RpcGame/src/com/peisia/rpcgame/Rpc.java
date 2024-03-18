package com.peisia.rpcgame;

import java.util.Scanner;

public class Rpc {
	public static void main(String[] args) {

		String userRpc = "";

		int r = (int) (Math.random() * 3 + 1);
		String result = "";

		cat:
		while (true) {
			System.out.println("가위바위보 중에 하나 입력해주세요. [종료=x] ");
			Scanner sc = new Scanner(System.in);
			userRpc = sc.next();
			switch (userRpc) {
			case "가위":
				switch (r) {
				case 1:
					result = "비김";
					break;
				case 2:
					result = "짐";
					break;
				case 3:
					result = "이김";
					break;
				}
				break;

			case "바위":
				switch (r) {
				case 1:
					result="이김";
					break;
				case 2: 
					result="비김";
					break;
				case 3: 
					result="짐";
					break;
				}
				break;
				
			case "보":
				switch(r) {
				case 1:
					result="짐";
					break;
				case 2: 
					result="이김";
					break;
				case 3: 
					result="비김";
					break;
				}
				break;
			case "x":
				break cat;
				
			}//rpc 설정 닫는 태그
			System.out.println("결과는: "+ result);
		}//무한 반복 게임 설정 닫는 태그
		System.out.println("프로그램 종료");
	}
}