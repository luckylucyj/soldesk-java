package com.peisia.c.data;

import java.time.LocalDate;

import com.peisia.util.Cw;

public class Post {
	public String title;
	public String content;
	public String writer;
	public int num;
	public int hit;
	public String date;
	
	public Post(String title, String content, String writer, int hit ) {
		num=num+1;
		int instanceNO=num;
		this.title=title;
		this.content=content;
		this.writer=writer;
		this.hit=hit;
		LocalDate now=LocalDate.now();
		date=now.toString();
	}
	public void info() {
		Cw.w("신청글 제목:"+title);
		
	}
}
