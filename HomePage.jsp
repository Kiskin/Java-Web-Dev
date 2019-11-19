<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Tracking Session history</title>
</head>
<body>

	<h2>
		<a href='http://localhost:8080/acv/home'> Homepage.jsp</a>
	</h2>

	<h4>
		<a href='http://localhost:8080/acv/indexpage'> Go to Index.jsp</a>
	</h4>
	<h4>
		<a href='http://localhost:8080/acv/page1'> Go to Page1.jsp</a>
	</h4>


	<h2>History List</h2>

	<c:forEach items="${history}" var="historyEntry">

		<c:out value="${historyEntry}" />
		</br>

	</c:forEach>


</body>

</html>