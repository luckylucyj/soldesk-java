package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.GuestDto;

public interface GuestMapper {
	public ArrayList<GuestDto> getList(int limitIndex);
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto dto);
	public void modify(GuestDto dto);
	 public int getTotalPage(); // 총 페이지 수를 반환하는 메서드
}
