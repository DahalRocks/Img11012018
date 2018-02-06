<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.hide {
	visibility: hidden;
}

form.form-style-7 {
	max-width: 1140px;
}

body {
	font-family: Helvetica, Arial, Sans-Serif;
	background-color:#f8f7fe;
}

h1 {
	text-align: center;
	text-transform: uppercase;
	font-family: arial;
	font-weight: 300;
	margin: 0 auto;
	opacity: 0.5;
}

h1:after {
	width: 200px;
	height: 2px;
	background-color: black;
	margin: 10px auto;
	display: block;
	content: " ";
}

span {
	font-style: italic;
	font-weight: bold;
	color: #0048ce;
}

.round-header {
	width: 100%;
	height: 50px;
	background-color: #0054f0;
	text-align: center;
	border-radius: 30px;
}

.round-header p {
	color: #fff;
	font-weight: bold;
	font-size: 10px;
	text-transform: uppercase;
	font-family: arial;
	display: block;
	float: left;
	margin-left: 15%;
}
/* .round-header p:hover{
	transform: scale(1.50);
	opacity:1;
} */
.selected-p {
	transform: scale(1.50);
	transition: transform 0.5s, opacity 0.5s;
	border: 1px solid #fff;
}

.form-style-7 ul li img {
	border-radius: 30px;
	padding-top: 10px;
}

.description-list {
	color: blue;
}

div.user-image-description, div.parent-image-description {
	text-align: center;
	margin-top: 10px;
	width: 100%;
	height: 100%;
	border: 1px solid silver;
	font-family: arial;
}

div.radio-div {
	width: 100%;
	height: 100%;
	display: block;
}

div.radio-div p {
	float: left;
	margin: 15px 5px 0 5px;
}

.round-image-number {
	width: 100%;
	height: 33px;
	background-color: #fff;
	text-align: center;
	border-radius: 10px;
	margin-top: 5px;
	display: block;
	color: #b2beaf;
}

.selected-number {
	color: #fff;
	background-color: #0054f0;
	transform: scale(1.15);
	transition: transform 0.5s;
}

.done-number {
	background-color: #5792ff;
}

.round-image-number p {
	border: 1px solid #859880;
	width: 7%;
	height: auto;
	margin: 5px 10px;
	float: left;
	scale: 0.95;
}

.second-ul {
	width: 100%;
	display: block;
}

.second-ul li {
	width: 35%;
	float: left;
	margin: 47px;
	text-align: left;
}

.rating-div {
	width: 100%;
	display: block;
	margin-top: 5px;
}

.rating-div div {
	float: left;
	margin: 5px 15px;
	font-family: arial;
	font-weight: bold;
	line-height: 200%;
	text-align: left;
}

