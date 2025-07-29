
/*const form = document.getElementById("scoreForm");
const score = document.getElementById("score");

score.addEventListener("input",function() {
	score.setCustomValidity("");
});


form.addEventListener("submit", function(e){
	e.preventDefault();
	
	const pattern = /^(100|[1-9][0-9]?|0)$/;
	
	if(!pattern.test(score.value)) {
		score.setCustomValidity("점수는 0 ~ 100점으로 입력해 주세요.");
		score.reportValidity();
		score.value = "";
		return;
	}
	
	form.method = "post";
	form.action = "/scriptTag/implicitobject/score.jsp";
	//form.action = "score.jsp";
	
	form.submit();
});*/

$("#sendBtn").on("click", ()=>{
	const pattern = /^(100|[1-9][0-9]?|0)$/;
	
	if(!pattern.test($("#score").val())){
		alert("점수는 0 ~ 100점으로 입력해 주세요.");
		$("#score").val("");
		$("#score").focus();
		return;
	}
	
	$.ajax({
		url:"/scriptTag/implicitobject/score2.jsp",		
		method:"post",							// 전송방식(get/post)
		data:$("#scoreForm").serialize(),		// 서버에 전달한 파라미터(serialize():폼전체
		dataType:"text"							// 서버로부터 응답받을 문서 타입(text/json/xml)
	}).done(function (data) {
		//console.log(data);					// 확인하고 주석주기
		$("#result").val(data);
	}).fail(function(xhr, status) {
		alert(status + " 발생.\n상태: " + xhr.status);
	});
	
});