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
	<title>ABC JOBS | JOBS</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header-login-user.jsp" %>  
	
	
        <!-- Jobs -->
        <div id="course-section" class="card-users">
            <div class="container">
            	<div class="row pb-3">
           			<form class="form-inline search-user" ACTION="./jobs-search-results" METHOD="post">
            	
            		<div class="col-xs-8">
						  <label class="sr-only" for="inlineFormInputGroupUsername2">Search jobs</label>
						  
						  <div class="input-group mb-2 mr-sm-2">
						    <div class="input-group-prepend">
						      <div class="input-group-text" data-toggle="tooltip" data-placement="bottom" title="Company name & Job Title">
						      <span><i class="fas fa-search"></i></span>
						      </div>
						    </div>
						    <input type="text" class="form-control" id="searchJobs" name="searchJob" placeholder="Search jobs"
						    data-toggle="tooltip" data-placement="bottom" title="Company name & Job Title">						    
						  </div>
						  <span class="help-block with-errors" id="error-searchJobs"></span>

            		</div> <!-- end of col -->
            		
            		<div class="col-xs-4">
   						  <button type="submit" class="form-control-submit-button-wdefault mb-2" id="submit">Submit</button>
            		</div> <!-- end of col -->
					</form> <!-- End of search Form -->
            		
            	</div> <!-- end of row -->
            	
                <div class="row">
                    <div class="col-lg-12 col-xs-12">
                        <div class="section-title">Jobs</div>
                        <h2>List of Job Opportunities</h2>
                    </div> <!-- end of col -->
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
							    <a class="nav-link" href="./users"><i class="fas fa-user-plus"></i> Networks</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link active disabled"><i class="fas fa-briefcase"></i> Jobs</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" href="./profile"><i class="fas fa-user"></i> Profile</a>
							  </li>
							</ul>
						</nav> <!-- Vertical menu -->
                	</div> <!-- end of col -->
                	
                    <div class="col-lg-10 col-xs-12">
                        
                        <!-- Card -->
                        <div class="card">

                            <div class="card-image">
                                <img class="img-fluid" src="./img/touch-n-go.png" alt="Touch N Go" style="height:200px">
                            </div>
                            <div class="card-body">
                            
                            	<div class="pb-3">
    	                            	<button class="btn-solid-sm">Full-time</button> 	
                            	</div>
         
                                <h3 class="card-title text-uppercase">
                                	<span id="job-title">Android Developer</span>
                                	<span id="company-name">(Touch n Go)</span>
                                </h3>
                                <ul class="list-unstyled li-space-lg">
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">
                                        	location:
                                        	<span id="city"> KL</span>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">
                                        	Date Posted:                                        
                                        	<span id="date-posted"> 8 August 2020</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="button-container">
                                <a class="btn-solid-reg page-scroll" href="" >VIEW JOB</a>
                            </div> <!-- end of button-container -->
                        </div>
                        <!-- end of card -->

                        <!-- Card -->
                        <div class="card">
                            <div class="card-image">
                                <img class="img-fluid" src="./img/accenture.jpg" alt="Accenture" style="height:200px">
                            </div>
                            <div class="card-body">
                               	<div class="pb-3">
    	                            	<button class="btn-solid-sm">Full-time</button> 	
                            	</div>
                                <h3 class="card-title text-uppercase">
                                	<span id="job-title">Senior Software Developer</span>
                                	<span id="company-name">(Accenture)</span>
                                </h3>
                                <ul class="list-unstyled li-space-lg">
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">
                                        	location:
                                        	<span id="city"> KL</span>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">
                                        	Date Posted:                                        
                                        	<span id="date-posted"> 8 August 2020</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="button-container">
                                <a class="btn-solid-reg page-scroll" href="" >VIEW JOB</a>
                            </div> <!-- end of button-container -->
                        </div>
                        <!-- end of card -->

                        <!-- Card -->
                        <div class="card">
                            <div class="card-image">
                                <img class="img-fluid" src="./img/tokio-marine.png" alt="Tokio Marine" style="height:200px">
                            </div>
                            <div class="card-body">
                               <div class="pb-3">
    	                            	<button class="btn-solid-sm">Full-time</button> 	
                            	</div>
                                <h3 class="card-title text-uppercase">
                                	<span id="job-title">IT Developer</span>
                                	<span id="company-name">(Tokio Marine Insurance Group Asia)</span>
                                </h3>
                                <ul class="list-unstyled li-space-lg">
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">
                                        	location:
                                        	<span id="city"> KL</span>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <i class="fas fa-square"></i>
                                        <div class="media-body text-capitalize">
                                        	Date Posted:                                        
                                        	<span id="date-posted"> 8 August 2020</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="button-container">
                                <a class="btn-solid-reg page-scroll" href="" >VIEW JOB</a>
                            </div> <!-- end of button-container -->
                        </div>
                        <!-- end of card -->
                </div> <!-- end of col -->
               </div> <!--  end of row -->
            </div> <!-- end of container -->
        </div> 
        <!-- end of Jobs -->

	
	<!--  Footer -->
	<%@ include file="./footer.jsp" %>  
	
    <!-- Scripts -->
	<%@ include file="./script.jsp" %>  
</body>
</html>