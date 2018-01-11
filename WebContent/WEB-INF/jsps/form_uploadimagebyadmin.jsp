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
<title>Upload Image By Admin</title>
</head>
<body>
	<div class="divForm">
		<sf:form class="form-style-7" action="/uploadimagebyadmin"
			method="post" commandName="imagebyadmin" enctype="multipart/form-data">
			<ul>
				<li><label for="title">Upload Image</label> <sf:input
						type="file" path="file" name="file" /> <br /> <sf:errors
						path="file" style="color:red;"></sf:errors></li>
				<li><label for="imagetype">Image Type</label> <sf:input type="text"
						path="imagetype" name="imagetype" /> <br /> <sf:errors path="imagetype"
						style="color:red;"></sf:errors> <span>Enter type of image</span>
				</li>
				<li><input type="submit" value="Upload" /> or <a class="close"
					href="${pageContext.request.contextPath}/adminpage">Cancel</a></li>
			</ul>
		</sf:form>
	</div>
</body>
</html>
