package com.mvc.notice.service;

import java.util.List;


import com.mvc.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList();

	public int NoticeInsert(NoticeVO noticeVO);


}
