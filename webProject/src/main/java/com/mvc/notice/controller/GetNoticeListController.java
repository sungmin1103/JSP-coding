package com.mvc.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.notice.service.NoticeService;
import com.mvc.notice.service.NoticeServiceImpl;
import com.mvc.notice.vo.NoticeVO;

public class GetNoticeListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		NoticeService service = NoticeServiceImpl.getInstance();
		List<NoticeVO> list = service.noticeList();
		
		request.setAttribute("list", list);
		
		return "/notice/getNoticeList";
		
		
		
	}

}
