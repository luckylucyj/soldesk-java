package com.peisia.c.test;
import java.util.HashSet;
import java.util.Iterator;

public class Hash {
	HashSet<String> hs = new HashSet<>();
	hs.add("개");
	hs.add("고양이");
	hs.add("고양이");
//	hs.remove("고양이");
//	hs.clear();
	
	if(hs.isEmpty()) {
		System.out.println("데이터 없음");
	} else {
		System.out.println("데이터 있음");
	}
	if(hs.contains("고양이")) {
		System.out.println("이 안에 고양이 있다");
	}
	System.out.println(hs.size());
	System.out.println("======= 다 출력(순서는 보장 안됨) =======");
	for(String s:hs) {
		System.out.println(s);
	}
	
	//조금 어렵게 꺼내기
	System.out.println("======= 조금 어렵게 꺼내기(순서는 보장 안됨) =======");
	Iterator<String> it = hs.iterator();
	while(it.hasNext()) {
	    String value = it.next();
	    System.out.println(value);
	}
}
