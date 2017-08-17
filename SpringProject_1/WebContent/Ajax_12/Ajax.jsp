<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ajax.jsp</title>
<script>
	$(function(){
		$("#btn1").click(function(){
			$("#frm").attr({action: "<c:url value='/Ajax/NoAjax.do' />", method: "post"});
			$("#frm").submit();
		});
		
		$("#btn2").click(function(){
			console.log($("#frm").serialize());
			$.ajax({
				url: "<c:url value='/Ajax/AjaxText.do' />",
				type: "post",
				dataType: "text",
				data: //"id="+$(":input:eq(0)").val()+"&pwd="+$(":input:eq(1)").val(),
					//{id: $(":input:eq(0)").val(), pwd: $(":input:eq(1)").val()},
					$("#frm").serialize(),
				success: function(data){
					console.log("서버로부터 받은 데이타: "+data);
					//$("#lblDisplay").html(data=="Y" ? $(":text").val()+"님 즐감" : "회원이 아닙니다");
					$("#lblDisplay").html(data);
				},
				error: function(data){
					console.log(data);
				}
			});
		});
		
		$("#btn3").click(function(){
			$.ajax({
				url: "<c:url value='/Ajax/AjaxJson.do' />",
				type: "post",
				dataType: "text",
				data: //"id="+$(":input:eq(0)").val()+"&pwd="+$(":input:eq(1)").val(),
					//{id: $(":input:eq(0)").val(), pwd: $(":input:eq(1)").val()},
					$("#frm").serialize(),
				success: successCallback,
				error: function(data){
					console.log(data);
				}
			});
		});
		
		$("a:last").click(function(){
			$.ajax({
				url: "<c:url value='/Ajax/AjaxJsonArray.do' />", 
				type: "post",
				dataType: "json",
				success: successArrayCallback,
				error: function(request, data){
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
		
		
	});
	
	var successCallback = function(data){
		console.log("서버로부터 받은 데이타: "+data+", 데이타 타입: "+typeof data);
		data = JSON.parse(data);
		$("#lblDisplay").html(data.isLogin);
	};
	
	function successArrayCallback(data){
		console.log("서버로부터 받은 데이타: "+data+", 데이타 타입: "+typeof data);
		var tableString = "<table style='border=spacing:1px; background-color:red;'>";
		tableString += "<tr style='background-color:white'>";
		tableString += "<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>";
		tableString += "</tr>";
		$.each(data, function(index, record){
			tableString += "<tr style='background-color:white'>";
			tableString += "<td>"+(index+1)+"</td>";
			tableString += "<td>"+record.title+"</td>";
			tableString += "<td>"+record.name+"</td>";
			tableString += "<td>"+record.postdate+"</td>";
			tableString += "</tr>";
		});
		tableString += "</table>";
		
		$("#list").html(tableString);
	};
</script>
</head>
<body>
	<fieldset>
		<legend>jQuery Ajax(스프링 연동)</legend>
		<!-- 
		ajax로 서버에 요청시에는
		form태그가 의미 없다.
		단, 전송할 데이타가 많을시에는 
		추가해도 무방.
		(왜냐하면 자바스크립트로 서버에 요청하기 때문에)
		-->
		<form id="frm">
			아이디 <input type="text" name="id" /> 
			비빌번호 <input type="password" name="pwd" />
		</form>
		<ul style="list-style-type: upper-roman;">
			<li><input type="button" id="btn1" value="회원여부(AJAX미사용)" /></li>
			<!-- 
			Spring:반환타입을 void로 하거나
			반환타입을 String으로하고 @ResponseBody어노테이션 사용
			-->
			<li><a href="#" id="btn2">회원여부(AJAX사용-TEXT로 응답받기)</a></li>
			<li><input type="button" id="btn3" value="회원여부(AJAX사용-JSON으로 응답받기)" /></li>
		</ul>
		<hr />
		<span id="lblDisplay" style="font-size: 20px; color: red;">${member}</span>
		<h3>JSON형식(배열타입)</h3>
		<a href="#">목록가져오기</a><br /> 
		<span id="list"></span>
	</fieldset>
</body>
</html>