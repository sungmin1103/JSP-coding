/*document.getElementById("sendBtn").addEventListener("click", ()=>{
	const keyword = document.getElementById("word").value.trim();
	
	if (keyword === "") {
		document.getElementById("result").innerText = "검색어를 입력하세요";
		return;
	}
	
	window.location.href = "SearchServlet?word=" + encodeURIComponent(keyword);
	
	
});*/		// 내가 작성한 js 

$("word").on("keyup", function() {
	$("#result").html("");
});
$("#sendBtn").on("click", ()=> {
	if($("#word").val().replace(/\s/g,"")===""){
		//alert("검색할 단어로 입력해 주세요.")
		$("#result").html("검색할 단어를 입력해 주세요.").css("color","#800000");
		$("#word").val("");
		$("#word").focus();
		return;
	} else {
		$("#form").attr({
			"method":"post",
			"action":"sendredirect.jsp"
		});
		$("#form1").submit();
	}
	
});
