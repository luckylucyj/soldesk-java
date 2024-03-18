package com.homecok.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.homecok.board.Board;
import com.homecok.db.Dao;
import com.homecok.dto.Dto;

public class DaoBoard extends Dao {

	// 글삭제
	public void del(String category, String no) {
		super.connect();
		String sql = String.format("delete from %s where b_no=%s& b_category like'%s'", Board.TABLE_PS_BOARD_FREE, no,
				category);
		super.update(sql);
		super.close();
	}

	// 글쓰기
	public void insert(Dto d) {
		super.connect();
		String sql = String.format("insert into %s (b_category, b_title, b_id, b_text) values('%s','%s','%s')",
				Board.TABLE_PS_BOARD_FREE, d.category, d.id, d.text);
		super.update(sql);
		super.close();
	}

	// 글읽기
	public Dto selectPost(String category, String no) {
		super.connect();
		Dto post = null;
		try {
			String sql = String.format(
					"select b_category, b_no, b_title, b_id, b_datetime, b_hit, b_text, b_hit, b_text, b_reply_count, b_reply_ori from %s where b_no=%s and b_category like '%s'",
					Board.TABLE_PS_BOARD_FREE, no, category);
			System.out.println("sql" + sql);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(category, rs.getString("B_NO"), rs.getString("B_TITLE"), rs.getString("B_ID"),
					rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return post;
	}

	// 글리스트
	public ArrayList<Dto> selectList(String category, int startIndex) {
		super.connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format("select * from %s where b_category like '%s' limit %d,%d", Board.TABLE_PS_BOARD_FREE,
					category, startIndex, Board.LIST_AMOUNT);
			System.out.println("sql" + sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				posts.add(new Dto(rs.getString("B_CATEGORY"), rs.getString("B_NO"), rs.getString("B_TITLE"),
						rs.getString("B_ID"), rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}

	// 글수정
	public void update(Dto d, String no) {
		super.connect();
		String sql = String.format("update %s set b_title=%s,b_text=%s where b_no=%s", Board.TABLE_PS_BOARD_FREE,
				d.title, d.text, no);
		super.update(sql);
		super.close();
	}

	// 총 글 수 구하기
	public int selectPostCount(String category) {
		int count = 0;
		super.connect();
		try {
			String sql = String.format("select count(*) from %s where b_category like '%s'", Board.TABLE_PS_BOARD_FREE,
					category);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	
	/* 총 글 수 구하기 */
	public int selectSearchPostCount(String category, String word) {
		int count = 0;
		super.connect();	//[고정1,2,3]
		try {
			String sql = String.format(
					"select count(*) from %s where b_title like '%%%s%%' and b_category like '%s'"
					,Board.TABLE_PS_BOARD_FREE,word,category);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}

	public ArrayList<Dto> selectList(String category, int startIndex, String word) {
		super.connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format("select b_category, b_no, b_title, b_id, b_datetime, b_hit, b_text, b_reply_count, b_reply_ori from %s where b_title like '%%%s%%'&b_category like '%s' limit %s,%s", Board.TABLE_PS_BOARD_FREE,word, category,startIndex, Board.LIST_AMOUNT);
			System.out.println("sql:"+sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_TEXT"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI"),
						rs.getString("B_CATEGORY")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}

}
