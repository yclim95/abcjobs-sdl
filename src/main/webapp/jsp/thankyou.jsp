<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- SEO Meta Tags -->
    <meta name="description" content="ABC Jobs is a platform to start your career and professional networking">
    <meta name="keywords" content="HTML, CSS, JavaScript, Python, Full-Stack Web Development">
    <meta name="author" content="ABC Jobs">

    <!-- OG Meta Tags to improve the way the post looks when you share the page on LinkedIn, Facebook, Google+ -->
	<meta property="og:site_name" content="ABC Jobs" /> <!-- website name -->
	<meta property="og:site" content="www.abcjobs.com" /> <!-- website link -->
	<meta property="og:title" content="ABC JOBS -  Your doorstep to start your career and networking platform"/> <!-- title shown in the actual shared post -->
	<meta property="og:description" content="ABC Jobs is a platform to start your career and professional networking" /> <!-- description shown in the actual shared post -->
	<meta property="og:type" content="article" />
	
	    <!-- Website Title -->
    <title>ABC Jobs | Thank You Page</title>
    
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:500,700&display=swap&subset=latin-ext" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600&display=swap&subset=latin-ext" rel="stylesheet">
    <link href="./css/vendor/bootstrap.min.css" rel="stylesheet"> <!--Bootstrap-->
    <link href="./css/style.css" rel="stylesheet"> <!-- Custom CSS -->
    <link href="./css/menu.css" rel="stylesheet"> <!-- Custom CSS -->

	
	<!-- Favicon  -->
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
    <link rel="icon" href="./img/favicon.ico" type="image/x-icon">
</head>
 <body data-spy="scroll" data-target=".fixed-top">
    
	<!--  Header -->
	<%@ include file="./header.jsp" %>  
	
    
    
   	<div class="layout" id="thankyou">
	    <div class="container"> 
	        <div class="row">
	            <div class="col-sm-12 col-md-4 offset-md-4">
	                <div class="card card-body">
	                    <h4 class = "card-subtitle text-center">Thank You For Registering!</h4>
	                    <p>Please check your email for registration confirmation.</p>
	                     <hr>
	                    <h4 class = "card-subtitle text-center">Already Registered an account</h4>
	                    <a href="./login">
	                    <button type="submit" class="form-control-submit-button-outline">Login</button>
	                    </a>
	                </div> <!--End of Card-->
	
	            </div> <!-- end of col -->
	        </div> <!-- end of row -->
	
	    </div> <!-- end of container -->
	</div>
    
    
	<!--  Footer -->
	<%@ include file="./footer.jsp" %>  

    <!-- Scripts -->
    <script src="./js/vendor/jquery.js"></script> <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> <!-- jQuery for Bootstrap's JavaScript plugins -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script> <!-- Popper tooltip library for Bootstrap -->  
    <script src="./js/vendor/bootstrap.min.js"></script> <!-- Bootstrap -->  
    <script src="./js/script.js"></script> <!-- Custom scripts: menu navigation & back to top -->
    <script src="./js/validation.js"></script> <!-- Custom scripts: Form validation -->
    <script src="https://kit.fontawesome.com/9c3090892c.js" crossorigin="anonymous"></script> <!-- FONT AWESOME -->
</body>
</html>