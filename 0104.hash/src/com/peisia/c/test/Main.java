package com.peisia.c.test;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
//		HashMap <String, String> hs=new HashMap<>();//HashMap<>안에 아무 클래스나 들어가도 됨-am 9:18 앞에 있는 녀석이 키이고 뒤에가 밸류임-am 9:29
//		hs.put("K-1","닭");
//		hs.put("K-2","고양이");
//		hs.put("K-3","사자");
//		hs.clear();
		
        // HashMap 생성 및 요소 추가
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 40);
        map.put("Banana", 10);
        map.put("Cherry", 30);

        // entrySet()을 사용하여 모든 키-값 쌍을 순회하고 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
	}
}
