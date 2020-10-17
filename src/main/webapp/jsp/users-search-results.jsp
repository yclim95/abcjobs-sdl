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
<title>ABC JOBS | USER SEARCH RESULT</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header-login-user.jsp" %>  
	
	
        <!-- Users -->
        <div id="course-section" class="card-users">
            <div class="container">
            	<div class="row pb-3">
           			<form class="form-inline search-user">
            	
            		<div class="col-xs-8">
						  <label class="sr-only" for="inlineFormInputGroupUsername2">Search users</label>
						  
						  <div class="input-group mb-2 mr-sm-2">
						    <div class="input-group-prepend">
						      <div class="input-group-text" data-toggle="tooltip" data-placement="bottom" title="Name, city, country & company name">
						      <span><i class="fas fa-search"></i></span>
						      </div>
						    </div>
						    <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Search users"
						    data-toggle="tooltip" data-placement="bottom" title="Name, city, country & company name">						    
						  </div>

            		</div> <!-- end of col -->
            		
            		<div class="col-xs-4">
   						  <button type="submit" class="form-control-submit-button-wdefault mb-2">Submit</button>
            		</div> <!-- end of col -->
					</form> <!-- End of search Form -->
            		
            	</div> <!-- end of row -->
            	
                
                <div class="row">
                	<div class="col-lg-2 col-xs-12">
                		<!-- Vertical menu -->
						<nav class="navbar vertical-menu">
							<ul class="nav flex-column">
							  <li class="nav-item">
							    <a class="nav-link" href="./home"><i class="fas fa-home"></i> Home</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link active disabled"><i class="fas fa-user-plus"></i> Networks</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="./jobs"><i class="fas fa-briefcase"></i> Jobs</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="./profile"><i class="fas fa-user"></i> Profile</a>
							  </li>
							</ul>
						</nav> <!-- Vertical menu -->
                	</div> <!-- end of col -->
                	
                    <div class="col-lg-10 col-xs-12">
                        <h2 class="text-left">Search results</h2>
                        <p>
                        	<span>1 </span> record match:
                        	<span> Ivan Chia</span>
                        </p>
                        <!-- Card -->
                        <div class="card">
                            <div class="card-image">
                                <img class="img-fluid" src="./img/ivan-chia.jpg" alt="HTML & CSS">
                            </div>
                            <div class="card-body">
                                <h3 class="card-title text-uppercase">Ivan Chia</h3>
                                <ul class="list-unstyled li-space-lg">
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">Software Engineer</div>
                                    </li>
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">Ignenious Lab</div>
                                    </li>
                                </ul>
                            </div>
                            <div class="button-container">
                                <a class="btn-solid-reg page-scroll" href="./public-profile" >VIEW PROFILE</a>
                            </div> <!-- end of button-container -->
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