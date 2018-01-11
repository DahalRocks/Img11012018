<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
</head>
<body>

	<div class="divForm">
		<form class="form-style-7" action=" ">
			<ul>
				<li><span
					style="font-weight: bold; font-family: arial; font-size: 20px">Admin
						Page</span></li>

				<li><label for="createuser"></label> <a id="createuser"
					href="${pageContext.request.contextPath}/createuserform">Create
						User</a></li>
				<li><label for="createcontent"></label> <a id="createcontent"
					href="${pageContext.request.contextPath}/createtextcontentform">Create
						Content</a></li>
				<li><label for="createimagelist"></label> <a
					id="createimagelist"
					href="${pageContext.request.contextPath}/calladminform">Create
						Image List</a></li>
						<li><label for="createuserlogin"></label> <a
					id="createuserlogin"
					href="${pageContext.request.contextPath}/createuserlogin">Login Page</a></li>

				<li><span
					style="font-weight: bold; font-family: arial; font-size: 20px">Admin
						Page</span></li>

			</ul>
		</form>
	</div>
</body>
</html>