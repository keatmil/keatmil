<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
	<c:when test="${WHERE == 'INS' }">
		<c:set var="SUC_MSG" value="입력 성공" />
		<c:set var="FAIL_MSG" value="입력 실패" />
		<c:set var="SUC_URL" value="/ReplyBBS/BBS/List.bbs" />
	</c:when>
	<c:when test="${WHERE == 'EDT' }">
		<c:set var="SUC_MSG" value="수정 성공" />
		<c:set var="FAIL_MSG" value="수정 실패" />
		<c:set var="SUC_URL" value="/ReplyBBS/BBS/View.bbs?no=${no}" />
	</c:when>
	<c:otherwise>
		<c:set var="SUC_MSG" value="삭제 성공" />
		<c:set var="FAIL_MSG" value="삭제 실패" />
		<c:set var="SUC_URL" value="/ReplyBBS/BBS/List.bbs" />
	</c:otherwise>
</c:choose>

<script>
	<c:choose>
		<c:when test="${SUC_FAIL == 1}">
				alert("${SUC_MSG }");
				location.href = '<c:url value="${SUC_URL }" />';
		</c:when>
		<c:when test="${SUC_FAIL == 0}">
				alert("${FAIL_MSG }");
				history.back();
		</c:when>
	</c:choose>
</script>