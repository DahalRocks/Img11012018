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

.imageid {
	visibility: hidden;
}

.imageLst img {
	height: 100px;
	width: 100px;
	border-radius: 20px;
}

.row {
	margin: 0 auto;
}

h1 {
	font-weight: 300;
	text-transform: uppercase;
	letter-spacing: 1px;
	text-align: center;
	font-family: arial;
}

h1:after {
	width: 200px;
	height: 2px;
	background-color: black;
	margin: 20px auto;
	content: " ";
	display: block;
}

.participant-image {
	width: 100%;
	list-style: none;
}

.participant-image li {
	float: left;
	width: 10%;
	display: block;
	margin: 0;
}

.participant-image li figure {
	width: 100%;
	height: auto;
	margin: 5px 0;
	overflow: hidden;
}

.participant-image li figure img {
	height: 100px;
	width: 100px;
	opacity: 0.95;
	transform: scale(1.15);
	transition: transform 0.5s, opacity 0.5s;
	overflow: hidden;
	background-color: #000;
}

.participant-image li figure img:hover {
	opacity: 1;
	transform: scale(1);
}
</style>

</head>
<body>
	<div class="row">
		<h1>Admin page</h1>


	</div>

	<div class="divForm">
		<sf:form class="form-style-7"
			action="/uploadimagebyadmin" method="post"
			commandName="imagebyadmin" enctype="multipart/form-data">
			<ul>
				<li><label for="title">Upload Image</label> <sf:input
						type="file" path="file" name="file" /> <br /> <sf:errors
						path="file" style="color:red;"></sf:errors></li>
				<li><label for="parentimagedescription">Description
						for parent image</label> <sf:input id="parentimagedescription"
						type="text" path="parentimagedescription" /> <sf:errors
						path="parentimagedescription" style="color:red"></sf:errors></li>
				<li><label for="parentimagetype">Parent Image Type</label> <sf:input id="parentimagetype"
						type="text" path="parentimagetype" /> <sf:errors
						path="parentimagetype" style="color:red"></sf:errors></li>
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
				<li class="movable hide"><label for="randomimagedescription">Description
						for random image</label> <sf:input id="randomimagedescription" type="text"
						path="randomimagedescription" /> <sf:errors
						path="randomimagedescription" style="color:red"></sf:errors></li>

				<li class="movable similar hide"><label for="imgSimilar">Similar
						Image</label> <sf:input id="imgSimilar" path="similarimagefile"
						type="file" name="similarimagefile" /> <sf:errors
						path="similarimage" style="color:red;"></sf:errors><span>Upload
						similar image</span></li>
				<li class="movable hide"><label for="similarimagedescription">Description
						for similar image</label> <sf:input id="similarimagedescription"
						type="text" path="similarimagedescription" /> <sf:errors
						path="similarimagedescription" style="color:red"></sf:errors></li>
				<li><input type="submit" value="Upload" /> or <a class="close"
					href="${pageContext.request.contextPath}/adminpage">Cancel</a></li>
			</ul>
		</sf:form>
	</div>

	<div class="row">
		<h1>Available image list for participants</h1>
	</div>
	<div class="row">
		<ul class="participant-image">
			<c:forEach items="${parentimagelst}" var="parentimagelst">
				<li class="testli"><figure> <img class="singleimg"
						alt=""
						src="${pageContext.request.contextPath}/resources/galleryimage/${parentimagelst.imagename}">
					<label class="imageid">${parentimagelst.imageid}</label> </figure></li>
			</c:forEach>
		</ul>
	</div>
	<div id="imagelistDialog" title="Sub Images">
		<div class="divForm hide">
			<form id="deletefile" class="form-style-7" action="">
				<ul class="ul-delete-image">
					<li><input type="button" value="Delete Parent Image"
						id="btnDelete" /></li>
					<li class="child-li hide"></li>
				</ul>

			</form>

			<form id="similarfile" class="form-style-7"
				enctype="multipart/form-data"
				action="/updateSimilarImg" method="post">

				<ul class="ul-subimage-similar">

				</ul>

			</form>

			<form id="randomfile" class="form-style-7"
				action="/updateRandomImg"
				enctype="multipart/form-data" method="post">

				<ul class="ul-subimage-random">

				</ul>

			</form>

		</div>
	</div>

	<script type="text/javascript">
		function getSubImage(imageid) {
			var strField = {
				"imageid" : imageid
			};
			var pdata = JSON.stringify(strField);
			$.ajax({
				dataType : 'json',
				url : "${pageContext.request.contextPath}/getSubImage",
				data : pdata,
				type : "POST",
				processData : false,
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					createSubImageWindow(result);
				},
				error : function(result) {
					alert("Error occured in saveField");
				}
			});
		}
		function createSubImageWindow(result) {
			$('.ul-subimage-similar').empty();
			$('.ul-subimage-random').empty();

			if (result.length == '0') {
				var htmlforimg = '<li><h1>No sub image found</h1></li>';
				$('.ul-subimage').append(htmlforimg);
			} else {
				$
						.each(
								result,
								function(index, currImg) {
									if (currImg.imagetype == "similar") {
										var htmlforimg = '<li><label for="similarimg">Similar Image</label><img style="width:200px;height:200px" alt="Similar image to the parent image" src=${pageContext.request.contextPath}/resources/galleryimage/'+currImg.subimagename+'/>';
										htmlforimg += '<input type="file" name="similarfile" value="Upload" id="similarimg"/><label class="subimgid hide">'
												+ currImg.subimageid
												+ '</label><input id="btnUpdateSimilarImg" type="submit" value="Update" /></li>';
										$('.ul-subimage-similar').append(
												htmlforimg);

									} else if (currImg.imagetype == "random") {
										var htmlforimg = '<li><label for="randomimage">Random Image</label><img style="width:200px;height:200px" alt="Random image to the parent image" src=${pageContext.request.contextPath}/resources/galleryimage/'+currImg.subimagename+'/>';
										htmlforimg += '<input type="file" name="randomfile" value="Upload" id="randomimage"/><label class="subimgid hide">'
												+ currImg.subimageid
												+ '</label><input id="btnUpdateRandomImg" type="submit" value="Update" /> </li>';
										$('.ul-subimage-random').append(
												htmlforimg);
									}

								});

			}
		}
		function setRandomId(subimageid) {

			var imageid = {
				"subimageid" : subimageid
			};

			var strData = JSON.stringify(imageid);

			$.ajax({
				url : '${pageContext.request.contextPath}/setRandomId',
				data : strData,
				dataType : 'json',
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					updateRandomImg();

				},
				error : function() {
					alert("Error occured in setting random image id");
				}
			});

		}

		function setSimilarId(subimageid) {

			var imageid = {
				"subimageid" : subimageid
			};

			var strData = JSON.stringify(imageid);

			$.ajax({
				url : '${pageContext.request.contextPath}/setSimilarId',
				data : strData,
				dataType : 'json',
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					updateRandomImg();

				},
				error : function() {
					alert("Error occured in setting random image id");
				}
			});

		}

		function updateRandomImg() {
			var oMyForm = new FormData();
			oMyForm.append("file", randomfile.files[0]);

			$.ajax({
				url : '${pageContext.request.contextPath}/updateRandomImg',
				type : "POST",
				data : oMyForm,
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false
			}).done(function(data) {
				alert('successful');

			}).fail(function(jqXHR, textStatus) {

				alert('File upload failed ...');
			});

		}

		function updateSimilarImg() {

			var oMyForm = new FormData();
			oMyForm.append("file", similarfile.files[0]);

			$.ajax({
				url : '${pageContext.request.contextPath}/updateSimilarImg',
				type : "POST",
				data : oMyForm,
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false
			}).done(function(data) {
				alert('Upload success!!');

			}).fail(function(jqXHR, textStatus) {

				alert('File upload failed ...');
			});

		}
		function deleteParentImage(imageid) {

			var imageid = {
				"imageid" : imageid
			};

			var strData = JSON.stringify(imageid);

			$
					.ajax({
						url : '${pageContext.request.contextPath}/deleteParentImage',
						data : strData,
						dataType : 'json',
						processData : false,
						contentType : false,
						type : 'POST',
						success : function(data) {
							alert("Delete successful!!");
							window.location
									.replace('${pageContext.request.contextPath}/calladminform');

						},
						error : function() {
							alert("Error occured in deliting parent image");
						}
					});
		}

		$(document).ready(
				function() {
					$('input:radio').click(function() {
						if ($(this).val() === 'true') {
							$('.nomovable').remove();
							$('.movable').removeClass('hide');
						}
					});
					$('#btnDelete').click(
							function() {

								deleteParentImage($(this).closest('ul').find(
										'.imageid').text());

							});

					$('.singleimg').click(
							function(event) {
								var imageid = $(this).closest('li').find(
										'.imageid').text();

								var htmlforid = '<lable class="imageid">'
										+ imageid + '</label>';

								$('.child-li').empty();
								$('.child-li').append(htmlforid);

								event.stopPropagation();
								getSubImage(imageid);
								$(".divForm").removeClass("hide");
								$("#imagelistDialog").dialog({
									width : 700
								});
							});

					$('body').on(
							'click',
							'#btnUpdateRandomImg',
							function() {
								setRandomId($(this).closest('li').find(
										'.subimgid').text());

							});

					$('body').on(
							'click',
							'#btnUpdateSimilarImg',
							function() {
								setSimilarId($(this).closest('li').find(
										'.subimgid').text());
							});

				});
	</script>
</body>
</html>
