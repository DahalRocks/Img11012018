<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
</head>
<body>
	<div id="userNameDiv">
		Hi
		<c:out value="${sessionScope.user.username}" />
	</div>
	<div id="welcomeTextDiv">WELCOME TO THE SIMPLE CMS!! THANK YOU
		FOR YOUR COOPERATION!!</div>
	<div id="clickBtnDiv">
		<a href="${pageContext.request.contextPath}/callcontentfirsttime">CLICK
			HERE TO CREATE A PAGE</a>
	</div>
</body>
</html>