package com.homecok.db;
import java.util.ArrayList;

public class Service {

	Dao dao;
	public Service() {
		dao=new Dao();
	}
	public void del(String no) {
		dao.del(no);
	}
	public void write(Dto d) {
		dao.write(d);
	}
	public Dto read(String no) {
		return dao.read(no);
	}
	public ArrayList<Dto> list(){
		return dao.list();
	}
	public void edit(Dto d, String no) {
		dao.edit(d, no);
	}
}
