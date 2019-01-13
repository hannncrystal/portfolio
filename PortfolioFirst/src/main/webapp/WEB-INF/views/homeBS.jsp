<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>TITLE</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/default.css">
	
	<style>
	* {box-sizing: border-box;}

	body { 
	  margin: 0;
	  font-family: Arial, Helvetica, sans-serif;
	}
	#navbar {
	  overflow: hidden;
	  background-color: #f1f1f1;
	  padding: 20px 10px;  
	  transition: 0.4s;
	  position: fixed;
	  width: 100%;
	  top: 0;
	  z-index: 99;
	}

	#navbar #navbar-brand {
	  font-size: 35px;
	  transition: 0.4s;
	}

	#myVideo {
	   position: fixed;
	   right: 0;
	   bottom: 0;
	   min-width: 100%; 
	    min-height: 100%;
	}

	.bg-dark {
		opacity : 0.5 !important
	}

	</style>

</head>
<body>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap.bundle.min.js"></script>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="navbar">
	  <div class="container">
	    <a id="navbar-brand" class="navbar-brand" href="${pageContext.request.contextPath}/">Start Bootstrap</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	    <div class="collapse navbar-collapse" id="navbarResponsive">
	      <ul class="navbar-nav ml-auto">
	        <li class="nav-item active">
	          <a class="nav-link" href="${pageContext.request.contextPath}/member/board">Home
	                <span class="sr-only">(current)</span>
	              </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/hannncrystal/resources/join.html">JOIN</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/hannncrystal/resources/login.html">LOGIN</a>
	        </li>
  	        <li class="nav-item">
	          <a class="nav-link" href="${cp}/modifyForm">MODIFY</a>
	        </li>
     	    <li class="nav-item">
	          <a class="nav-link" href="${cp}/logout">LOGOUT</a>
	        </li>
      	    <li class="nav-item">
	          <a class="nav-link" href="${cp}/removeForm">REMOVE</a>
	        </li>
<%--       	<c:if test="${membersession != null}">
   	        <li class="nav-item">
	          <a class="nav-link" href="${cp}/modifyForm">MODIFY</a>
	        </li>
     	    <li class="nav-item">
	          <a class="nav-link" href="${cp}/logout">LOGOUT</a>
	        </li>
      	    <li class="nav-item">
	          <a class="nav-link" href="${cp}/removeForm">REMOVE</a>
	        </li>
         </c:if>  --%>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<header>
	  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	    <ol class="carousel-indicators">
	      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	    </ol>
	    <div class="carousel-inner" role="listbox">
	      <!-- Slide One - Set the background image for this slide in the line below -->
	      <div class="carousel-item active" style="background-image: url('https://source.unsplash.com/RCAhiGJsUUE/1920x1080')">
	        <div class="carousel-caption d-none d-md-block">
	        	<video autoplay muted loop id="myVideo">
				  <source src="https://www.w3schools.com/howto/rain.mp4" type="video/mp4">
				  Your browser does not support HTML5 video.
				</video>
	          <!-- <h3 class="display-4">First Slide</h3>
	          <p class="lead">This is a description for the first slide.</p> -->
	        </div>
	      </div>
	      <!-- Slide Two - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('https://source.unsplash.com/wfh8dDlNFOk/1920x1080')">
	        <div class="carousel-caption d-none d-md-block">
	          <h3 class="display-4">Second Slide</h3>
	          <p class="lead">This is a description for the second slide.</p>
	        </div>
	      </div>
	      <!-- Slide Three - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('https://source.unsplash.com/O7fzqFEfLlo/1920x1080')">
	        <div class="carousel-caption d-none d-md-block">
	          <h3 class="display-4">Third Slide</h3>
	          <p class="lead">This is a description for the third slide.</p>
	        </div>
	      </div>
	    </div>
	    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	          <span class="sr-only">Previous</span>
	        </a>
	    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	          <span class="carousel-control-next-icon" aria-hidden="true"></span>
	          <span class="sr-only">Next</span>
	        </a>
	  </div>
	</header>
	
	<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	  		<a href="${cp}/list"> LIST </a>
	  		<a href="${cp}/view"> VIEW </a>
	  		<a href="${cp}/writeForm"> WRITE </a>
	    <h1 class="display-4">Hello world!</h1>
	    <p class="lead">
	    	<br><br>The time on the server is ${serverTime}.<br><br>
    	</p>
    	<p id="dummy">
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>	
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>	
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>	
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>	
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>	
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>	
    	<br>
    		Today I want to show you how to create an amazing slide out menu or navigation for your website. The navigation will be almost hidden – the items only slide out when the user hovers over the area next to them. This gives a beautiful effect and using this technique can spare you some space on your website. The items will be semi-transparent which means that content under them will not be completely hidden.

			The icons that we will be using are from the Colorful Sticker Icon Sets 1, 2, 3 and 4 by DryIcons. (It is not allowed to redistribute them under the free license, so I cannot  include them in ZIP file of this tutorial.)
			
			Ok, let’s get to work.
		<br>
    	</p>
	  </div>
	  
	</section>
	  <div>

	  </div>	
	<section>
	
	</section>
	
	
	<script>
	// When the user scrolls down 80px from the top of the document, resize the navbar's padding and the logo's font size
	window.onscroll = function() {scrollFunction()};
	
	function scrollFunction() {
		  if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
		    document.getElementById("navbar").style.padding = "10px 10px";
		    document.getElementById("navbar-brand").style.fontSize = "25px";
		    
		  } else {
		    document.getElementById("navbar").style.padding = "20px 10px";
		    document.getElementById("navbar-brand").style.fontSize = "35px";
		  }
		}
	</script>
		
</body>
</html>