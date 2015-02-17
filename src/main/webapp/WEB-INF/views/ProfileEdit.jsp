<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>My Profile</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" />
    </head>
    <body style="background: rgb(51,51,51); color: white;">
    	<!--Header-->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header">
				<a class="navbar-brand" href="home">TChat?</a>
		  	</div>
	
		  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    	<ul class="nav navbar-nav">
		      		<li><a href="newPost">New Post</a></li>
		    	</ul>
		    
		    <ul class="nav navbar-nav navbar-right">
		    	<li class="active"><a href="profileAskMe">${member.usernameMember}</a></li>
		    	<li><a href="logout"><span class="glyphicon glyphicon-off"></span></a></li>&nbsp;&nbsp;&nbsp;
		  	</ul>
		  </div>
		</nav>
		<!--End of Header-->
		
		<div align="center" class="container">
			<ul class="nav nav-tabs">
			  	<li><a href="profileAskMe">Ask Me</a></li>
			  	<li><a href="profileAskYou">Ask You</a></li>
			  	<li class="active"><a href="profileEdit">My Profile</a></li>
			</ul>
		</div>
		<br />
		<div class="container" align="center">
			<div class="container col-md-offset-3">
	        	<form id="loginForm" action="editProfileAction" method="post" class="form-horizontal">
				  	<div class="form-group">
				    	<label for="inputPassword3" class="col-sm-2 control-label">Old Password</label>
				    	<div class="col-sm-3">
				      		<input type="password" class="form-control" id="oldPasswordEditProfile" name="oldPasswordEditProfile" placeholder="Enter Old Password">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="inputEmail3" class="col-sm-2 control-label">Nickname</label>
					    <div class="col-sm-3">
					      	<input type="text" class="form-control" id="usernameEditProfile" name="usernameEditProfile" placeholder="Enter New Nickname">
					    </div>
				  	</div>
				  	<div class="form-group">
				    	<label for="inputEmail3" class="col-sm-2 control-label">New Password</label>
				    	<div class="col-sm-3">
				      		<input type="password" class="form-control" id="newPasswordEditProfile" name="newPasswordEditProfile" placeholder="Enter New Password">
				    	</div>
				    </div>
				  	<div class="form-group">
				    	<div class="col-sm-offset-2 col-sm-3">
				      		<div style="float: left">
				      			<input type="submit" class="btn btn-default" value="Submit" />
				      		</div>
				    	</div>
				  	</div>
				</form>	
	        </div>

		</div>
	 	<nav class="navbar navbar-default navbar-fixed-bottom" style="color: black; clear: both;">
			<h4 align="center">TChat?</h4>
       		<h6 align="center">Copyright (c) 2013-2014 Final Project J2EE</h6>
		</nav>
    </body>
</html>