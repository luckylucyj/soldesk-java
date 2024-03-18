package com.peisia.board.data;

import java.time.LocalDate;

public class Post {
	public String title;
	public String content;
	public String author;
	public static int no=0;
	public int instanceNo=0;
	public int hit;
	public String date;
	
	public void Post(String title, String content, String author, int hit) {
		no=no+1;
		instanceNo=no;
		this.title=title;
		this.content=content;
		this.author=author;
		this.hit=hit;
		LocalDate now=LocalDate.now();
		date=now.toString();
	}
	public void infoForList() {
		Cw.w("글번호:"+instancoNo);
	}
}
