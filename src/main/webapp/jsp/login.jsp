<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
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
<title>ABC JOBS | LOGIN</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header.jsp" %>  
	
	
	<div class="layout" id="login">
	    <div class="container"> 
	        <div class="row">
	            <div class="col-sm-12 col-md-4 offset-md-4">
	                <div class="card card-body">
	                    <h4 class = "card-subtitle text-center">Login</h4>
	                    <form id="callMeForm" action="home" method="post">
	                    	<!-- EMAIL -->
	                        <div class="form-group">
	                            <input type="email" class="form-control-input" id="email" name="userAccount.email" 
	                            data-toggle="tooltip" data-placement="bottom"   title = "Please Fill Your Email. Must be in this form
	                            xxx@xxxxx.xxx or xxx@xxxxx.xxx.xx"
	                           >
	                            <label class="label-control" for="email">Email</label>
	                            <div class="help-block with-errors" id="error-email"></div>
	                        </div>
	
	
	                        <!-- P A S S W O R D -->
	                        <div class = "form-group">
	                            <input type = "password" class = "form-control-input" name = "userAccount.password" id = "password" 
	                            title = "Password Must be 16 characters" minlength="16" maxlength="16"
	                             data-toggle="tooltip" data-placement="bottom"  title = "Password Must be 16 characters">
	                            <label class="label-control" for="password">Password</label>
	                            <div class="help-block with-errors" id="error-password"></div>
	                        </div>
	
	
	                        <div class="form-group">
	                            <button type="submit" class="form-control-submit-button" id="submit">Login</button>
	                        </div>
	                        <div class="form-message">
	                            <div id="lmsgSubmit" class="h3 text-center hidden"></div>
	                        </div>
	                    </form>
	                    <!-- end of call me form -->
	
	                    <hr>
	                    <h4 class = "card-subtitle text-center">Forget Password?</h4>
	                    <a href="./forget-password">
	                    <button type="submit" class="form-control-submit-button-outline">Forget Password</button>
	                    </a>
	
	                </div> <!--End of Card-->
	
	            </div> <!-- end of col -->
	        </div> <!-- end of row -->
	
	    </div> <!-- end of container -->
	</div>
	
	<!--  Footer -->
	<%@ include file="./footer.jsp" %>  
	
    <!-- Scripts -->
	<%@ include file="./script.jsp" %>  
</body>
</html>