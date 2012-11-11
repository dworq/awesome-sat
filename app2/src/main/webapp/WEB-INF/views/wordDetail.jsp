<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/common/htmlHead.jsp" />
<body>
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
	<c:choose>
		<c:when test="${empty word}">
			<div>No word found</div>
		</c:when>
		<c:otherwise>
			<div>${word.word}</div>
			<c:forEach var="meaning" items="${word.meanings}">
				<div>
					<div>${meaning.definition}</div>
					<div>${meaning.example}</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>