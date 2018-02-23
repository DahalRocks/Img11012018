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
.form-style-7 ul li{
	border:0px solid #fff;
	margin-left:10px;

}

body {
	font-family: Helvetica, Arial, Sans-Serif;
	background-color: #f8f7fe;
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
.guideheader{
	font-style: italic;
	font-weight: bold;
	color:blue;
	background-color:silver;
	padding-left:10px;
	
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
	color: gray;
}

.rating-div div {
	float: left;
	margin: 5px 4px;
	font-family: arial;
	font-weight: bold;
	line-height: 200%;
	text-align: left;
	color:saddlebrown;
}

.guidline-div {
	width: 100%;
	display: block;
	font-family: arial;
	text-align: left;
}

.guidline-div div {
	width: 30%;
	height: auto;
	float: left;
}
.concise{
	line-height:200%;
	font-family:arial;
}
.objective{
	line-height:200%;
	font-family:arial;
}
.language{
	line-height:200%;
	font-family:arial;
}
.img-desc-paragraph{
	font-family:arial;
	
}
.full-width{
	display:block;
	width:100%
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
	<div class="header"></div>
	<div class=" divForm main-body">
		<form action="" class="form-style-7">
			<ul class="parent-ul">
				<li id="liTitle" style="border: none"><div class="round-header">
						<p class="first-round">First Round</p>
						<p class="second-round">Second Round</p>
						<p class="third-round">Third Round</p>
						<p class="evaluation-round">Evaluation</p>
					</div></li>
				<li><div class="guidline-div"></div></li>
			</ul>
			<ul class="second-ul">
				<li><!-- <label for="parentimg"
					style="font-weight: bold; text-transform: uppercase">Write
						a Description for this image</label> --><img
					style="width: 404px; height: 404px" id="parentimg" alt=""
					src="${pageContext.request.contextPath}/resources/galleryimage/noimage.png">
					<textarea id="txtImageDescription" 
						style="width: 404px; height: 100px; border: 2px solid black; border-radius: 10px; margin-top: 10px"></textarea>
				</li>
				<li class=" exampleli hide"><label>Example Image
						Description</label><img style="width: 400px; height: 400px"
					id="exampleimage" alt="" src="">
					<div class="img-desc-paragraph"></div></li>
				<li style="border: 0px solid; margin-top:0px">
					<div class="rating-div">
						<div class="hint-div"></div>
						<div>Not Difficult</div>
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
						<div>Very Difficult</div>
						<div>
							<input type="button" value="Ok" /><label class="imageid hide"></label><label
								class="imagetype hide"></label>
						</div>
					</div>
				</li>
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
		var previoustime="";
		function showImage() {
			for (var i = 0; i < imagelst.length; ++i) {
				if (i == count) {
					$('#parentimg').attr(
							"src",
							"${pageContext.request.contextPath}/resources/galleryimage/"
									+ imagelst[i].imagename);
					$('.imageid').html(imagelst[i].imageid);
					$('.imagetype').html("no");
					if(imagelst[i].imagetype=='graph'){
						var graphguidlines="<ul>";
						graphguidlines+="<li style='font-size:30px;font-weight:bold;color:gray;border:0px solid'>";
						//graphguidlines+="Please follow these guidelines to describe the image given below";
						graphguidlines+="Please write a text description for the image given below";
						graphguidlines+="</li>";
						/* graphguidlines+="<li>";
						graphguidlines+="Provide the title and axis labels";
						graphguidlines+="</li>";
						graphguidlines+="<li>";
						graphguidlines+="Identify the image as a scatter plot and focus on the change of concentration";
						graphguidlines+="</li>";
						graphguidlines+="<li>";
						graphguidlines+="If it is necessary to be more specific, convert the data into an accessible table";
						graphguidlines+="</li>";
						graphguidlines+="<li style='border:0px solid'>";
						graphguidlines+="</li>"; */
						graphguidlines+="</ul>";
						$('.guidline-div').html(graphguidlines);
					}else if(imagelst[i].imagetype=='map'){
						var mapguidlines="<ul>";
						mapguidlines+="<li style='font-size:30px;font-weight:bold;color:gray;border:0px solid'>";
						mapguidlines+="Please write a text description for the image given below";
						mapguidlines+="</li>";
						/* mapguidlines+="<li>";
						mapguidlines+="Focus on the central teaching point of map to determine if borders, region shapes, and bodies of water are important";
						mapguidlines+="</li>";
						mapguidlines+="<li>";
						mapguidlines+="If the map is an essential part of the lesson or assessment, provide a general overview along with details and place names. Include labeled landmarks and labeled bodies of water in the description. If there are too many labels (if all 50 states are labeled on a map of the U.S., for example), focus on the labels that are most relevant to the figure and the concept it is depicting. Whenever possible, organize the description using bulleted lists and by pulling the most important information to the beginning of the description so students hear it first";
						mapguidlines+="</li>";
						mapguidlines+="<li>";
						mapguidlines+="If the map is supporting surrounding text, or if it has a detailed caption, describe general trends in the map and refer to large areas at once";
						mapguidlines+="</li>";
						mapguidlines+="<li>";
						mapguidlines+="The elements in the key can be folded in to the description of the map itself and do not need to be described separately";
						mapguidlines+="</li>";
						mapguidlines+="<li style='border:0px solid'>";
						mapguidlines+="</li>"; */
						mapguidlines+="</ul>";
						$('.guidline-div').html(mapguidlines);
					}else if(imagelst[i].imagetype=='other'){
						
						var mapguidlines="<ul>";
						mapguidlines+="<li style='font-size:30px;font-weight:bold;color:gray;border:0px solid'>";
						mapguidlines+="Please write a text description for the image given below";
						mapguidlines+="</li>";
						
						 /* var otherguidlinestitle="";
						otherguidlinestitle+="<div class='divGuideTitle' style='font-size:30px;font-weight:bold;color:gray;border:0px solid'>";
						otherguidlinestitle+="Please write a text description for the image given below";
						otherguidlinestitle+="</div>";  
						 var otherguidlines="<div class='concise'><ul>";
						 otherguidlines+="<li style='font-size:30px;font-weight:bold;color:gray;border:0px solid'>";
						otherguidlines+="Please follow these guidelines to describe the image given below";
						otherguidlines+="</li>";  
						 otherguidlines+="<li>";
						otherguidlines+="<p class='guideheader'>More is NOT better, be succinct</p><br>";
						otherguidlines+="Do not repeat information presented in the main or adjacent texts. Instead, direct readers to existing descriptions, when available (e.g. captions).";
						otherguidlines+="Include color only when it is significant (e.g. arbitrary colors assigned for elements of bar graphs and line charts need not be specified).";
						otherguidlines+="Avoid introducing new concepts or terms.";
						otherguidlines+="</li>";
						otherguidlines+="<li style='border:0px solid'>";
						otherguidlines+="</li>";
						otherguidlines+="</ul></div>";
						
						otherguidlines+="<div class='objective'><ul>";
						otherguidlines+="<li>";
						otherguidlines+="<p class='guideheader'>Describe only what you see </p><br>Physical appearances and actions rather than emotions and possible intentions.";
						otherguidlines+="Do not interpret or analyze the material. Instead, allow readers to form their own opinions.";
						otherguidlines+="Do not omit uncomfortable or controversial content, such as images associated with politics, religion, or sex.";
						otherguidlines+="</li>";
						otherguidlines+="<li style='border:0px solid'>";
						otherguidlines+="</li>";
						otherguidlines+="</ul></div>";
						
						otherguidlines+="<div class='language'><ul>";
						otherguidlines+="<li>";
						otherguidlines+="<p class='guideheader'>Use active verbs in the present tense</p><br>";
						otherguidlines+="Check spelling, grammar, and punctuation. Sometimes it is acceptable to break traditional grammar rules for brevity and clarity. However, it is important to be consistent in this practice.";
						otherguidlines+="Apply the same writing style and terminology as the surrounding text";
						otherguidlines+="Write out abbreviations and symbols to ensure proper pronunciation by screen readers.";
						otherguidlines+="Use descriptive vocabulary that adds meaning (e.g. 'map' instead of 'image').";
						otherguidlines+="</li>";
						otherguidlines+="<li style='border:0px solid'>";
						otherguidlines+="</li>"; 
						otherguidlines+="</ul></div>"; */ 
						
						$('.guidline-div').html(mapguidlines);
						//$('#liTitle').append(otherguidlinestitle);
										
					}
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
					var arr = description.split(';');
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
					var arr = description.split(';');
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
									"imagedescriptionid" : $('#imagedescriptionid').text()
									
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
												if (countdescription == "1") {
													$('.first-number')
															.removeClass(
																	'selected-number');
													$('.first-number')
															.addClass(
																	'done-number');
													$('.second-number')
															.addClass(
																	'selected-number');

												} else if (countdescription == "2") {
													$('.second-number')
															.removeClass(
																	'selected-number');
													$('.second-number')
															.addClass(
																	'done-number');
													$('.third-number')
															.addClass(
																	'selected-number');

												} else if (countdescription == "3") {
													$('.third-number')
															.removeClass(
																	'selected-number');
													$('.third-number')
															.addClass(
																	'done-number');
													$('.fourth-number')
															.addClass(
																	'selected-number');
												} else if (countdescription == "4") {
													$('.fourth-number')
															.removeClass(
																	'selected-number');
													$('.fourth-number')
															.addClass(
																	'done-number');
													$('.fifth-number')
															.addClass(
																	'selected-number');
												} else if (countdescription == "5") {
													$('.fifth-number')
															.removeClass(
																	'selected-number');
													$('.fifth-number')
															.addClass(
																	'done-number');
													$('.sixth-number')
															.addClass(
																	'selected-number');
												} else if (countdescription == "6") {
													$('.sixth-number')
															.removeClass(
																	'selected-number');
													$('.sixth-number')
															.addClass(
																	'done-number');
													$('.seventh-number')
															.addClass(
																	'selected-number');
												} else if (countdescription == "7") {
													$('.seventh-number')
															.removeClass(
																	'selected-number');
													$('.seventh-number')
															.addClass(
																	'done-number');
													$('.eighth-number')
															.addClass(
																	'selected-number');
												} else if (countdescription == "8") {
													$('.eighth-number')
															.removeClass(
																	'selected-number');
													$('.eighth-number')
															.addClass(
																	'done-number');
													$('.ninth-number')
															.addClass(
																	'selected-number');
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
						var arrParentDesc = strParentDesc.split(';');
						var html = "";
						html += '<li style="width:100%"><label for="description">Rate the follwing description</label>';
						html += '<p style="font-family:arial;line-height:145%;font-size:20px;font-weight:600">Please compare the description of given image in the first box with the description sentences available in the second box.';
						html += ' If you find it similar to the second box sentences,';
						html += ' rate it very similar, similar or not similar accordingly.</p>';
						html += '<div class="user-image-description">';
						html += '<img style="width:200px;height:200px" alt="" src="${pageContext.request.contextPath}/resources/galleryimage/'+descriptionlst[i].imagename+'"/>';
						html += '<p>Image Description:' + '"'
						+ descriptionlst[i].imagedescription + '"'
						+ '</p>';
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
						html +='<div>';
						html += '<input type="button" value="SAVE" id="btnSaveEvaluation"/>';
						html += '<p class="hide imagedescriptionid">'
								+ descriptionlst[i].imagedescriptionid + '</p>';
						html +='</div>';
						html += '</li>';
						html += '<li>';
						html += '</li>';
						$('ul.second-ul').addClass('full-width');
						$('ul.second-ul').html(html);
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
							if (descriptionlst.length) {
								showDescription();
							} else {
								var htmlnodescription = "";
								$('.round-image-number')
										.after(
												'<p>There is nothing yet to evaluate. Thank you!!</p>');
							}
						},
						error : function() {
							alert('error occured while geeting image description for evaluation!!');
						}
					});

		}
		
		function inputValue(description,imageid,imagetype,rating){
			this.imagedescription=description,
			this.imageid=imageid,
			this.imagetype=imagetype,
			this.difficultyrating=rating
		}
		function flatten(obj) {
		    var result = Object.create(obj);
		    for(var key in result) {
		        result[key] = result[key];
		    }
		    return result;
		}

		function saveImageDescription(strDataObj) {
			
			
			var currenttime=new Date($.now());
			var timediff=currenttime-previoustime;
			timediff=timediff/(60*1000);
			inputValue.prototype.timetaken=timediff;
			var pdata = JSON.stringify(flatten(strDataObj));
			
			$
					.ajax({
						method : 'POST',
						url : '${pageContext.request.contextPath}/saveImageDescription',
						dataType : 'json',
						data : pdata,
						processData : false,
						contentType : "application/json;charset=utf-8",
						success : function(result) {
							previoustime=currenttime;
							if (result) {
								$('#txtImageDescription').val(' ');
								count++;
								if (count == "1") {
									$('.first-number').removeClass(
											'selected-number');
									$('.first-number').addClass('done-number');
									$('.second-number').addClass(
											'selected-number');

								} else if (count == "2") {
									$('.second-number').removeClass(
											'selected-number');
									$('.second-number').addClass('done-number');
									$('.third-number').addClass(
											'selected-number');
								}
								if (count >= "3") {
									if (count == "3") {
										$('.first-round').removeClass(
												'selected-p');
										$('.second-round').addClass(
												'selected-p');
										
										var hinthtml = "<p>How difficult was it to write the description after having the hint with picture?</p>";
										$('.hint-div').html("");
										$('.hint-div').html(hinthtml);
										$('.guidline-div').html('');
										/* $('.divGuideTitle').remove(); */
										var motivatehtml='<p class="guideline-p" style="font-family:arial;color:gray;font-size:26px">';
										motivatehtml+='Please look at the example below to make your description better</p>'
										$('.guidline-div').html(motivatehtml);
										var progresshtml = "";
										progresshtml += '<div class="round-image-number">';
										progresshtml += '<p class="first-number selected-number">1</p>';
										progresshtml += '<p class="second-number">2</p>';
										progresshtml += '<p class="third-number ">3</p>';
										progresshtml += '</div>';
										$('.round-header').next('div').remove();
										$('.round-header').after(progresshtml);
										getImageHavingRandomSubImg();
									} else {
										countrandomsub++;
										if (countrandomsub == "1") {
											$('.first-number').removeClass(
													'selected-number');
											$('.first-number').addClass(
													'done-number');
											$('.second-number').addClass(
													'selected-number');
										} else if (countrandomsub == "2") {
											$('.second-number').removeClass(
													'selected-number');
											$('.second-number').addClass(
													'done-number');
											$('.third-number').addClass(
													'selected-number');
										}
										if (countrandomsub >= "3") {
											if (countrandomsub == "3") {
												$('.second-round').removeClass(
														'selected-p');
												$('.third-round').addClass(
														'selected-p');
												var hinthtml = "<p>How difficult was it to write the description after having the hint with similar picture?</p>";
												$('.hint-div').html("");
												$('.hint-div').html(hinthtml);
												var motivatehtml='<p class="guideline-p" style="font-family:arial;color:orange;font-size:26px">';
												motivatehtml+='This time you get very similar image as an example to improve your descriptions even better</p>'
												$('.guidline-div').html(motivatehtml);
												var progresshtml = "";
												progresshtml += '<div class="round-image-number">';
												progresshtml += '<p class="first-number selected-number">1</p>';
												progresshtml += '<p class="second-number">2</p>';
												progresshtml += '<p class="third-number ">3</p>';
												progresshtml += '</div>';
												$('.round-header').next('div')
														.remove();
												$('.round-header').after(
														progresshtml);

												getImageHavingSimilarSubImg();
											} else {
												countsimilarsub++;
												if (countsimilarsub == "1") {
													$('.first-number')
															.removeClass(
																	'selected-number');
													$('.first-number')
															.addClass(
																	'done-number');
													$('.second-number')
															.addClass(
																	'selected-number');

												} else if (countsimilarsub == "2") {
													$('.second-number')
															.removeClass(
																	'selected-number');
													$('.second-number')
															.addClass(
																	'done-number');
													$('.third-number')
															.addClass(
																	'selected-number');
												}
												if (countsimilarsub >= "3") {
													$('.third-round')
															.removeClass(
																	'selected-p');
													$('.evaluation-round')
															.addClass(
																	'selected-p');
													$("ul.second-ul").empty();
													$('.guidline-div').html('');
													var evaluationprogresshtml = "";
													evaluationprogresshtml += '<div class="hide round-image-number">';
													evaluationprogresshtml += '<p class="first-number selected-number">1</p>';
													evaluationprogresshtml += '<p class="second-number">2</p>';
													evaluationprogresshtml += '<p class="third-number ">3</p>';
													evaluationprogresshtml += '<p class="fourth-number">4</p>';
													evaluationprogresshtml += '<p class="fifth-number">5</p>';
													evaluationprogresshtml += '<p class="sixth-number">6</p>';
													evaluationprogresshtml += '<p class="seventh-number">7</p>';
													evaluationprogresshtml += '<p class="eighth-number">8</p>';
													evaluationprogresshtml += '<p class="ninth-number">9</p>';
													evaluationprogresshtml += '</div>';
													$('.round-header').next(
															'div').remove();
													$('.round-header')
															.after(
																	evaluationprogresshtml);
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
							} else {
								alert('Your session has been expired. You should log in again!!');
								window.location
										.replace('${pageContext.request.contextPath}/createuserlogin');
							}
						},
						error : function() {
							alert('Error in Image Description save!!');
						}
					});
		}

		function clearSession() {
			$
					.ajax({
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
							
							previoustime=new Date($.now());
							
							if (window.performance) {
								console
										.info("window.performance work's fine on this browser");
							}
							if (performance.navigation.type == 1) {
								console.info("This page is reloaded");

								clearSession();
								window.location
										.replace('${pageContext.request.contextPath}/createuserlogin');
							} else {
								console.info("This page is not reloaded");
							}
							;
							$('.rating-div').hide();
							$('#txtImageDescription').bind(
									'input propertychange',
									function() {

										$('.rating-div').hide();

										if ($.trim($(this).val()).length
												&& $(this).val() != "") {
											$('.rating-div').show();
										}
									});
							var hinthtml = "<p>How difficult was it to write the description?</p>";
							$('.hint-div').html("");
							$('.hint-div').html(hinthtml);
							$('.first-round').addClass('selected-p');
							var progresshtml = "";
							progresshtml += '<div class="round-image-number">';
							progresshtml += '<p class="first-number selected-number">1</p>';
							progresshtml += '<p class="second-number">2</p>';
							progresshtml += '<p class="third-number ">3</p>';
							progresshtml += '</div>';
							$('.round-header').after(progresshtml);
							getImageHavingNoSubImg();
							$('#txtImageDescription').focus();
							$('input[name=difficultyrating]').attr('checked',
									false);
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
													var rating = $(
															'input[name=difficultyrating]:checked')
															.val();
													if (rating) {
														var imageid = $(this)
																.closest('li')
																.find(
																		'.imageid')
																.text();
														var imagetype = $(this)
																.closest('li')
																.find(
																		'.imagetype')
																.text();
														var rating = $(
																'input[name=difficultyrating]:checked')
																.val();
														
														var strDataObj=new inputValue(description,imageid,imagetype,rating);
														
														saveImageDescription(strDataObj);
														$(
																'input[name=difficultyrating]')
																.attr(
																		'checked',
																		false);
														$('#txtImageDescription').val('');
													} else {
														alert('Please fill out difficulty ratings before saving description!!')
													}
												}
											})
						});
	</script>
</body>
</html>
