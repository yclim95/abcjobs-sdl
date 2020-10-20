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
<title>ABC JOBS | USERS</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header-login-user.jsp" %>  
	
	
        <!-- Users -->
        <div id="user-section" class="card-users">
            <div class="container">
            	<div class="row pb-3">
           			<form class="form-inline search-user" ACTION="users-search-results" METHOD="post">
            	
            		<div class="col-xs-8">
						  <label class="sr-only" for="inlineFormInputGroupUsername2">Search users</label>
						  
						  <div class="input-group mb-2 mr-sm-2">
						    <div class="input-group-prepend">
						      <div class="input-group-text" data-toggle="tooltip" data-placement="bottom" title="Name, city, country & company name">
						      <span><i class="fas fa-search"></i></span>
						      </div>
						    </div>
						    <input type="text" class="form-control" id="searchUsers" name="searchUsers" placeholder="Search users"
						    data-toggle="tooltip" data-placement="bottom" title="Name, city, country & company name">								    				    
						  </div>
						  <span class="help-block with-errors" id="error-searchUsers"></span>		  

            		</div> <!-- end of col -->
            		
            		<div class="col-xs-4">
   						  <button type="submit" class="form-control-submit-button-wdefault mb-2" id="submit">Submit</button>
            		</div> <!-- end of col -->
					</form> <!-- End of search Form -->
            		
            	</div> <!-- end of row -->
            	
                <div class="row">
                    <div class="col-lg-12 col-xs-12">
                        <div class="section-title">Users</div>
                        <h2>List of register users</h2>
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
                
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
                    	<s:if test="userList">
                        <s:iterator value="userList">
                        <!-- Card -->
                        <div class="card">
                            <div class="card-image">
                                <img class="img-fluid" src="./img/users.png" alt="user profile image">
                            </div>
                            <div class="card-body">
                                <h3 class="card-title text-uppercase"><s:property value="firstName" /> <s:property value="lastName" /></h3>
                                <ul class="list-unstyled li-space-lg">
                            	   <s:if test="currentJob != ''">
	                                    <li class="media">
	                                        <i class="fas fa-square"></i>
	                                        <div class="media-body text-capitalize"><s:property value="currentJob" /></div>
	                                    </li>
                                    </s:if> <!-- If currentJob exist -->
                                    <s:if test="currentCompany != ''">
	                                    <li class="media">
	                                        <i class="fas fa-square"></i>
	                                        <div class="media-body text-capitalize"><s:property value="currentCompany" /></div>
	                                    </li>
                                    </s:if> <!-- If currentJob exist -->
                                </ul>
                            </div>
                            <div class="button-container">
                                <a class="btn-solid-reg page-scroll" href="./public-profile?user.userID=<s:property value='userID' />" >VIEW PROFILE</a>
                            </div> <!-- end of button-container -->
                        </div>
                        <!-- end of card -->

                        </s:iterator> <!--  End of displaying users list loop -->
                        </s:if> <!-- End of If for userList -->
                        <s:else>
                        	 <p>
                        	<span><s:property value="message" /></span>	
                        	</p>
                        </s:else> <!-- If no other users -->
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