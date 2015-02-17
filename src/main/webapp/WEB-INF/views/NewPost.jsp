<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>



<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>New Post</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" />
    </head>
    <body style="background: rgb(51,51,51); color: white;">
    	<script type="text/javascript">
    		function addOption(){
    			select = document.getElementById('labelsNewPost');
    			var opt = document.createElement('option');
    			var e = document.getElementById("categoryLabel");
    			var selValue = e.options[e.selectedIndex].value;
    			opt.value = selValue;
    			opt.innerHTML = e.options[e.selectedIndex].innerHTML;
    			
    			var oke=1;
    			for(var i = 0; i < select.length; i++){
    				if(select.options[i].value == selValue){
    					oke = 0;
    					break;
    				}
    			}
    			if(oke == 1) select.appendChild(opt);
    			
    			var selectObj = document.getElementById('labelsNewPost');
    			var res = "";
    			for (var i = 0 ; i < selectObj.length ; i++){
    				res = res + selectObj.options[i].value;
    				res  = res + "|";
    			}
    			document.getElementById("tagNewPost").value = res;
    		}
    		
    		function removeOption(){
    			select = document.getElementById('labelsNewPost');
    			select.remove(select.selectedIndex);
    			
    			var selectObj = document.getElementById('labelsNewPost');
    			var res = "";
    			for (var i = 0 ; i < selectObj.length ; i++){
    				res = res + selectObj.options[i].value;
    				res  = res + "|";
    			}
    			document.getElementById("tagNewPost").value = res;
    		}
    	</script>
    	
    	<!--Header-->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header">
				<a class="navbar-brand" href="home">TChat?</a>
		  	</div>
	
		  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    	<ul class="nav navbar-nav">
		      		<li class="active"><a href="newPost">New Post</a></li>
		    	</ul>
		    
		    <ul class="nav navbar-nav navbar-right">
		    	<li><a href="profileAskMe">${member.usernameMember}</a></li>
		    	<li><a href="logout"><span class="glyphicon glyphicon-off"></span></a></li>&nbsp;&nbsp;&nbsp;
		  	</ul>
		  </div>
		</nav>
		<!--End of Header-->
		
		<br />
		<div class="container" align="center">
			<form id="addNewPostForm" name="addNewPostForm" action="addNewPostAction" method="post" class="form-inline">
				<div class="form-group">
					<label class="sr-only" for="titleNewPost">Post's Title</label>
				    <input id="titleNewPost" name="titleNewPost" style="width: 600px" type="text" class="form-control" placeholder="Post's Title">
				</div>
				<div class="form-group">
				    <select id="askingNewPost" name="askingNewPost" class="form-control" style="width: 150px">
	        			<c:forEach items="${members}" var="memb">
	        				<option value="${memb.usernameMember}">${memb.usernameMember}</option>
		        		</c:forEach>
		        	</select>
				</div>
				<br /><br />
				<textarea id="descriptionNewPost" name="descriptionNewPost" class="form-control" style="width: 750px; height: 500px"> </textarea>
				<br /><br />
				<div style="width: 750px">
				  	<table class="table table-responsive">
						<tr align="center">
							<td>Available Label</td>
							<td> </td>
							<td> </td>
							<td> Selected Label</td>
						</tr>
						<tr align="center">
							<td>
								<div class="form-group">
									<select id="categoryLabel" class="form-control">
								    	<c:forEach items="${labels}" var="label">
				        					<option value="${label.idQuestionLabel}">${label.titleQuestionLabel}</option>
				        				</c:forEach>
								    </select>
								</div>
					  		</td>
							<td><input style="width: 75px" type="button" class="btn btn-default" value="Add" onclick="addOption()" /></td>
							<td><input style="width: 75px" type="button" class="btn btn-default" value="Remove" onclick="removeOption()"/></td>
							<td>
								<input id="tagNewPost" name="tagNewPost" type="hidden" value="" />
								<div class="form-group">
									<select id="labelsNewPost" name="labelsNewPost" class="form-control">
								    </select>
								</div>
							</td>
						</tr>
						<tr align="center">
							<td colspan="4"><input type="submit" class="btn btn-default" value="Submit Post" /></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<br /><br /><br /><br /><br /><br />
	 	<nav class="navbar navbar-default navbar-fixed-bottom" style="color: black; clear: both;">
			<h4 align="center">TChat?</h4>
       		<h6 align="center">Copyright (c) 2013-2014 Final Project J2EE</h6>
		</nav>
    </body>
</html>