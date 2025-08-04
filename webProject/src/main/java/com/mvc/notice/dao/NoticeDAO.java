package com.mvc.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mvc.common.util.DBUtil.getConnection;

import com.mvc.notice.vo.NoticeVO;

public class NoticeDAO {
	private static NoticeDAO instance =null;
	
	public static NoticeDAO getInstance() {	//BoardDAO의 인스턴스는 BoardDAO.getInstance()
		if(instance==null) {
			instance= new NoticeDAO();
		}
		return instance;
	}
	
	private NoticeDAO() {}	// 다른 클래스 new BoardDAO(); X
	
	private NoticeVO addNotice(ResultSet rs) throws SQLException {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNoticeNo(rs.getInt("notice_no"));
		noticeVO.setTitle(rs.getString("title"));
		noticeVO.setContent(rs.getString("content"));
		noticeVO.setWriter(rs.getString("writer"));
		noticeVO.setWriteday(rs.getString("writeday"));
		noticeVO.setIsImportant(rs.getString("is_important"));
		return noticeVO;
	}
	
	public List<NoticeVO> noticeList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT notice_no, title, content, writer,");
		query.append("to_char(writeday, 'YYYY/MM/DD') writeday, view_count, is_important ");
		query.append("FROM notice ");
		query.append("order by notice_no desc");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			ResultSet rs = pstmt.executeQuery()) {
			
			while (rs.next()) {
				list.add(addNotice(rs));
			}
		}catch (SQLException e) {
			System.err.println("[NoticeList] SQL 오류: " + e.getMessage());
			e.printStackTrace();		//오류 발생 시 주석 해제	
		}
		return list;
	}
	

}
