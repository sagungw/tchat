<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>




<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Question</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" />
    </head>
    <body style="background: rgb(51,51,51); color: white;">
    	<script type="text/javascript">
    		function selectAnswerId(idAns){
    			document.getElementById("idAnswerAddComment").value = idAns;
    		}
    	</script>
    	<!--Header-->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header">
				<a class="navbar-brand" href="/FPJ2EE/home">TChat?</a>
		  	</div>
	
		  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    	<ul class="nav navbar-nav">
		      		<li><a href="/FPJ2EE/newPost">New Post</a></li>
		    	</ul>
		    
		    <ul class="nav navbar-nav navbar-right">
		    	<li><a href="/FPJ2EE/profileAskMe">${member.usernameMember}</a></li>
		    	<li><a href="/FPJ2EE/logout"><span class="glyphicon glyphicon-off"></span></a></li>&nbsp;&nbsp;&nbsp;
		  	</ul>
		  </div>
		</nav>
		<!--End of Header-->
		
		<br />
		<div class="container" align="center" style="width: 600px">
			<!--QUESTION-->
			<div>
				<h1> ${question.titleQuestion} </h1>
				<br /><br />
				<div style="float: left">
					<h5 align="left">${question.askingMemberQuestion.profileNameMember} &nbsp;|&nbsp; ${question.askedMemberQuestion.profileNameMember} </h5>
				</div>
				<div style="float: right">
					<h5 align="right">${question.ratingQuestion} RATING</h5>
				</div>
				<br /><br />
				<div style="text-align: justify; border-top: solid; border-bottom: solid; color: white;padding-top: 10px ;padding-bottom: 10px">
					<p>${question.descriptionQuestion}</p>
				</div>
				<div style="float: left">
					<h5 align="left">
						<a href="likesQuestionAction/${question.idQuestion}">
							<span class="glyphicon glyphicon-thumbs-up"></span>
						</a>
						&nbsp;|&nbsp;
						<a href="dislikesQuestionAction/${question.idQuestion}">
							<span class="glyphicon glyphicon-thumbs-down"></span>
						</a>
					</h5>
				</div>
			</div>
			<!--QUESTION-->
			<!-- OFFICIAL ANSWER -->
			<c:if test="${isAnswered}">
				<c:forEach items="${officialAnswer}" var="ofcAnswer">
					<div style="clear: both;">
					<br />
					<div style="float: left">
						<h5 align="left">${ofcAnswer.memberAnswer.usernameMember}</h5>
					</div>
					<div style="float: right">
						<h5 align="right">${ofcAnswer.ratingAnswer} RATING</h5>
					</div>
					<br /><br />
					<div style="text-align: justify; border-top: solid; border-bottom: solid; color: white;padding-top: 10px ;padding-bottom: 10px">
						<p>${ofcAnswer.descriptionAnswer}</p>
					</div>
					<div style="float: left">
						<h5 align="left">
							<a href="likesAnswerAction/${ofcAnswer.idAnswer}">
							<span class="glyphicon glyphicon-thumbs-up"></span>
						</a>
						&nbsp;|&nbsp;
						<a href="dislikesAnswerAction/${ofcAnswer.idAnswer}">
							<span class="glyphicon glyphicon-thumbs-down"></span>
						</a>
						</h5>
					</div>
					<div style="float: right">
						<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onclick="selectAnswerId(${ofcAnswer.idAnswer})">add comment</button>
					</div>
				</div>
				</c:forEach>
			</c:if>
			<c:if test="${!isAnswered  && question.getAskedMemberQuestion().getUsernameMember().equals(member.getUsernameMember())}">
				<div style="float: right">
					<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModalOfficial" >add official answer</button>
				</div>
			</c:if>
			<!-- OFFICIAL ANSWER -->
			<c:forEach items="${question.answerQuestion}" var="answer">
				<!--ANSWER-->
				<div style="clear: both;">
					<br />
					<div style="float: left">
						<h5 align="left">${answer.memberAnswer.profileNameMember}</h5>
					</div>
					<div style="float: right">
						<h5 align="right">${answer.ratingAnswer} RATING</h5>
					</div>
					<br /><br />
					<div style="text-align: justify; border-top: solid; border-bottom: solid; color: white;padding-top: 10px ;padding-bottom: 10px">
						<p>${answer.descriptionAnswer}</p>
					</div>
					<div style="float: left">
						<h5 align="left">
							<a href="likesAnswerAction/${answer.idAnswer}">
							<span class="glyphicon glyphicon-thumbs-up"></span>
						</a>
						&nbsp;|&nbsp;
						<a href="dislikesAnswerAction/${answer.idAnswer}">
							<span class="glyphicon glyphicon-thumbs-down"></span>
						</a>
						</h5>
					</div>
					<div style="float: right">
						<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onclick="selectAnswerId(${answer.idAnswer})">add comment</button>
					</div>
				</div>
				<!--ANSWER-->
				<c:forEach items="${answer.commentaryAnswer}" var="comment">
					<!--COMMENT-->
					<c:if test="${answer.typeAnswer != 1}">
						<div style="width: 480px; float: right; clear: both;">
							<div style="float: left">
								<h5 align="left">${comment.memberCommentary.profileNameMember }</h5>
							</div>
							<br /><br />
							<div style="text-align: justify; border-top: solid; border-bottom: solid; color: white;padding-top: 10px ;padding-bottom: 10px">
								<p>${comment.descriptionCommentary}</p>
							</div>
						</div>
					</c:if>
					<!--COMMENT-->
				</c:forEach>
			</c:forEach>
			
			<div style="clear: both;">
				<form id="addAnswerForm" name="addAnswerForm" action="addAnswerAction" method="post" class="form-inline">
					<input type="hidden" id="idQuestionAddAnswer" name="idQuestionAddAnswer" value="${question.idQuestion}" />
					<input type="hidden" id="typeQuestionAddAnswer" name="typeQuestionAddAnswer" value="0" />
					<textarea id="descriptionAddAnswer" name="descriptionAddAnswer" class="form-control" style="width: 100%; height: 200px"></textarea>
					<input type="submit" class="btn btn-default" value="Submit Answer" />
				</form>
			</div>
		</div>
		
		<!-- MODAL -->
		<!-- MODAL COMMENT -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display:none;">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title">Add Comment</h4>
		      </div>
		      <div class="modal-body">
		      	<form id="addCommentForm" name="addCommentForm" action="addCommentAction" method="post">
		      		<input type="hidden" id="idQuestionAddComment" name="idQuestionAddComment" value="${question.idQuestion}" />
		      		<input type="hidden" id="idAnswerAddComment" name="idAnswerAddComment" value="" />
		      		<textarea id="descriptionAddComment" name="descriptionAddComment" style="width: 100%; height: 200px;"> </textarea>
					<div align="center">
						<input type="submit" class="btn btn-default" value="Submit Comment" />
					</div>
		      	</form>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<!-- MODAL COMMENT -->
		
		<!-- MODAL OFFICIAL ANSWER -->
		<div class="modal fade" id="myModalOfficial" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display:none;">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title">Add Official Answer</h4>
		      </div>
		      <div class="modal-body">
		      	<form id="addAnswerForm" name="addAnswerForm" action="addAnswerAction" method="post" class="form-inline">
					<input type="hidden" id="idQuestionAddAnswer" name="idQuestionAddAnswer" value="${question.idQuestion}" />
					<input type="hidden" id="typeQuestionAddAnswer" name="typeQuestionAddAnswer" value="1" />
					<textarea id="descriptionAddAnswer" name="descriptionAddAnswer" class="form-control" style="width: 100%; height: 200px"></textarea>
					<input type="submit" class="btn btn-default" value="Submit Official Answer" />
				</form>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<!-- MODAL OFFICIAL ANSWER -->
		<script src="https://code.jquery.com/jquery.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
		
		<!-- MODAL -->
		<br /><br /><br /><br />
	 	<nav class="navbar navbar-default navbar-fixed-bottom" style="color: black; clear: both;">
			<h4 align="center">TChat?</h4>
       		<h6 align="center">Copyright (c) 2013-2014 Final Project J2EE</h6>
		</nav>
    </body>
</html>