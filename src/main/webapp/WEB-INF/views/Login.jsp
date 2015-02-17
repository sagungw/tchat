<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>TChat?</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" />
    </head>
    
    <body style="background: rgb(51,51,51); color: white;">
    	<!-- Login -->
    	<br /><br /><br /><br />
    	
    	<!-- Judul -->
    	<div align="center"><h1>TChat?</h1></div>
    	<!-- End of Judul -->
    	
    	<br />
    	
    	<!-- Form Login -->
    	<div class="container" align="center">
    		<div class="container col-md-offset-3">
	        	<form id="loginForm" action="loginAction" method="post" class="form-horizontal">
				  	<div class="form-group">
				    	<label for="inputEmail3" class="col-sm-2 control-label">NRP</label>
					    <div class="col-sm-3">
					      	<input type="text" class="form-control" id="usernameLogin" name="usernameLogin" placeholder="NRP">
					    </div>
				  	</div>
				  	<div class="form-group">
				    	<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				    	<div class="col-sm-3">
				      		<input type="password" class="form-control" id="passwordLogin" name="passwordLogin" placeholder="Password">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<div class="col-sm-offset-2 col-sm-3">
				      		<div style="float: left">
				      			<input type="submit" class="btn btn-default" value="Login" />
				      		</div>
				      		<div style="float: right">
				      			<a href="registration">Register</a>
				      		</div>
				    	</div>
				  	</div>
				</form>	
	        </div>
    	</div>
    	<!-- Form Login -->
		<!-- End of Login -->
    </body>
</html>
