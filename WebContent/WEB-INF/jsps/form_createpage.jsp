<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
</head>
<body>
	<div class="divForm">
		<sf:form class="form-style-7" action="/SimpleWebPage/createpage"
			 commandName="page" method="post">
			<ul>
				<li><label for="pagename">Page Title</label> <sf:input
						type="text" path="pagename" name="pagename" /> <br /> <sf:errors
						path="pagename" style="color:red;"></sf:errors></li>
				<li><input type="submit" value="Ok" /> or <a class="close"
					href="${pageContext.request.contextPath}/welcome ">Cancel</a></li>
			</ul>
		</sf:form>
	</div>
</body>
</html>