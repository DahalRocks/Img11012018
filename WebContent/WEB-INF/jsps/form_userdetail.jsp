<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Detail Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/me.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<style type="text/css">
	.form-style-7 li > label{
		height:18px;
	}
</style>
</head>
<body>
<header class="row">
	<div>Online Experiment</div>
	<div>for</div>
	<div>Image Description</div>
	</header>
	<sf:form action="/enteruser" method="post"
		commandName="userDetail" class="form-style-7">
		<ul>
		
			<li><p style="font-size:25px;font-weight:bold;font-family:arial">Please enter the following information</p></li>
			<li><label for="age">Your Age Group:</label><sf:select path="age">
				<sf:option value="">Select</sf:option>
				<sf:option value="1">15-20</sf:option>
				<sf:option value="2">21-26</sf:option>
				<sf:option value="3">27-32</sf:option>
				<sf:option value="4">33-38</sf:option>
				<sf:option value="5">39-44</sf:option>
				<sf:option value="6">45-50</sf:option>
				<sf:option value="7">51-56</sf:option>
				<sf:option value="8">57-62</sf:option>
			</sf:select><sf:errors
						path="age" style="color:red;"></sf:errors></li>
			<li><label for="gender">Your Gender:</label> <sf:select id="gender" path="gender">
					<sf:option value="">Select</sf:option>
					<sf:option value="male">male</sf:option>
					<sf:option value="female">female</sf:option>
				</sf:select> <sf:errors
						path="gender" style="color:red;"></sf:errors></li>
			
			<li><label for="education">Your Education:</label> <sf:select id="education" path="education">
					<sf:option value="">Select</sf:option>
					<sf:option value="1">High School</sf:option>
					<sf:option value="2">College/University</sf:option>
				</sf:select>
				<sf:errors
						path="education" style="color:red;"></sf:errors></li>
			<li>
				<label for="nationality">Your Nationality:</label><sf:input type="text" name="nationality"
				id="nationality" path="nationality"/>
			<sf:errors
						path="nationality" style="color:red;"></sf:errors>
			</li>
			<li>
				<label for="email">Your Email:</label><sf:input type="text" name="email"
				id="email" path="email"/>
			<sf:errors
						path="email" style="color:red;"></sf:errors>
			</li>
			<li style="border:0px solid #fff"><p style="color:red">${message}</p></li>
			<li>
				<input type="submit" value="OK"/>
			</li>


		</ul>



	</sf:form>
</body>
</html>
