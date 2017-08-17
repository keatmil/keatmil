<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>
<%-- <script type="text/javascript" src="<c:url value='/JS/jquery-3.2.1.js' />"></script> --%>
<script>
	$(function(){
		var obj = {name:"홍길동", age:"12"};
		console.log("이름: %s, 나이: %s", obj.name, obj.age);
		
		var jArray = {member:[
			{id: "kim", pwd:"1234", name:"김길동"}, 
			{id: "park", pwd:"1234", name:"박길동"}, 
			{id: "lee", pwd:"1234", name:"이길동"}
		]};
		console.log(typeof jArray);
		console.log(jArray.member.length);
		var tableString = "<table style='border-spacing:1px; background-color: red'>";
		$.each(jArray.member, function(index, value){
			console.log("인덱스"+index+", 값"+value.id);
			tableString += "<tr style='background-color:white'>";
			tableString += "<td>"+value.id+"</td>";
			tableString += "<td>"+value.pwd+"</td>";
			tableString += "<td>"+value.name+"</td>";
			tableString += "</tr>";
		});
		tableString += "</table>";
		
		$("legend").click(function(){
			$("span").append(tableString);
		});
		
		//console.log("아뒤: %s, 이름: %s, 비번: %s", obj.name, obj.age);
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Template.jsp</title>
</head>
<body>
	<fieldset>
		<legend>Template</legend>
		<span></span>
	</fieldset>
</body>
</html>