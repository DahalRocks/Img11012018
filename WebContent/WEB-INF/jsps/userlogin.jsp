<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
</head>
<body>
<div class="divForm">
		<sf:form class="form-style-7" style="width:300px;height:300px" action="/loginuser"
			commandName="userlogin">
			<ul>
				<li><label for="username">User Name</label> <sf:input
						type="text" path="username" name="username" /> <br /> <sf:errors
						path="username" style="color:red;"></sf:errors></li>
				<li><label for="password">Password</label> <sf:input
						type="password" path="password" name="password" /> <br /> <sf:errors
						path="password" style="color:red;"></sf:errors>
				 <label for="message"><span id="message">${message}</span></label></li>
				 
				 		
				 		
				<li><input type="submit" value="Ok" /> or <a class="close"
					href=" ">Cancel</a></li>
			</ul>
		</sf:form>
	</div>
</body>
</html>
