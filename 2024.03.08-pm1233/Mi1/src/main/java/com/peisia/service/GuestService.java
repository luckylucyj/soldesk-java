package com.peisia.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.peisia.dto.GuestDto;


public interface GuestService {
	public ArrayList<GuestDto> getList(Model m,int currentPage);
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
	public int getTotalPage(); // 총 페이지 수를 반환하는 메서드
}
