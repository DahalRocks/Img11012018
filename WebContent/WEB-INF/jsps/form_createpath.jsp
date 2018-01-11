<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
<title>Create Image Path</title>
</head>
<body>
	<div class="divForm">
		<sf:form class="form-style-7" action="/SimpleWebPage/createfilepath"
			commandName="filePath">
			<ul>
				<li><label for="fp">File Path</label> <sf:input type="text"
						path="fp" name="fp" /> <br /> <sf:errors path="fp"
						style="color:red;"></sf:errors></li>
				<li><input type="submit" value="Ok" /> or <a class="close"
					href=" ">Cancel</a></li>
			</ul>
		</sf:form>
	</div>
</body>
</html>