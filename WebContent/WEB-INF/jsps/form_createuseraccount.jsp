<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User Account</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
</head>
<body>
	<script type="text/javascript">
		function updateReminder(pdata) {
			$
					.ajax({
						dataType : 'json',
						url : "${pageContext.request.contextPath}/updatereminder",
						data : pdata,
						type : "POST",
						processData : false,
						contentType : false,
						success : function(result) {
							/* window.location
									.replace("http://localhost:8080/SimpleWebPage/createuserform"); */
						},
						error : function(result) {
							alert("Error occured in saveField");
						}
					});

		}

		$(document).ready(function() {

			$(".lnkUpdateReminder").click(function(event) {
				var row = $(this).closest("tr");
				var column = row.children('td:first');
				var userid = column.text();
				var reminded = row.find('.optReminded option:selected').val();
				var strField = {
					"userid" : userid,
					"reminded" : reminded
				}
				var pdata = JSON.stringify(strField);
				updateReminder(pdata);
				event.stopPropagation();
			});

		});
	</script>
	<div class="divForm">
		<sf:form class="form-style-7"  action="/createuser"
			commandName="user">
			<ul>
				<li><label for="fullname">Full Name</label> <sf:input
						type="text" path="fullname" name="fullname" /> <br /> <sf:errors
						path="fullname" style="color:red;"></sf:errors></li>
						<li><label for="username">User Name</label> <sf:input
						type="text" path="username" name="username" /> <br /> <sf:errors
						path="username" style="color:red;"></sf:errors></li>
				<li><label for="password">Password</label> <sf:input
						type="password" path="password" name="password" /> <br /> <sf:errors
						path="password" style="color:red;"></sf:errors><label for="message"><span id="message">${message}</span></label></li>
				
				<li> <label for="email">Email</label><sf:input type="text" path="email" name="email"/> <sf:errors
						path="email" style="color:red;"></sf:errors> </li>
				<li><label for="awareof">Aware of Accessibility</label>
					<sf:select path="awareof" id="awareof">
					
						<sf:option value="0">No</sf:option>
						<sf:option value="1">Yes</sf:option>
					
					</sf:select>
				
				</li>		
				<li><input type="submit" value="Ok" /> or <a class="close"
					href="${pageContext.request.contextPath}/adminpage">Cancel</a></li>
			</ul>
		</sf:form>
	</div>
	<div class="divForm">
		<sf:form class="form-style-7" action="" commandName="userlist">
			<table style="width:1000px;height:100%">
				<tr>
					<th>User ID</th>
					<th>Full Name</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Aware of Accessibility</th>
					<th>Reminder Status</th>
				</tr>
				<c:forEach var="user" items="${userlist}">
					<tr>
						<td>${user.userid}</td>
						<td>${user.fullname}</td>
						<td>${user.username}</td>
						<td>${user.email}</td>
						<td>${user.awareof}</td>
						<td>${user.reminded}</td>
						<td><select class="optReminded">
								<option value="true" label="true" />
								<option value="false" label="false" />
						</select></td>
						<td><a href="#" class="lnkUpdateReminder">Update</a></td>
					</tr>
				</c:forEach>
			</table>
		</sf:form>
	</div>
</body>
</html>
