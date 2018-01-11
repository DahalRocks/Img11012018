<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
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
<title>Home page</title>
<meta charset="utf-8">
<meta name="dhruba" content="">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/rest.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<header>
	<div class="wrapper">
		<a href="#"><img
			src="${pageContext.request.contextPath}/resources/img/universal-design-logo.jpg"
			class="h_logo" alt="logo" title=""></a>
		<nav>
		<ul class="main_nav">
			<li class="current"><a href="#">Home</a></li>
			<li><a href="#">Project</a></li>
			<li><a href="#">Achievement</a></li>
			<li><a href="#">CV</a></li>
		</ul>
		</nav>
	</div>
	</header>
	</header>
	<!-- Header End -->
<body>
	
	<section class="main wrapper"> <c:forEach var="text"
		items="${textlst }">
		<c:forEach begin="0" end="10" step="1" varStatus="loop">
			<c:if test="${text.division==loop.count}">
				<article> <c:forEach var="image" items="${imagelst }">
					<c:if test="${image.division==loop.count}">
						<div class="article_image">
							<img
								src="${pageContext.request.contextPath}/resources/galleryimage/${image.url}"
								alt="${image.alttext}" title="${image.title}" tabindex="0">
						</div>
					</c:if>
				</c:forEach>
				<div class="post">
					<h1 class="title">
						<a href="#">${text.contenttitle}</a>
					</h1>
					<p>${text.content}</p>
					
					
					<a id="linkPicOne"
						href="${pageContext.request.contextPath}/createimageform/${loop.count}/${text.contenttitle}">
						image upload link for this content </a>
				</div>
				</article>
			</c:if>
		</c:forEach>
	</c:forEach> <nav class="pagination"> <!-- <a href="#" class="previous"><i></i>Previous</a> -->
	<a href="${pageContext.request.contextPath}/callimagelist" class="next">CLICK TO FINISH<i></i></a> </nav><!-- Pagination End --> </section>
	<!-- Main End -->
	<footer>
	<div class="wrapper">
		<img class="logo_footer"
			src="${pageContext.request.contextPath}/resources/img/dhruba-image.jpg"
			alt="Blogin" title="">
		<p class="rights">
			© 2017 Dhruba Dahal - All Rights Reserved <a href="linkedin"
				target="_blink">Know about me</a>
		</p>
		<ul class="social_profiles">
			<li class="f"><a href="" target="_blink"></a></li>
			<li class="t"><a href="" target="_blink"></a></li>
			<li class="be"><a href="" target="_blink"></a></li>
			<li class="d"><a href="" target="_blink"></a></li>
		</ul>
	</div>
	</footer>
	<!-- Footer End -->

	
</body>
</html>