input[type='button'] {
	margin: 20px 15px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Experiment Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainold.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">

</head>
<body>
	<div class="header">
		<h1>Write a description for the following images</h1>
	</div>
	<div class=" divForm main-body">
		<form action="" class="form-style-7">
			<ul class="parent-ul">
				<li style="border: none"><div class="round-header">
						<p class="first-round">First Round</p>
						<p class="second-round">Second Round</p>
						<p class="third-round">Third Round</p>
						<p class="evaluation-round">Evaluation</p>
					</div></li>
			</ul>
			<ul class="second-ul">
				<!-- <li class=" exampleli hide"><label>Example
						Image to show how does an image description look like</label><img
					style="width: 200px; height: 200px" id="exampleimage" alt="" src="">
					<div class="img-desc-paragraph"></div></li> -->
				<li><label for="parentimg"
					style="font-weight: bold; text-transform: uppercase">Write
						a Description for this image</label><img
					style="width: 250px; height: 250px" id="parentimg" alt=""
					src="${pageContext.request.contextPath}/resources/galleryimage/bull.jpg">

					<textarea id="txtImageDescription" rows="50" cols="50"
						style="width: 100%; height: 100px; border: 2px solid black; border-radius: 10px; margin-top: 10px"></textarea>

					<div class="rating-div">
						<div>
							How difficult was it to write the description? <br> 1 for
							not difficult at all and 4 for very difficult.
						</div>
						<div>1</div>
						<div>
							<input type="radio" value="1" name="difficultyrating" />
						</div>
						<div>2</div>
						<div>
							<input type="radio" value="2" name="difficultyrating" />
						</div>
						<div>3</div>
						<div>
							<input type="radio" value="3" name="difficultyrating" />
						</div>
						<div>4</div>
						<div>
							<input type="radio" value="4" name="difficultyrating" />
						</div>

					</div> <input type="button" value="Ok" /><label class="imageid hide"></label><label
					class="imagetype hide"></label></li>


				<li class=" exampleli hide"><label>Example Image
						Description</label><img style="width: 200px; height: 200px"
					id="exampleimage" alt="" src="">
					<div class="img-desc-paragraph"></div></li>




				<!-- <li
				
				
					style="border: 2px solid black; border-radius: 30px"><label
					for="txtImageDescription">Image Description</label> 
						</li> -->




			</ul>




		</form>


	</div>
	<script type="text/javascript">
		var count = 0;
		var countrandomsub = 0;
		var countsimilarsub = 0;
		var countdescription = 0;
		var imagelst = "";
		var imagelstwithrandomsubimg = "";
		var imagelstwithsimilarsubimg = "";
		var descriptionlst = "";
		function showImage() {

			for (var i = 0; i < imagelst.length; ++i) {
				if (i == count) {
					$('#parentimg').attr(
							"src",
							"${pageContext.request.contextPath}/resources/galleryimage/"
									+ imagelst[i].imagename);
					$('.imageid').html(imagelst[i].imageid);
					$('.imagetype').html("no");
				}

			}
		}

		function showImageWithRandomSubImg() {

			for (var i = 0; i < imagelstwithrandomsubimg.length; ++i) {
				if (i == countrandomsub) {

					$('.img-desc-paragraph').html("");
					$('#exampleimage').attr(
							"src",
							"${pageContext.request.contextPath}/resources/galleryimage/"
									+ imagelstwithrandomsubimg[i].subimagename);

					var description = imagelstwithrandomsubimg[i].randomimagedescription;
					var arr = description.split('.');

					if (arr.length > "1") {
						var htmldescriptionlst = "<div class=\"description-list\">";

						$.each(arr, function(i, val) {

							if (val) {
								htmldescriptionlst += "<p>" + "\"" + val + "\""
										+ "</p>";

							}
						});
						htmldescriptionlst += "</div>";
						$('.img-desc-paragraph').html(htmldescriptionlst);
					} else {
						$('.img-desc-paragraph').html(
								"<span> Image description:</span>" + "   "
										+ "\"" + description + "  " + "\"");
					}

					$('.exampleli').removeClass('hide');

					$('#parentimg').attr(
							"src",
							"${pageContext.request.contextPath}/resources/galleryimage/"
									+ imagelstwithrandomsubimg[i].imagename);
					$('.imageid').html(imagelstwithrandomsubimg[i].imageid);
					$('.imagetype').html(imagelstwithrandomsubimg[i].imagetype);
				}

			}
		}

		function showImageWithSimilarSubImg() {

			for (var i = 0; i < imagelstwithsimilarsubimg.length; ++i) {
				if (i == countsimilarsub) {

					$('.img-desc-paragraph').html("");
					$('#exampleimage')
							.attr(
									"src",
									"${pageContext.request.contextPath}/resources/galleryimage/"
											+ imagelstwithsimilarsubimg[i].subimagename);

					var description = imagelstwithsimilarsubimg[i].similarimagedescription;
					var arr = description.split('.');

					if (arr.length > "1") {
						var htmldescriptionlst = "<div class=\"description-list\">";
						$.each(arr, function(i, val) {
							if (val) {
								htmldescriptionlst += "<p>" + "\"" + val + "\""
										+ "</p>";
							}
						});
						htmldescriptionlst += "</div>";
						$('.img-desc-paragraph').html(htmldescriptionlst);
					} else {
						$('.img-desc-paragraph').html(
								"<span> Image description:</span>" + "   "
										+ "\"" + description + "  " + "\"");
					}

					$('#parentimg').attr(
							"src",
							"${pageContext.request.contextPath}/resources/galleryimage/"
									+ imagelstwithsimilarsubimg[i].imagename);
					$('.imageid').html(imagelstwithsimilarsubimg[i].imageid);
					$('.imagetype')
							.html(imagelstwithsimilarsubimg[i].imagetype);

				}

			}
		}

		function getImageHavingNoSubImg() {

			$
					.ajax({
						method : 'POST',
						url : "${pageContext.request.contextPath}/getImageHavingNoSubImg",
						dataType : 'json',
						processData : false,
						contentType : false,
						success : function(data) {
							imagelst = data;
							showImage();
						},
						error : function() {
							alert('error occured in getting image having no sub images!');
						}

					});

		}

		function getImageHavingRandomSubImg() {
			$
					.ajax({
						method : 'POST',
						dataType : 'json',
						url : '${pageContext.request.contextPath}/getImageHavingRandomSubImg',
						processData : false,
						contentType : false,
						success : function(data) {
							imagelstwithrandomsubimg = data;
							showImageWithRandomSubImg();
						},
						error : function() {
							alert('error occured in getting image having sub images!!');
						}
					});

		}
		function getImageHavingSimilarSubImg() {
			$
					.ajax({
						method : 'POST',
						dataType : 'json',
						url : '${pageContext.request.contextPath}/getImageHavingSimilarSubImg',
						processData : false,
						contentType : false,
						success : function(data) {
							imagelstwithsimilarsubimg = data;
							showImageWithSimilarSubImg();
						},
						error : function() {
							alert('error occured in getting image having sub images!!');
						}
					});

		}
		$(document)
				.on(
						"click",
						"#btnSaveEvaluation",
						function() {
							var strRating = $(
									'input[name="evaluationstring"]:checked')
									.val();
							if (strRating) {
								var strEvaluation = {
									"evaluationstring" : strRating,
									"imagedescriptionid" : $(this)
											.closest('li').find('p').text()
								};
								var pdata = JSON.stringify(strEvaluation);

								$
										.ajax({
											method : 'POST',
											url : '${pageContext.request.contextPath}/saveEvaluation',
											dataType : 'json',
											data : pdata,
											processData : false,
											contentType : "application/json;charset=utf-8",
											success : function(result) {

												countdescription++;
												if(countdescription=="1"){
													$('.first-number').removeClass('selected-number');
													$('.first-number').addClass('done-number');
													$('.second-number').addClass('selected-number');
																									
												}else if(countdescription=="2"){
													$('.second-number').removeClass('selected-number');
													$('.second-number').addClass('done-number');
													$('.third-number').addClass('selected-number');
													
												}else if(countdescription=="3"){
													$('.third-number').removeClass('selected-number');
													$('.third-number').addClass('done-number');
													$('.fourth-number').addClass('selected-number');
												}else if(countdescription=="4"){
													$('.fourth-number').removeClass('selected-number');
													$('.fourth-number').addClass('done-number');
													$('.fifth-number').addClass('selected-number');
												}else if(countdescription=="5"){
													$('.fifth-number').removeClass('selected-number');
													$('.fifth-number').addClass('done-number');
													$('.sixth-number').addClass('selected-number');
												}else if(countdescription=="6"){
													$('.sixth-number').removeClass('selected-number');
													$('.sixth-number').addClass('done-number');
													$('.seventh-number').addClass('selected-number');
												}else if(countdescription=="7"){
													$('.seventh-number').removeClass('selected-number');
													$('.seventh-number').addClass('done-number');
													$('.eighth-number').addClass('selected-number');
												}else if(countdescription=="8"){
													$('.eighth-number').removeClass('selected-number');
													$('.eighth-number').addClass('done-number');
													$('.ninth-number').addClass('selected-number');
													window.location
													.replace("${pageContext.request.contextPath}/thankyoupage");
												}
												
												showDescription();

											},
											error : function() {
												alert("error occured while saving evaluation!!");
											}
										});

							} else {
								alert("Provide ratings before save!!");
							}

						});

		function showDescription() {
			if (descriptionlst) {
				$('.round-image-number').removeClass('hide');
				for (var i = 0; i < descriptionlst.length; ++i) {
					if (i == countdescription) {
						var strParentDesc = descriptionlst[i].parentimagedescription;
						var arrParentDesc = strParentDesc.split('.');
						var html = "";
						html += '<li><label for="description">Rate the follwing description</label>';
						html += '<p>Please compare the sentence given in the first box with the sentences available in the second box.';
						html += ' If you think the first box sentence is similar to any of the second box sentences,';
						html += ' rate it very similar, similar or not similar accordingly.</p>';
						html += '<div class="user-image-description">';
						html += '<p>' + '"'
								+ descriptionlst[i].imagedescription + '"'
								+ '</p>';
						html += '<img style="width:200px;height:200px" alt="" src="${pageContext.request.contextPath}/resources/galleryimage/'+descriptionlst[i].imagename+'"/>';
						
						html += '</div>';
						html += '<div class="parent-image-description">';
						$.each(arrParentDesc, function(i, val) {
							if (val) {
								html += "<p>" + "\"" + val + "\"" + "</p>";
							}
						});

						html += '</div>';
						html += '<div class="radio-div">';

						html += '<p>Not Similar';
						html += '<input type="radio" name="evaluationstring" value="notsimilar"/></p>';

						html += '<p>Similar';
						html += '<input type="radio" name="evaluationstring" value="similar"/></p>';

						html += '<p>Very Similar';
						html += '<input type="radio" name="evaluationstring" value="verysimilar"/></p>';

						html += '</div>';

						html += '</li>';
						html += '<li>';
						html += '<input type="button" value="SAVE" id="btnSaveEvaluation"/>';
						html += '<p class="hide imagedescriptionid">'
								+ descriptionlst[i].imagedescriptionid + '</p>';
						html += '</li>';
						/* $("ul li:not(:first-child)").remove();
						$("ul li:first").after(html); */
						$('ul.second-ul').html(html);

					
						/* <div class="rating-evaluation-div">
						<div>
							How difficult was it to write the description? <br> 1 for
							not difficult at all and 4 for very difficult.
						</div>
						<div>1</div>
						<div>
							<input type="radio" value="1" name="difficultyrating" />
						</div>
						<div>2</div>
						<div>
							<input type="radio" value="2" name="difficultyrating" />
						</div>
						<div>3</div>
						<div>
							<input type="radio" value="3" name="difficultyrating" />
						</div>
						<div>4</div>
						<div>
							<input type="radio" value="4" name="difficultyrating" />
						</div>

					</div>
						
						var ratinghtml='<p>';
						ratinghtml+=''
						ratinghtml+='</p>';
						var generalhtml='<li>';
						
						generalhtml+='<div>New concept that does not include by the image has been introduced in the description</div>';
						
						generalhtml +='</li>';
					
					var graphhtml="";
					var maphtml=""; */
					
					
					
					}

				}

			} else {
				alert("No description to evaluate!!");
			}

		}

		function callImageDescriptionToEvaluate() {
			$
					.ajax({
						method : 'POST',
						dataType : 'json',
						url : '${pageContext.request.contextPath}/callImageDescriptionToEvaluate',
						processData : false,
						contentType : false,
						success : function(data) {
							descriptionlst = data;
							if(descriptionlst.length){
								showDescription();	
							}else{
								var htmlnodescription="";
								$('.round-image-number').after('<p>There is nothing yet to evaluate. Thank you!!</p>');
							}
						},
						error : function() {
							alert('error occured while geeting image description for evaluation!!');
						}

					});

		}

		function saveImageDescription(strData) {
			var pdata = JSON.stringify(strData);
			$
					.ajax({
						method : 'POST',
						url : '${pageContext.request.contextPath}/saveImageDescription',
						dataType : 'json',
						data : pdata,
						processData : false,
						contentType : "application/json;charset=utf-8",
						success : function(result) {
							if(result){
								$('#txtImageDescription').val(' ');
								count++;
								if(count=="1"){
									$('.first-number').removeClass('selected-number');
									$('.first-number').addClass('done-number');
									$('.second-number').addClass('selected-number');
																					
								}else if(count=="2"){
									$('.second-number').removeClass('selected-number');
									$('.second-number').addClass('done-number');
									$('.third-number').addClass('selected-number');
									
								}
								
								if (count >= "3") {

									if (count == "3") {
										$('.first-round').removeClass('selected-p');
										$('.second-round').addClass('selected-p');
										
										var progresshtml="";
										progresshtml+='<div class="round-image-number">';
										progresshtml+='<p class="first-number selected-number">1</p>';
										progresshtml+='<p class="second-number">2</p>';
										progresshtml+='<p class="third-number ">3</p>';
										progresshtml+='</div>';
										
										$('.round-header').next('div').remove();
										$('.round-header').after(progresshtml);
										
										getImageHavingRandomSubImg();
									} else {
										countrandomsub++;
										if(countrandomsub=="1"){
											$('.first-number').removeClass('selected-number');
											$('.first-number').addClass('done-number');
											$('.second-number').addClass('selected-number');
																							
										}else if(countrandomsub=="2"){
											$('.second-number').removeClass('selected-number');
											$('.second-number').addClass('done-number');
											$('.third-number').addClass('selected-number');
											
										}
													
										if (countrandomsub >= "3") {
											if (countrandomsub == "3") {
												$('.second-round').removeClass(
														'selected-p');
												$('.third-round').addClass(
														'selected-p');
												
												var progresshtml="";
												progresshtml+='<div class="round-image-number">';
												progresshtml+='<p class="first-number selected-number">1</p>';
												progresshtml+='<p class="second-number">2</p>';
												progresshtml+='<p class="third-number ">3</p>';
												progresshtml+='</div>';
												$('.round-header').next('div').remove();
												$('.round-header').after(progresshtml);
															
												getImageHavingSimilarSubImg();
											} else {
												countsimilarsub++;
												
												if(countsimilarsub=="1"){
													$('.first-number').removeClass('selected-number');
													$('.first-number').addClass('done-number');
													$('.second-number').addClass('selected-number');
																									
												}else if(countsimilarsub=="2"){
													$('.second-number').removeClass('selected-number');
													$('.second-number').addClass('done-number');
													$('.third-number').addClass('selected-number');
													
												}
												
												if (countsimilarsub >= "3") {
													$('.third-round').removeClass(
															'selected-p');
													$('.evaluation-round')
															.addClass('selected-p');

													//evaluation round starts here//
													/* $("ul.second-ul li:not(:first-child)")
															.remove(); */
													$("ul.second-ul").empty();
													
													var evaluationprogresshtml="";
													evaluationprogresshtml+='<div class="hide round-image-number">';
													evaluationprogresshtml+='<p class="first-number selected-number">1</p>';
													evaluationprogresshtml+='<p class="second-number">2</p>';
													evaluationprogresshtml+='<p class="third-number ">3</p>';
													evaluationprogresshtml+='<p class="fourth-number">4</p>';
													evaluationprogresshtml+='<p class="fifth-number">5</p>';
													evaluationprogresshtml+='<p class="sixth-number">6</p>';
													evaluationprogresshtml+='<p class="seventh-number">7</p>';
													evaluationprogresshtml+='<p class="eighth-number">8</p>';
													evaluationprogresshtml+='<p class="ninth-number">9</p>';
													evaluationprogresshtml+='</div>';
													$('.round-header').next('div').remove();
													$('.round-header').after(evaluationprogresshtml);
													callImageDescriptionToEvaluate();

												} else {
													showImageWithSimilarSubImg();
												}

											}
										} else {
											showImageWithRandomSubImg();
										}

									}

								} else {
									showImage();
								}

								$('#txtImageDescription').focus();
								
								
							}else{
								alert('Your session has been expired. You should log in again!!');
								window.location.replace('${pageContext.request.contextPath}/createuserlogin');
							}
							

						},
						error : function() {
							alert('Error in Image Description save!!');
						}

					});
		}
		
		function clearSession(){
			$.ajax({
				method : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath}/clearSession',
				processData : false,
				contentType : false,
				success : function(data) {
					alert('Your session expired with the page refresh. Please log in again!!');
				},
				error : function() {
					alert('error occured while clearing user session!!');
				}
				
				
			});
			
		}
		
		

		$(document)
				.ready(
						function() {
														
							if (window.performance) {
								  console.info("window.performance work's fine on this browser");
								}
								  if (performance.navigation.type == 1) {
								    console.info( "This page is reloaded" );
								    
								    clearSession();
								    window.location
									.replace('${pageContext.request.contextPath}/createuserlogin');
								  } else {
								    console.info( "This page is not reloaded");
								  };
								 
								  $('.rating-div').hide();
							
								  $('#txtImageDescription').bind('input propertychange', function() {

								     
								      $('.rating-div').hide();
								      
								      if($.trim($(this).val()).length
												&& $(this).val() != ""){
								    	   	  $('.rating-div').show();
								      }
								});
							$('.first-round').addClass('selected-p');
							var progresshtml="";
							progresshtml+='<div class="round-image-number">';
							progresshtml+='<p class="first-number selected-number">1</p>';
							progresshtml+='<p class="second-number">2</p>';
							progresshtml+='<p class="third-number ">3</p>';
							progresshtml+='</div>';
							$('.round-header').after(progresshtml);
							getImageHavingNoSubImg();
							
							$('#txtImageDescription').focus();
							$('input[name=difficultyrating]').attr('checked',false);
							$('input:button')
									.click(
											function() {
												var description = $(
														'#txtImageDescription')
														.val();
												if (!$.trim(description).length
														&& $(this).val() != "") {
													alert('Image description can not be empty!!');
												} else {
													
													var rating=$('input[name=difficultyrating]:checked').val();
													if(rating){
														var imageid = $(this)
														.closest('li')
														.find('.imageid')
														.text();
														var imagetype = $(this)
															.closest('li')
															.find('.imagetype')
															.text();
														var rating=$('input[name=difficultyrating]:checked').val();
														
														var strData = {
															"imagedescription" : description,
															"imageid" : imageid,
															"imagetype" : imagetype,
															"difficultyrating":rating
														}
														saveImageDescription(strData);
														$('input[name=difficultyrating]').attr('checked',false);
													}else{
														alert('Please fill out difficulty ratings before saving description!!')
													}
																								
												}
											})

						});
	</script>
</body>
</html>
