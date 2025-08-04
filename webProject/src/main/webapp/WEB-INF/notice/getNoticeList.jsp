<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/common/header.jsp" %>

<body>
		<div id="NoticeList">
			<table summary="게시판 리스트" class="table">
				<thead>
					<tr class="text-center">
						<th class="col-md-1">번호</th>
						<th class="col-md-6">제목</th>
						<th class="col-md-2">작성자</th>
						<th class="col-md-2">날짜</th>
						<th class="col-md-1">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list}" >
							<c:forEach var="notice" items="${list}">
								<tr class="text-center">
									<td>${notice.noticeNo}</td>
									<td class="text-start">
										 <span class="goDetail">${notice.title}</span>
										<%--<a href="/board/detailBoard.do?num=${board.num}">${board.title}</a>--%>
									</td>  
									
									<td>${notice.writer}</td>
									<td>${notice.writeday}</td>
									<td>${notice.viewCount}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center">등록된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		<div class="contentBtn text-end">
			<button type="button" id="writeForm" class="btn btn-primary btn-sm">글작성</button>
		</div>
	</div>
	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script src="/include/js/getBoardList.js"></script>
	<script>
		/* 검색 후 검색 대상과 검색 단어 출력 - 검색여부는 키워드(keyword)의 값 존재여부로 제어*/
		if('${param.keyword}'!==""){
			$("#keyword").val('${param.keyword}');
			$("#search").val('${param.search}');
		}
	</script>
	
</body>
</html>
