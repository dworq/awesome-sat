<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/common/htmlHead.jsp" />
<body>
	<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
	<table>
		<thead>
			<tr>
				<td>Word</td>
				<td>Meaning</td>
				<td>Example</td>
			<tr>
		</thead>
		<tbody>
			<c:forEach var="word" items="${words}">
				<c:forEach var="meaning" items="${word.meanings}" varStatus="status">
					<tr>
						<td><c:choose>
								<c:when test="${status.first}">${word.word}</c:when>
								<c:otherwise>&nbsp;</c:otherwise>
							</c:choose></td>
						<td>${meaning.definition}</td>
						<td>${meaning.example}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>