<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>




<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>My Profile | Ask You</title>
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
			  	<li class="active"><a href="profileAskYou">Ask You</a></li>
			  	<li><a href="profileEdit">My Profile</a></li>
			</ul>
		</div>
		<div class="container" align="center">
			<table class="table table-hover" width="100%">
				<c:forEach items="${questions}" var="question">
					<tr>
						<td width="30%">
							<table width="100%">
								<tr>
									<td>
										<a href="post/${question.idQuestion}">
											by : ${question.askingMemberQuestion.profileNameMember}
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="post/${question.idQuestion}">
											to : ${question.askedMemberQuestion.usernameMember}
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="post/${question.idQuestion}">
											time : ${question.timeQuestion}
										</a>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<a href="post/${question.idQuestion}">
								${question.titleQuestion}
								<br />
								${question.descriptionQuestion}
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	 	<nav class="navbar navbar-default navbar-fixed-bottom" style="color: black; clear: both;">
			<h4 align="center">TChat?</h4>
       		<h6 align="center">Copyright (c) 2013-2014 Final Project J2EE</h6>
		</nav>
    </body>
</html>