<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Text Content</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
</head>
<body>
	<div class="divForm">
		<sf:form class="form-style-7"
			action="/createtextcontent" commandName="textcontent">
			<ul>
				<li><label for="division">Page Division</label><sf:select path="division">
				<sf:option value="1"  >One</sf:option>
				<sf:option   value="2">Two</sf:option>
				<sf:option   value="3">Three</sf:option>
				<sf:option  value="4">Four</sf:option>
				<sf:option  value="5">Five</sf:option>
				</sf:select></li>
				<li><label for="contenttitle">Content Title</label>
				
				<sf:input type="text" path="contenttitle" name="contenttitle" /><br />
				<sf:errors path="contenttitle" style="color:red;">	</sf:errors></li>
				<li><label for="reminder">Reminder</label>
					<sf:select path="reminder">
						<sf:option value="true">Yes</sf:option>
						<sf:option value="false">No</sf:option>
					</sf:select>
				</li>
				<li><label for="content">Content</label> <sf:input type="text"
						path="content" name="content" /> <br /> <sf:errors
						path="content" style="color:red;"></sf:errors></li>
				<li><input type="submit" value="Ok" /> or <a class="close"
					href="${pageContext.request.contextPath}/adminpage">Cancel</a></li>
			</ul>
		</sf:form>
	</div>
</body>
</html>
