package com.mvc.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.notice.service.NoticeService;
import com.mvc.notice.service.NoticeServiceImpl;
import com.mvc.notice.vo.NoticeVO;

public class InsertNoticeController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = null;
		
		// 1. VO객체에 데이터 바인딩
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNoticeNo(Integer.parseInt(request.getParameter("notice_no")));	// input 태그의 name명을 명시. name명=값의 형태를 서버에 전달
		noticeVO.setTitle(request.getParameter("title"));
		noticeVO.setContent(request.getParameter("content"));
		noticeVO.setWriter(request.getParameter("writer"));
		noticeVO.setWriteday(request.getParameter("writeday"));
		noticeVO.setViewCount(Integer.parseInt(request.getParameter("view_count")));
		noticeVO.setIsImportant(request.getParameter("is_important"));
		
		NoticeService service = NoticeServiceImpl.getInstance();
		int result = service.NoticeInsert(noticeVO);
		
		if (result ==1) { // 입력 성공시
			path = "/notice/getNoticeList.do";	// 게시판 리스트 요청
		} else {
			request.setAttribute("errorMsg", "등록완료에 문제가 있어 잠시 후 다시 입력해 주세요.");
			path = "/Notice/insertForm";		// 입력 화면으로 이동
		}
		
		//3. 화면 네비게이션
		return path;
		
		
	}

}
