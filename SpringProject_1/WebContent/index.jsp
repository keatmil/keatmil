<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>스프링 프레임워크 테스트 하기</legend>
		<h2>[기본 DispatcherServlet사용] : ${message }</h2>
		<ul style="list-style-type: upper-roman;">
			<li><a href="<c:url value='/Basic/Controller.do?message=Hellow Spring Controller Interface!!!' />">Controller인터페이스로 컨트롤러 구현</a></li>
			<li><a href="<c:url value='/Basic/AbstractController.do?message=Hellow Spring AbstractController Class!!!' />">AbstractController클래스로 컨트롤러 구현</a></li>
			<li><a href="<c:url value='/Basic/Annotation.do?message=Hellow Spring Annotation!!!' />">Annotation클래스로 컨트롤러 구현</a></li>
		</ul>
		
		<h2>[또 다른 DispatcherServlet사용]</h2>
		<c:url value="/Basic/AnotherDispatcher.kosmo?message=Hellow Spring Another Dispatcher!!!" var="url" />
		<a href="${url }">Another Dispatcher</a>
		
		<h2>[DispatcherServlet 과 관련된 설정 파일 및 위치 변경]</h2>
		<ul style="list-style-type: upper-roman;">
			<li><a href="<c:url value='/Basic/WEBINF.nate?message=Hello Spring WEB-INF!!' />">WEB-INF에 폴더 생성후 빈 설정파일 위치시키기</a></li>
			<li><a href="<c:url value='/Basic/SRC.daum?message=Hello Spring SRC!!' />">src(클래스 패스)에 패키지 생성후 빈 설정파일 위치시키기</a></li>
		</ul>
	</fieldset>
</body>
</html>