<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evaluation Page</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html {
	background-color: #fff;
	color: #555;
	font-family: 'Lato', 'Arial', sans-serif;
	font-size: 20px;
	font-weight: 300px;
	text-rendering: optimizeLegibility;
}

.row {
	max-width: 1140px;
	margin: 0 auto 0 auto;
}

section {
	padding: 80px 0;
}
.imagedescription-div{
	width:100%;
	padding-bottom:20px;
	border:solid 2px silver;
	margin-bottom:100px;
	margin-top:20px;
}

span{
	font-weight:bold;
	color:black;
}
.hide{
visibility:hidden;
}
.rating-div{
	width:100%;
	border:1px solid silver;
	padding:10px;
	margin-top:10px;
}
.bottom-div{
	margin-top:20px;
	
	
}
input[type='submit']{
	background:blue;
	width:100px;
	height:50px;
	color:white;
	
}
.guideline{
	padding-bottom:5px;
}
.radiodiv{
	padding:5px;
}
.radiodiv input[type='radio']{
	width:30px;
	height:30px;

}
.image{
	padding-left:50px;
}
.description{
	padding-left:50px;
}
</style>

</head>

<body>
	<section>
	<div class="header row">
		<h1>Provide Ratings According to the Guidelines</h1>

	</div>

	<div class="imagedescription-div row">

		<div class="image">
			<img style="width: 404px; height: 404px" id="parentimg" alt=""
				src="${pageContext.request.contextPath}/resources/galleryimage/${descriptionObject.imagename}">
		</div>
		<div class="description">
			<span>Description written by participant:</span>
			<p>${descriptionObject.imagedescription}</p>
			<p class="descriptionid hide">${descriptionObject.imagedescriptionid}</p>
			<p class="imagetype hide">${descriptionObject.imagetype}</p>
			<span>Kind of hint that was provided during the experiment:</span>
			<p>${descriptionObject.subimagename}</p>
		</div>
	</div>
	<c:forEach items="${guidelinelist}" var="guidelines">
		<div class="rating-div row">

			<div class="guideline row">
				<span>${guidelines.guideline}</span>
			</div>
			<div class="radiodiv row">
				Strongly Disagree 1<input type="radio" value="1"
					name="guideline_${guidelines.guidelineid }"> 2<input
					type="radio" value="2" name="guideline_${guidelines.guidelineid }">3<input
					type="radio" value="3" name="guideline_${guidelines.guidelineid }">4
				<input type="radio" value="4"
					name="guideline_${guidelines.guidelineid }">Strongly Agree
			</div>

		</div>



	</c:forEach> <div class="bottom-div row"><input type="submit" value="SAVE" id="submit"></div></section>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#submit')
									.click(
											function() {

												var descriptionid = $(
														'div.description')
														.find('p.descriptionid')
														.text();
												var imagetype = $(
														'div.description')
														.find('p.imagetype')
														.text();
												var arrayObject = [];

												var objRatingOne = {
													guidelineid : "1",
													rating : $(
															'input[name=guideline_1]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingTwo = {
													guidelineid : "2",
													rating : $(
															'input[name=guideline_2]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingThree = {
													guidelineid : "3",
													rating : $(
															'input[name=guideline_3]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingFour = {
													guidelineid : "4",
													rating : $(
															'input[name=guideline_4]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingFive = {
													guidelineid : "5",
													rating : $(
															'input[name=guideline_5]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingSix = {
													guidelineid : "6",
													rating : $(
															'input[name=guideline_6]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingSeven = {
													guidelineid : "7",
													rating : $(
															'input[name=guideline_7]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												var objRatingEight = {
													guidelineid : "8",
													rating : $(
															'input[name=guideline_8]:checked')
															.val(),
													imagedescriptionid : descriptionid
												};
												arrayObject = [ objRatingOne,
														objRatingTwo,
														objRatingThree,
														objRatingFour,
														objRatingFive,
														objRatingSix,
														objRatingSeven,
														objRatingEight ];
												if (imagetype == 'graph') {
													var objRatingNine = {
														guidelineid : "9",
														rating : $(
																'input[name=guideline_9]:checked')
																.val(),
														imagedescriptionid : descriptionid
													};
													var objRatingTen = {
														guidelineid : "10",
														rating : $(
																'input[name=guideline_10]:checked')
																.val(),
														imagedescriptionid : descriptionid
													};
													arrayObject
															.push(objRatingNine);
													arrayObject
															.push(objRatingTen);
												}

												else if (imagetype == 'map') {
													var objRatingEleven = {
														guidelineid : "11",
														rating : $(
																'input[name=guideline_11]:checked')
																.val(),
														imagedescriptionid : descriptionid
													};
													var objRatingTwelve = {
														guidelineid : "12",
														rating : $(
																'input[name=guideline_12]:checked')
																.val(),
														imagedescriptionid : descriptionid
													};
													arrayObject
															.push(objRatingEleven);
													arrayObject
															.push(objRatingTwelve);
												} else if (imagetype == 'other') {
													var objRatingFourteen = {
														guidelineid : "14",
														rating : $(
																'input[name=guideline_14]:checked')
																.val(),
														imagedescriptionid : descriptionid
													};
													var objRatingFifteen = {
														guidelineid : "15",
														rating : $(
																'input[name=guideline_15]:checked')
																.val(),
														imagedescriptionid : descriptionid
													};
													arrayObject
															.push(objRatingFourteen);
													arrayObject
															.push(objRatingFifteen);
												}

												SaveRating(arrayObject);
											});
						})
		function SaveRating(arrayObject) {

			var pdata = JSON.stringify(arrayObject);
			$.ajax({
				method : 'POST',
				url : '${pageContext.request.contextPath}/saveHumanJudgement',
				dataType : 'json',
				data : pdata,
				processData : false,
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					$('input:radio').each(function() {
						$(this).prop('checked', false);
					});

				},
				error : function() {
					console.log('error occured while saving evaluaiton');
				}

			});

		}
	</script>

</body>
</html>