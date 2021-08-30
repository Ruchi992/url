$(document).ready(function() {
	$("button").click(function() {
		$.ajax({
			type : 'POST',
			url : 'http://localhost:8090/shortUrl',
			data : JSON.stringify({
				"shortUrl" : $("#shorturltext").val()
			}),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				window.location.href = data;
			},
			error: function(data){
				$("#invalidUrl").append(data.responseText);
			}
		});
	});
});