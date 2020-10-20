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
<title>ABC JOBS | PUBLIC PROFILE</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header-login-user.jsp" %>  
	
	
        <!-- Users -->
        <div id="profile" class="layout">
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
							    <a class="nav-link" href="./users"><i class="fas fa-user-plus"></i> Networks</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link active" href="./profile"><i class="fas fa-user"></i> Profile</a>
							  </li>
							</ul>
						</nav> <!-- Vertical menu -->
                	</div> <!-- end of col -->
                	
                    <div class="col-lg-10 col-xs-12">
                        <div class="row">
                        	<div class="col">
                        		<img src="./img/users.png" alt="profile" class="rounded-circle profile">
                        	</div> <!-- endOfCol : Image -->
                      	    <div class="col">
                        		<p class="font-weight-bold" id="name"><s:property value="user.firstName" /> <s:property value="user.lastName" /></p>
                        		<p>
                        		   <i class="fas fa-briefcase"></i> 
                        		   <span id="job-title"><s:property value="user.currentJob" /></span> @
                        		   <span id="company-name"> <s:property value="user.currentCompany" /></span>
                        		</p>
                        		<p>
                        		   <i class="fas fa-location-arrow"></i>
                        		   <span id="city"> <s:property value="user.city" /></span>
                        		   <span id="country">, <s:property value="user.country" /></span>
                        		</p>
                        		<p>
                        		   <i class="fab fa-whatsapp"></i>
                        		   <span id="contactNo"> <span id="city"> <s:property value="user.contactNo" /></span></span>
                        		</p>
                        	</div>  <!-- endOfCol : Profile Update -->
                        </div>  <!-- End of row: Profile -->
                        
                        <!-- Card: Skills -->
                        <div class="card mt-4">
                            <div class="card-body">
                                <h3 class="card-title text-uppercase">Skills</h3>
                                <p class="card-text">
									<span id="skills"> <s:property value="user.skills" /></span>
                                </p>
                            </div>
                        </div>
                        <!-- end of card -->
                        
                        <!-- Card: Biography -->
                        <div class="card mt-3">
                            <div class="card-body">
                                <h3 class="card-title text-uppercase">biography</h3>
                                <p class="card-text">
									<span id="biography"> <s:property value="user.biography" /></span>
                                </p>
                            </div>
                        </div>
                        <!-- end of card -->
                        
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