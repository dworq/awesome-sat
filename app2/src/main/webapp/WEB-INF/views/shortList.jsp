<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/common/htmlHead.jsp" />
<body>
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
	<c:forEach var="word" items="${words}">
		<a class="word" href="<c:url value="/word/${word.id}" />">${word.word}</a>
	</c:forEach>
</body>
</html>