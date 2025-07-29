$(".inputData").on({
	focusout : function(){
		if($(this).val().replace(/\s/g, "") ===""){
			$(this).next().html($(this).prev().html() + " 필수항목입니다");
			return;
		}
	},
	focusin : function(){
		$(this).next().html("");
	}
});

$("#regBtn").on("click", function() {
	let isVaild = true;
	
	$(".inputData").each(function() {
		if ($(this).val().replace(/\s/g, "") === "") {
			$(this).next().html($(this).prev().html() + " 필수항목입니다");
			isVaild = false;
		}
	});
	
	if (isVaild) {
		$("#bookForm").attr({
			"action": "/servletExmaple/bookInput",
			"method": "post"
		});
		$("#bookForm").submit();
	}
});