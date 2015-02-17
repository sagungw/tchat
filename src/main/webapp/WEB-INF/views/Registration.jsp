<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Registration</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" />
    </head>
    <body style="background: rgb(51,51,51); color: white;">
    	<!-- Register -->
    	<br /><br /><br /><br />
    	
    	<!-- Judul -->
    	<div align="center"><h1>REGRISTATION</h1></div>
    	<!-- End of Judul -->
    	
    	<br />
    	<div class="container" align="center">
    		<div class="container col-md-offset-3">
	        	<form id="registrationForm" action="registrationAction" method="post" class="form-horizontal">
				  	<div class="form-group">
				    	<label for="inputEmail3" class="col-sm-2 control-label">NRP</label>
				    <div class="col-sm-3">
				      	<input type="text" class="form-control" id="usernameRegistration" name="usernameRegistration" placeholder="NRP">
				    </div>
				  	</div>
				  	<div class="form-group">
				    	<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				    	<div class="col-sm-3">
				      		<input type="password" class="form-control" id="passwordRegistration" name="passwordRegistration" placeholder="Password">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="inputEmail3" class="col-sm-2 control-label">Nickname</label>
				    	<div class="col-sm-3">
				      		<input type="text" class="form-control" id="profileNameRegistration" name="profileNameRegistration" placeholder="Nickname">
				    	</div>
				    </div>
				  	<div class="form-group">
				    	<div class="col-sm-offset-2 col-sm-3">
				      		<div style="float: left">
				      			<input type="submit" class="btn btn-default" value="Register" />
				      		</div>
				      		<div style="float: right">
				      			<a href="login">Login</a>
				      		</div>
				    	</div>
				  	</div>
				</form>	
	        </div>
    	</div>
		<!-- End of Register -->
    </body>
</html>
