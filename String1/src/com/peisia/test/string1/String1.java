package com.peisia.test.string1;

import com.peisia.util.Cw;

public class String1 {
	public static void main(String[] args) {
		p193();
		p199();
	}

	public static void p193() {
		// 책.193 참고
		String cat = "고양이";
		String cat2 = "고양이";//text가 완전히 똑같을 때 메모리 공간을 똑같이 사용함-pm 4:20
		String cat3 = new String("고양이");
		String cat4 = new String("고양이");
		// System.identityHashCode(cat) << 주소 값 출력함.
//		Cw.wn(System.identityHashCode(cat));
//		Cw.wn(System.identityHashCode(cat2));
//		Cw.wn(System.identityHashCode(cat3));
//		Cw.wn(System.identityHashCode(cat4));
		System.out.println(System.identityHashCode(cat));
		System.out.println(System.identityHashCode(cat2));
		System.out.println(System.identityHashCode(cat3));
		System.out.println(System.identityHashCode(cat4));
	}

	public static void p199() {
		// 책.199 예제 참고
//		String s = "abc";
////	Cw.wn(cat.length());

//	Cw.wn(s.charAt(1));	// char > int
//	System.out.println(1);
//	System.out.println(s.charAt(1));

		char c = 'c';
//	System.out.println(c);
		System.out.println((int) c);

		String cat = "고양이";
		System.out.println(String.format("%10s", cat));
	}
}
