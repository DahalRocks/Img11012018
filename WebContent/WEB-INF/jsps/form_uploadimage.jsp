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
<title>Upload Test Pase</title>
<style type="text/css">
.par {
	visibility: hidden;
}

.popup {
	visibility: hidden;
}
color












:red








;
</style>
</head>

<body>
	<script type="text/javascript">
		function saveField() {

			var strField = {
				"title" : $("#txtTitle").val(),
				"caption" : $("#txtCaption").val(),
				"alttext" : $("#txtAltText").val(),
				"description" : $("#txtDescription").val()
			}

			var pdata = JSON.stringify(strField);

			$
					.ajax({
						dataType : 'json',
						url : "${pageContext.request.contextPath}/saveField",
						data : pdata,
						type : "POST",
						processData : false,
						contentType : false,
						success : function(result) {
							$("input[type=text]").val("");
							$("input[type=file]").val("");
							window.location
									.replace("${pageContext.request.contextPath}/callcontent"); 
						},
						error : function(result) {
							alert("error occured in saveField");
						}
					});
		}

		function saveFieldForPopUp() {
			var strField = {
				"title" : $("#txtTitle").val(),
				"caption" : $("#txtCaption").val(),
				"alttext" : $("#txtAltText").val(),
				"description" : $("#txtDescription").val()
			};
			var pdata = JSON.stringify(strField);
			$.ajax({
				dataType : 'json',
				url : "${pageContext.request.contextPath}/saveField",
				data : pdata,
				type : "POST",
				processData : false,
				contentType : false,
				success : function(result) {
					$("input[type=text]").val("");
					$("input[type=file]").val("");
				},
				error : function(result) {
					alert("error occured in saveField");
				}
			});
		}

		function doCall() {
			$.ajax({
				type : 'GET',
				dataType : 'json',
				url : '${pageContext.request.contextPath}/getReminder',
				success : function(data) {
					if (data.reminded) {

						$(".popup").addClass("popup");
						$(".par").removeClass("par");

						$("#dialog").dialog({
							width : 700
						});
					} else {

						saveFieldWithAltText();

					}
				},
				error : function() {
					alert("error occured");
				}
			});
		}

		function saveFieldWithAltText() {

			var strField = {
				"alttext" : $("#txtPopupAltText").val()
			};

			var fieldData = JSON.stringify(strField);

			$
					.ajax({
						dataType : 'json',
						url : "${pageContext.request.contextPath}/saveFieldPopUp",
						data : fieldData,
						type : "POST",
						processData : false,
						contentType : "application/json; charset=utf-8",
						success : function(result) {
							window.location
									.replace("${pageContext.request.contextPath}/callcontent"); 
						},
						error : function(result) {
							alert("Error occured in saveFieldPopup");
						}
					});
		}

		$(document).ready(function() {
			$("#btnOk").click(function() {

				var el = document.getElementById('lblImageName');
				var text = (el.innerText || el.textContent);
				if (text.length != 0) {
					var altText = $("#txtAltText").val();

					if (altText.length == 0) {
						saveFieldForPopUp();
						doCall();
					}

					else {
						saveField();
					}
				} else {
					alert("Please select an image before upload!!");

				}
			});
			$("#btnPopUpSubmit").click(function() {
				saveFieldWithAltText();

			});
			$("#linkDialogClose").click(function() {
				saveFieldWithAltText();

			});
			$("#btnSelect").click(function() {
				$(".popup").removeClass("popup");

				$("#imagelistDialog").dialog({
					width : 700
				});
			});

			$("#lnkSelect").click(function() {
				$(".popuplst").addClass("popup");

			});

		});
	</script>
	<div class="divForm">
		<sf:form class="form-style-7" action="" method="post"
			commandName="imagename">
			<ul>
				<!-- <li><label for="fileLoader">Upload Image</label> <input type="file"
					name="file" id="fileLoader" /></li> -->
				<li style="font-family: arial; font-size: 16px; font-weight: bold">Upload
					for: ${title}</li>
				<li><input id="btnSelect" type="button"
					value="Click to select an image" /></li>
				<li><img alt=""
					src="${pageContext.request.contextPath}/resources/galleryimage/${imagename}"
					style="width: 50px; height: 50px"> <label id="lblImageName"
					aria-label="nameofimage">${imagename}</label></li>
				<li><label for="txtTitle">Title</label> <input type="text"
					name="title" id="txtTitle" /> <span>Enter title for image</span></li>
				<li><label for="txtCaption">Caption</label> <input type="text"
					name="caption" id="txtCaption" /><span>Enter caption for
						image</span></li>
				<li><label for="txtAltText">Alt-text</label> <input type="text"
					name="alttext" id="txtAltText" /><span>Enter alt-text for
						image</span></li>
				<li><label for="txtDescription">Description</label> <input
					type="text" name="description" id="txtDescription" /><span>Enter
						description for image</span></li>
				<li><input id="btnOk" type="button" value="Upload" /> or <a
					id="linkFileCancel"
					href="${pageContext.request.contextPath}/callcontent">Cancel</a></li>
			</ul>
		</sf:form>

	</div>
	<div id="dialog" title="Reminder">
		<div class="divForm par">
			<form class="form-style-7" action="" method="post"
				commandName="imagename">
				<ul>
					<li>
						<p>
							<b>Oops!! Sorry for the interruption but you forgot to write
								description to this image which is important because: </b><br /> <br />
							<i>1) It helps Google to find this image in Web so will be
								easier to get popular.</i><br /> <br /> <i> 2) A blind and low
								vision person can visualize this picture with the help of your
								description. </i><br /> <br /> <i>3) And even the people
								having slow internet access can get what your image contains
								without downloading the actual image. </i><br /> <br /> <b>So
								why not to write some lines of text that explain your image
								better..</b><br /> <img alt=""
								src="${pageContext.request.contextPath}/resources/img/smile icon.ico"
								style="width: 50px; height: 50px"><br /> <b>It will
								be a great job!! Congratulations!!</b><img alt=""
								src="${pageContext.request.contextPath}/resources/img/congratulation.png"
								style="width: 50px; height: 50px">
						</p>
					</li>
					<li><img
						src="${pageContext.request.contextPath}/resources/galleryimage/${imagename}"
						alt="" style="width: 100px; height: 100px" id="popupImg"></li>

					<li><label for="alttext">Alt-text</label> <textarea
							id="txtPopupAltText" style="width: 200px; height: 50px"></textarea>
						<br /> <span>Enter alt-text for image</span></li>

					<li><input id="btnPopUpSubmit" type="button" value="SUBMIT" />
						or <a href="#" id="linkDialogClose">CLOSE</a></li>
				</ul>
			</form>
		</div>
	</div>

	<div id="imagelistDialog" title="Image list">
		<div class="divForm popuplst popup">
			<sf:form id="imagegallery" action=" " commandName="imagelst">
				<c:forEach var="image" items="${ imagelst}">
					<div class="grid-item">
						<figure> <img
							src="${pageContext.request.contextPath}/resources/galleryimage/${image.imagename}"
							alt="Image" class="img-fluid tm-img"
							style="width: 100px; height: 100px"> </figure>

						<a
							href="${pageContext.request.contextPath}/uploadselectedimage?name=${image.imagename}"
							id="lnkSelect">Select<c:out value="${image.imageid}" /></a>
					</div>
				</c:forEach>
			</sf:form>
		</div>
	</div>
</body>
</html>
