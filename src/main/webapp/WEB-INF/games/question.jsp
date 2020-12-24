<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gochi+Hand&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<div class="navigation">
		<a href="/dashboard">dashboard</a> | <a href="/logout">logout</a>
</div>	
	<div class="container">
	<div class="score">
			<h3>Team <c:out value="${ user.username }"/></h3>
			<div class="points"><c:out value="${ score }"/></div>
	</div>
		<div class="card">
			<h2><c:out value="${ question }" escapeXml="false"/></h2>
			<form action="/processAnswer" method="POST">
				<c:forEach items="${ answers }" var = "answer">
					<div class="formGroup">
						<input type="radio" name="answer" id="${ answer }" value="${ answer }" />
						<label for="${ answer }">${ answer }</label>
					</div>
				</c:forEach>
				<input type="submit" value="Answer!" />
			</form>
		</div>
	</div>
</body>
</html>