<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/header.jsp" %>

<body>
	<div class="container">
		<div class="text-center"><h3>게시판 상세 화면</h3></div>	
		<%-- post 방식으로 전송 시 반드시 form 태그 명시 --%>
		<form name="dataForm" id="dataForm">
			<input type="hidden" name="num" value="${detail.num}">
		</form>
		
		<div class="row text-center mb-2">
			<div class="col-md-9 text-start" id="pwdFormArea">
						<form id="pwdForm" class="row g-3">
					<input type="hidden" name="num" value="${detail.num}" />
					<div class="col-auto">
						<label for="passwd" class="visually-hidden">비밀번호</label>
						<input type="password" class="form-control form-control-sm" name="passwd" id="passwd" placeholder="비밀번호 입력" />
					</div>
					<div class="col-auto">
						<button type="button" id="passwdBtn" class="btn btn-secondary btn-sm">확인</button>
						<button type="button" id="passwdCancleBtn" class="btn btn-secondary btn-sm">취소</button>
						 </div>
						 <div class="col-auto">
						 	<span id="message" class="align-middle"></span>
						 </div>
					</form>		
						</div>
						
			<div class="col-md-3 text-end">
				<button type="button" id="updateFormBtn" class="btn btn-primary btn-sm" >글수정</button>
				<button type="button" id="boardDeleteBtn" class="btn btn-primary btn-sm">글삭제</button>
				<button type="button" id="insertFormBtn" class="btn btn-primary btn-sm">글작성</button>
				<button type="button" id="boardListBtn" class="btn btn-primary btn-sm">글목록</button>
			</div>
		</div> 
		
		<div class="text-center">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td class="col-md-3">글번호</td>
						<td class="col-md-3 text-start">${detail.num} <label>(조회수: ${detail.readcnt})</label></td>
						<td class="col-md-3">작성일</td>
						<td class="col-md-3 text-start">${detail.writeday}</td>
					</tr>
					<tr>
						<td class="col-md-3">작성자</td>
						<td colspan="3" class="col-md-9 text-start">${detail.author}</td>
					</tr>
					<tr>
						<td class="col-md-3">글제목</td>
						<td colspan="3" class="col-md-9 text-start">${detail.title}</td>
					</tr>
					<tr class="table-height">
						<td class="align-middle">글내용</td>
						<td colspan="3" class="text-start">${detail.content}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script src="/include/js/detailBoard.js"></script>
</body>
</html>