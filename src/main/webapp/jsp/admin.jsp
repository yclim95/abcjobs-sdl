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
	<title>ABC JOBS | ADMIN</title>

    <!-- Styles -->
    <%@ include file="./head.jsp" %>  
</head>
<body>
	<!--  Header -->
	<%@ include file="./header-login-admin.jsp" %>  
	
	
        <!-- Users -->
        <div id="home" class="layout">
            <div class="container">
                <div class="row">
                	<div class="col-lg-2 col-xs-12">
                		<!-- Vertical menu -->
						<nav class="navbar vertical-menu">
							<ul class="nav flex-column">
							  <li class="nav-item">
							    <a class="nav-link active disabled"><i class="fas fa-home"></i> Home</a>
							  </li>
							</ul>
						</nav> <!-- Vertical menu -->
                	</div> <!-- end of col -->
                	
                    <div class="col-lg-10 col-xs-12">
                        <table class="table table-striped">
							  <thead>
							    <tr>
							      <th scope="col">First Name</th>
							      <th scope="col">Last Name</th>
							      <th scope="col">Email</th>
							      <th scope="col">Ban User</th>
							    </tr>
							  </thead>
		                      <s:iterator value="userList">
							  
							  <tbody>
							    <tr>
							      <td><s:property value="firstName" /></td>
							      <td><s:property value="lastName" /></td>
							      <td><s:property value="email" /></td>
							      <td>
							      	<a href="./ban-user?user.userID=<s:property value='userID' />">
							      		<button class="btn btn-danger">
							      		<i class="fas fa-trash-alt"></i> Ban User
							      		</button>
						      		</a>
							      </td>
							    </tr>
							   </tbody>
	   						</s:iterator>
							   
							</table>  
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