package com.peisia.c.board.data;

import java.time.LocalDate;

import com.peisia.util.Cw;

public class Post {
	static public int no = 0;
	public int instanceNo = 0;
	public String title;
	public String content;
	public String writer;
	public int hit;
	public String date;
	public Post(String title, String content, String writer, int hit, int hits) {
		no=no+1;
		instanceNo=no;
		this.title=title;
		this.content=content;
		this.writer=writer;
		this.hit=hit;
		LocalDate now=LocalDate.now();
		date=now.toString();
//		this.hits=hits;
	}
	public void infoForList() {
		Cw.w("글번호:"+instanceNo);
		Cw.w("글제목:"+title);
		Cw.w("작성자:"+writer);
		Cw.w("조회수:"+hit);
		Cw.wn("작성일:"+date);
	}
	public void infoForRead() {
		Cw.w("글제목:"+title);
		Cw.w("작성자:"+writer);
		
		Cw.w("조회수:"+hit);
		Cw.wn("작성일:"+date);
		Cw.wn("글내용:"+content);
	}

    // 히트 수 증가 메서드
//    public void increaseHits() {
//        this.hits++;
//    }
//
//    // getter 메서드
//    public int getHits(hits) {
//        return this.hits;
//    }
}
