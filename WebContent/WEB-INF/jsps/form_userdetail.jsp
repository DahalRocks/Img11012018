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
	body{
	font-family:arial;
	}
	.form-style-7 li > label{
		height:18px;
	}
	.compalsary{
		color:red;
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
		
			<li><p style="font-size:25px;font-weight:bold;font-family:arial">Please Enter the Following Information</p></li>
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
						path="age" style="color:red;"></sf:errors><p class="compalsary">*</p></li>
			<li><label for="gender">Your Gender:</label> <sf:select id="gender" path="gender">
					<sf:option value="">Select</sf:option>
					<sf:option value="male">male</sf:option>
					<sf:option value="female">female</sf:option>
				</sf:select> <sf:errors
						path="gender" style="color:red;"></sf:errors><p class="compalsary">*</p></li>
			
			<li><label for="education">Your Education:</label> <sf:select id="education" path="education">
					<sf:option value="">Select</sf:option>
					<sf:option value="1">High School</sf:option>
					<sf:option value="2">College/University</sf:option>
				</sf:select>
				<sf:errors
						path="education" style="color:red;"></sf:errors><p class="compalsary">*</p></li>
						<li>
				<label for="profession">Your Profession:</label><sf:select id="profession" path="profession">
					<sf:option value="">Select</sf:option>
					<sf:option value="student">Student</sf:option>
					<sf:option value="journalist">Journalist</sf:option>
					<sf:option value="researcher">Researcher</sf:option>
					<sf:option value="software-developer">Software Developer</sf:option>
					<sf:option value="Web-Worker">Web Workers</sf:option>
					<sf:option value="Other">Other</sf:option>
				</sf:select>
			<sf:errors
						path="profession" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
						<li>
				<label for="englishspeaker">Are you a Native English Speaker?:</label><sf:select id="englishspeaker" path="englishspeaker">
					<sf:option value="">Select</sf:option>
					<sf:option value="yes">Yes</sf:option>
					<sf:option value="no">No</sf:option>
				</sf:select>
			<sf:errors
						path="englishspeaker" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
			<li>
				<label for="englishlevel">Your English Language Level:</label><sf:select id="englishlevel" path="englishlevel">
					<sf:option value="">Select</sf:option>
					<sf:option value="average">Average</sf:option>
					<sf:option value="competent">Competent</sf:option>
					<sf:option value="fluent">Fluent</sf:option>
				</sf:select>
			<sf:errors
						path="englishlevel" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
			<li>
				<label for="nationality">Your Nationality:</label><sf:input type="text" name="nationality"
				id="nationality" path="nationality"/>
			<sf:errors
						path="nationality" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
			<li>
				<label for="haveexperience">Have Previous Experience of Describing Images (for Visually Impaired) :</label><sf:select id="haveexperience" path="haveexperience">
					<sf:option value="">Select</sf:option>
					<sf:option value="yes">Yes</sf:option>
					<sf:option value="no">No</sf:option>
				</sf:select>
			<sf:errors
						path="haveexperience" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
			<li>
				<label for="isawareof">What is an Image Accessibility? It is more About :</label><sf:select id="isawareof" path="isawareof">
					<sf:option value="">Select</sf:option>
					<sf:option value="no">High Quality Image</sf:option>
					<sf:option value="no">Image in a Small size</sf:option>
					<sf:option value="yes">Understandable Image for Diverse user Group</sf:option>
				</sf:select>
			<sf:errors
						path="isawareof" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
			<li>
				<label for="email">Your Email:</label><sf:input type="text" name="email"
				id="email" path="email"/>
			<sf:errors
						path="email" style="color:red;"></sf:errors><p class="compalsary">*</p>
			</li>
			<li style="border:0px solid #fff"><p style="color:red">${message}</p></li>
			<li>
				<input type="submit" value="OK"/>
			</li>


		</ul>



	</sf:form>
</body>
</html>
