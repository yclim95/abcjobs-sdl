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
<title>ABC JOBS | FORGET PASSWORD</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header.jsp" %>  
	
	
	<div class="layout" id="forget-password">
	    <div class="container"> 
	        <div class="row">
	            <div class="col-sm-12 col-md-4 offset-md-4">
	            	
	            	<div class="card card-body vertical">	            	
	            		<p>Please enter your email address. You will receive link to create a new password via email</p>
	            	</div> <!--  Card  -->
	            	
	                <div class="card card-body mt-4">
	                    <h4 class = "card-subtitle text-center">Forget password?</h4>
	                    <form id="callMeForm" data-toggle="validator" data-focus="false" ACTION="reset-password" METHOD="POST">
	                    	<!-- EMAIL -->
	                        <div class="form-group">
	                            <input type="email" class="form-control-input" id="email" name="userAccount.email" 
	                            data-toggle="tooltip" data-placement="bottom"  title = "Please Fill Your Email. Must be in this form
	                            xxx@xxxxx.xxx or xxx@xxxxx.xxx.xx">
	                            <label class="label-control" for="email">Email Address</label>
	                            <div class="help-block with-errors" id="error-email"></div>
	                        </div>
	
	
	
	                        <div class="form-group">
	                            <button type="submit" class="form-control-submit-button" id="submit">Get new Password</button>
	                        </div>
	                        <div class="form-message">
	                            <div id="lmsgSubmit" class="h3 text-center hidden"></div>
	                        </div>
	                    </form>
	                    <!-- end of forget password form -->
	
	
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