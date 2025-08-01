package com.mvc.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mvc.common.util.DBUtil.getConnection;

import com.mvc.board.vo.BoardVO;

public class NoticeDAO {
	private static NoticeDAO instance =null;
	
	public static NoticeDAO getInstance() {	//BoardDAO의 인스턴스는 BoardDAO.getInstance()
		if(instance==null) {
			instance= new NoticeDAO();
		}
		return instance;
	}
	
	private NoticeDAO() {}	// 다른 클래스 new BoardDAO(); X
	
	private BoardVO addBoard(ResultSet rs) throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(rs.getInt("num"));
		boardVO.setAuthor(rs.getString("author"));
		boardVO.setTitle(rs.getString("title"));
		boardVO.setWriteday(rs.getString("writeday"));
		boardVO.setReadcnt(rs.getInt("readcnt"));
		return boardVO;
	}
	
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT num, author, title, ");
		query.append("to_char(writeday, 'YYYY/MM/DD') writeday, readcnt ");
		query.append("FROM board ");
		query.append("order by num desc");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			ResultSet rs = pstmt.executeQuery()) {
			
			while (rs.next()) {
				list.add(addBoard(rs));
			}
		}catch (SQLException e) {
			System.err.println("[boardList] SQL 오류: " + e.getMessage());
				//se.printStackTrace();		//오류 발생 시 주석 해제	
		}
		return list;
	}
	
	public int boardInsert(BoardVO boardVO) {
		/*String query = """
        INSERT INTO board (num, author, title, content, passwd)
        VALUES (board_seq.nextval, ?, ?, ?, ?)
    """;*/
		
	StringBuilder query = new StringBuilder();
	query.append("INSERT INTO board(num, author, title, content, passwd) ");
	query.append("VALUES(board_seq.nextval, ?, ?, ?, ?)");
	
	int result = 0;
	try (Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query.toString())) {	//  주석부분을 해제하고 사용한다면 query.toString() -> query로 변경.
		
		pstmt.setString(1, boardVO.getAuthor());
		pstmt.setString(2, boardVO.getTitle());
		pstmt.setString(3, boardVO.getContent());
		pstmt.setString(4, boardVO.getPasswd());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println("[boardInsert] SQL오류: " + e.getMessage());
		//e.printStackTrace);	//오류 발생 시 주석 해제
	}
	return result;
}
	public void readCount(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE board SET readcnt = readcnt + 1 ");
		query.append("WHERE num = ?");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());) {
			
			pstmt.setInt(1, boardVO.getNum());
			pstmt.executeUpdate( );
		}catch(SQLException e) {
			System.err.println("[readCount] SQL 오류: " + e.getMessage());
			//e.peintStackTrace();	//오류 발생 시 주석 해제
		}
	}
	
	public BoardVO boardDetail(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT num, author, title, content, ");
		query.append("TO_CHAR(writeday, 'YYYY-MM-DD HH24:MI:SS') writeday, readcnt ");
		query.append("FROM board WHERE num = ?");
		BoardVO resultData = null;
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
			
			pstmt.setInt(1, boardVO.getNum());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					resultData = addBoard(rs);
					resultData.setContent(rs.getString("content"));
				}
			}
		} catch (SQLException e) {
			System.err.println("[boardDetail] SQL 오류: " + e.getMessage());
			//e.printStackTrace();	//오류 발생 시 주석 해제
		}
		return resultData;
	}

	public int boardUpdate(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE board SET title = ?, content = ?");	//제목과 내용은 명경된 내용이, 기본값 그대로
		if(boardVO.getPasswd()!="") query.append(", passwd = ? "); // 비밀번호는 변경할 수도 하지 않을수도 있음
		query.append("WHERE num = ?"); 								// 수정의 기눈은 글번호
		
		int result = 0;
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());){
			
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			
			if(boardVO.getPasswd() != "") {
				pstmt.setString(3,boardVO.getPasswd());
				pstmt.setInt(4,boardVO.getNum());
			} else {
				pstmt.setInt(3,boardVO.getNum());
			}
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("[boardUpdate] SQL 오류: " + e.getMessage());
			//e.printStackTrace();	//오류 발생 시 주석 해제
		}
		return result;
	}

	public int boardDelete(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("DELETE FROM board WHERE num =?");
		
		int result = 0;
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());) {
			
			pstmt.setInt(1, boardVO.getNum());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("[boardDelete] SQL 오류: " + e.getMessage());
			//e.peintStackTrace();	//오류 발생 시 주석 해제
		}
		return result;
	}

	public int boardPasswdCheck(BoardVO boardVO) {
		String query = """
				SELECT CASE
					WHEN EXISTS (SELECT 1 FROM board WHERE num = ? AND passwd = ?)
						THEN 1
						ELSE 0
					END AS result
				FROM dual
			""";
		
		int result= 0;
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);) {
			
			pstmt.setInt(1, boardVO.getNum());
			pstmt.setString(2, boardVO.getPasswd());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					result = rs.getInt("result");	// 비밀번호 일치:1 / 비밀번호 불일치: 0 반환
				}
			}
		}catch(SQLException e) {
			System.err.println("[boardPasswdCheck] SQL 오류: " + e.getMessage());
			//e.peintStackTrace();	//오류 발생 시 주석 해제
		}
		return result;
	}

	public List<BoardVO> boardList(BoardVO boardVO) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String search = boardVO.getSearch();
		String keyword = boardVO.getKeyword();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT  num, author, title,  ");
		query.append("to_char(writeday, 'YYYY/MM/DD') writeday, readcnt ");
		query.append("FROM board");
		switch(search){
			case "title":
				query.append(" WHERE title LIKE ? ");  // 검색대상이 제목일 경우
				break;
			case "author":
				query.append(" WHERE author LIKE ? "); // 검색대상이 작성자일 경우
				break;
		}
		query.append(" order by num desc");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());) {
			
			if(!search.equals("all")) {
				pstmt.setString(1, "%" + keyword + "%" );
			}
			
			try (ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					list.add(addBoard(rs));
				}
			}
		} catch (SQLException e) {
			System.err.println("[boardList] SQL 오류: " + e.getMessage());
			//e.printStackTeace();	//오류 발생 시 주석 해제
		}
		return list;
	}
}
