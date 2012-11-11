<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/list/short" var="home" />
<c:url value="/list/detail" var="detail" />
<c:url value="/save" var="save" />
<ul>
	<li><a href="${home}">HOME</a></li>
	<li><a href="${detail}">DETAILED VIEW</a></li>
	<li><a href="${save}">LOAD WORDS</a></li>
</ul>