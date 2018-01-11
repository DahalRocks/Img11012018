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
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">

<style type="text/css">
.par {
	visibility: hidden;
}
</style>
<title>Upload Image Form</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#btnUpload").click(function() {
				$(".par").removeClass("par");
				$("#dialog").dialog({
					width : 700
				});
			});
		});
	</script>
	<div class="divForm">
		<form class="form-style-7" action="" method="post">
			<ul>
				<li><input id="btnUpload" aria-label="btnUpload" type="button"
					value="Select Image" /></li>


				<li><input id="btnOk" type="button" value="Upload" /> or <a
					id="linkFileCancel"
					href="${pageContext.request.contextPath}/callcontent">Cancel</a></li>
			</ul>
		</form>
	</div>

	<div id="dialog" title="Reminder">
		<div class="divForm par">
			<sf:form id="imagegallery par" action=" " commandName="imagelst">
				<c:forEach var="image" items="${ imagelst}">
					<div class="grid-item">
						<figure> <img
							src="${pageContext.request.contextPath}/resources/galleryimage/${image.imagename}"
							alt="Image" class="img-fluid tm-img" style="width: 100px; height: 100px"> </figure>

						<%-- <sf:radiobutton path="imageid" value="${image.imageid}"
												label="Select" onclick="submitForm()" /> --%>
						<a href="${pageContext.request.contextPath}/uploadselectedimage?name=${image.imagename}">Select<c:out
								value="${image.imageid}" /></a>
					</div>
				</c:forEach>
			</sf:form>
		</div>
	</div>
</body>
</html>