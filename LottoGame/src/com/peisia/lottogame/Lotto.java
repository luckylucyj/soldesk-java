package com.peisia.lottogame;

import java.util.Scanner;

public class Lotto {
	
	public void run() {
		int x[]= {1,2};
		int p[]= {1,2,3,4,5,6};
		int r[]=new int[6];
		r[0]=(int)(Math.random()*45+1);
//		r[1]=(int)(Math.random()*45+1);
//		r[2]=(int)(Math.random()*45+1);
//		r[3]=(int)(Math.random()*45+1);
//		r[4]=(int)(Math.random()*45+1);
//		r[5]=(int)(Math.random()*45+1);
		System.out.println("당첨번호 공개");
		while(true) {
			r[1]=(int)(Math.random()*45+1);
			if(r[1]!=r[0]) {
				break;
			}
		}
		while(true) {
			r[2]=(int)(Math.random()*45+1);
			if(r[2]!=r[0]&&r[2]!=r[1]) {
				break;
			}
		}
		while(true) {
			r[3]=(int)(Math.random()*45+1);
			if(r[3]!=r[0]&&r[3]!=r[1]&&r[3]!=r[2]) {
				break;
			}
		}
		while(true) {
			r[4]=(int)(Math.random()*45+1);
			if(r[4]!=r[0]&&r[4]!=r[1]&&r[4]!=r[2]&&r[4]!=r[3]) {
				break;
			}
		}
		while(true) {
			r[5]=(int)(Math.random()*45+1);
			if(r[5]!=r[0]&&r[5]!=r[1]&&r[5]!=r[2]&&r[5]!=r[3]&&r[5]!=r[4]) {
				break;
			}
		}

		System.out.println(r[0]);
		System.out.println(r[1]);
		System.out.println(r[2]);
		System.out.println(r[3]);
		System.out.println(r[4]);
		System.out.println(r[5]);
		
		int win=0;
		
//		if(p[0]==r[0]){
//			win++;
//		}
//		if(p[0]==r[1]){
//			win++;
//		}
//		if(p[0]==r[2]){
//			win++;
//		}
//		if(p[0]==r[3]){
//			win++;
//		}
//		if(p[0]==r[4]){
//			win++;
//		}
//		if(p[1]==r[0]){
//			win++;
//		}
//		if(p[1]==r[1]){
//			win++;
//		}
//		if(p[1]==r[2]){
//			win++;
//		}
//		if(p[1]==r[3]){
//			win++;
//		}
//		if(p[1]==r[4]){
//			win++;
//		}
//		if(p[1]==r[5]){
//			win++;
//		}
//		if(p[2]==r[0]){
//			win++;
//		}
//		if(p[2]==r[1]){
//			win++;
//		}
//		if(p[2]==r[2]){
//			win++;
//		}
//		if(p[2]==r[3]){
//			win++;
//		}
//		if(p[2]==r[4]){
//			win++;
//		}
//		if(p[2]==r[5]){
//			win++;
//		}
//		if(p[3]==r[0]){
//			win++;
//		}
//		if(p[3]==r[1]){
//			win++;
//		}
//		if(p[3]==r[2]){
//			win++;
//		}
//		if(p[3]==r[3]){
//			win++;
//		}
//		if(p[3]==r[4]){
//			win++;
//		}
//		if(p[3]==r[5]){
//			win++;
//		}
//		if(p[4]==r[0]){
//			win++;
//		}
//		if(p[4]==r[1]){
//			win++;
//		}
//		if(p[4]==r[2]){
//			win++;
//		}
//		if(p[4]==r[3]){
//			win++;
//		}
//		if(p[4]==r[4]){
//			win++;
//		}
//		if(p[4]==r[5]){
//			win++;
//		}
//		if(p[5]==r[0]){
//			win++;
//		}
//		if(p[5]==r[1]){
//			win++;
//		}
//		if(p[5]==r[2]){
//			win++;
//		}
//		if(p[5]==r[3]){
//			win++;
//		}
//		if(p[5]==r[4]){
//			win++;
//		}
//		if(p[5]==r[5]){
//			win++;
//		}
		
		for(int i=0; i<p.length; i++) {
			for(int j=0; j<r.length; j++) {
				if(p[i]==r[j]) {
					win++;
				}
			}
		}
		System.out.println("당첨 갯수는:"+win);
	}
}
