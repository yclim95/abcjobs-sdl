<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<title>ABC JOBS | UPDATE PROFILE</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header-login-user.jsp" %>  
	
	
        <!-- Users -->
        <div id="profile-update" class="layout">
            <div class="container">        
                <div class="row">
                
             		<div class="col-lg-2 col-xs-12">
                		<!-- Vertical menu -->
						<nav class="navbar vertical-menu">
							<ul class="nav flex-column">
							  <li class="nav-item">
							    <a class="nav-link" href="./home-user"><i class="fas fa-home"></i> Home</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link active disabled"><i class="fas fa-user-plus"></i> Networks</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="./profile"><i class="fas fa-user"></i> Profile</a>
							  </li>
							</ul>
						</nav> <!-- Vertical menu -->
                	</div> <!-- end of col -->
                	
                    <div class="col-lg-10 col-xs-12">
       	                <div class="card card-body">
	                    <h4 class = "card-subtitle text-center">Update Profile</h4>
	                    <form id="callMeForm" action="profile-update-process" method="post">
	                   
	                   		<!--  First Name -->
   	                        <div class="form-group row">
   	                            <label class="col-sm-2 col-form-label" for="fname">First Name</label>
   	                            <div class="col-sm-10">
                              	    <s:textfield name="user.firstName" value="%{user.firstName}" id="fname"
                              	    cssClass="form-control"
                              	    data-toggle="tooltip" data-placement="bottom" title = "Please Fill this. First name must not include number" />
   	                            </div>
	                            <div class="help-block with-errors" id="error-fname"></div>
	                        </div>
	                        
	                   		<!--  Last Name -->
   	                        <div class="form-group row">
   	                            <label class="col-sm-2 col-form-label" for="userlname">Last Name</label>
   	                            <div class="col-sm-10">
       	                            <s:textfield cssClass="form-control" id="lname" name="user.lastName" 
       	                            data-toggle="tooltip" data-placement="bottom"
	                                title = "Please Fill this. Last name must not include number"
	                                value = "%{user.lastName}" />
   	                            </div>
	                            <div class="help-block with-errors" id="error-lname"></div>
	                        </div>
	                        
	                    	<!-- EMAIL -->
	                        <div class="form-group row">
   	                            <label class="col-sm-2 col-form-label" for="email">Email</label>
   	                            <div class="col-sm-10">
       	                            <s:textfield cssClass="form-control" id="email" name="userAccount.email" 
	                            value ="%{userAccount.email}" readonly="true"/>
	                            <div class="help-block with-errors" id="error-email"></div>
   	                            </div>
	                        </div>
	
	
	                        <!-- P A S S W O R D -->
	                        <div class = "form-group row">
	                        	<label class="col-sm-2 col-form-label" for="password">Password</label>
	                        	<div class="col-sm-10">
   		                            <s:password cssClass="form-control" name = "userAccount.password" id = "password" 
   		                           data-toggle="tooltip" data-placement="bottom"
	                            title = "Password Must be 16 characters" minlength="16" maxlength="16"
	                            value="%{userAccount.password}" showPassword="true"/>
	                        	</div>                  
	                            <div class="help-block with-errors" id="error-password"></div>
	                        </div>
	                        
	                        
   	                        <!-- Current Job -->
	                        <div class = "form-group row">
	                        	<label class="col-sm-2 col-form-label" for="current-job">Current Job</label>
	                        	<div class="col-sm-10">
   		                            <s:textfield cssClass="form-control" name = "user.currentJob" id = "current-job" 
   		                            data-toggle="tooltip" data-placement="bottom"
	                            title = "Please fill in" value = "%{user.currentJob}" />
	                        	</div>                  
	                            <div class="help-block with-errors" id="error-current-job"></div>
	                        </div>
	                        
   	                        <!-- Contact No -->
	                        <div class = "form-group row">
	                        	<label class="col-sm-2 col-form-label" for="contactno">Contact No</label>
	                        	<div class="col-sm-10">
   		                            <s:textfield cssClass="form-control" class="form-control" name = "user.contactNo" id = "contactno" 
   		                            data-toggle="tooltip" data-placement="bottom"
	                            title = "Please fill in" value="%{user.contactNo}" />
	                        	</div>                  
	                            <div class="help-block with-errors" id="error-contactno"></div>
	                        </div>
	                        
	                       <!-- Biography -->
	                        <div class = "form-group row">
	                        	<label class="col-sm-2 col-form-label" for="biography">Biography</label>
	                        	<div class="col-sm-10">
   		                            <s:textarea cssClass="form-control" name = "user.biography" id = "biography" 
   		                            data-toggle="tooltip" data-placement="bottom"
	                            title = "Please fill in" rows="5" value = "%{user.biography}" />
	                        	</div>                  
	                            <div class="help-block with-errors" id="error-biography"></div>
	                        </div>
	
	
	                        <div class="form-group">
	                            <button type="submit" class="form-control-submit-button" id="submit" value="Update Profile">Update Profile</button>
	                        </div>
	                        <div class="form-message">
	                            <div id="lmsgSubmit" class="h3 text-center hidden"></div>
	                        </div>
	                    </form>
	                    <!-- end of call me form -->
	
	
	
	                	</div> <!--End of Card-->
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
                
            </div> <!-- end of container -->
        </div> <!-- end of cards-2 -->
        <!-- end of Users -->

	
	<!--  Footer -->
	<%@ include file="./footer.jsp" %>  
	
    <!-- Scripts -->
	<%@ include file="./script.jsp" %>  
</body>
</html>