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
<title>Upload Image By Admin</title>
<style type="text/css">
.hide {
	visibility: hidden;
}
</style>

</head>
<body>
	<div class="divForm">
		<sf:form class="form-style-7" action="/uploadimagebyadmin" method="post"
			commandName="imagebyadmin" enctype="multipart/form-data">
			<ul>
				<li><label for="title">Upload Image</label> <sf:input
						type="file" path="file" name="file" /> <br /> <sf:errors
						path="file" style="color:red;"></sf:errors></li>
				<li><label for="rdbYes">Have sub image:Yes</label> <input
					type="radio" id="rdbYes" name="haveSubimage" value="true" /> <br />
					<sf:errors path="haveSubimage" style="color:red;"></sf:errors> <span>Make
						sure if it has sub images!!</span></li>
				<li class="nomovable"><label for="rdbNo">Have sub
						image:No</label> <input type="radio" id="rdbNo" name="haveSubimage"
					value="false" /> <br /> <sf:errors path="haveSubimage"
						style="color:red;"></sf:errors> <span>Make sure if it has
						sub images!!</span></li>
				<li class="movable hide"><label for="imgRandom">Random
						Image</label> <sf:input id="imgRandom" path="randomimagefile" type="file"
						name="randomimagefile" /> <sf:errors path="randomimage"
						style="color:red;"></sf:errors><span>Upload random image</span></li>

				<li class="movable similar hide"><label for="imgSimilar">Similar
						Image</label> <sf:input id="imgSimilar" path="similarimagefile"
						type="file" name="similarimagefile" /> <sf:errors
						path="similarimage" style="color:red;"></sf:errors><span>Upload
						similar image</span></li>
				<li><input type="submit" value="Upload" /> or <a class="close"
					href="${pageContext.request.contextPath}/adminpage">Cancel</a></li>
			</ul>
		</sf:form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('input:radio').click(function() {
				if ($(this).val() === 'true') {
					$('.nomovable').remove();
					$('.movable').removeClass('hide');
				}
			});
		});
	</script>
</body>
</html>
