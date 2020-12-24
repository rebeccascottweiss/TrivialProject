<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game</title>
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
		<c:choose>
		<c:when test="${ winner }" >
			<div class="win">
				<h2>You win!</h2>
				<a href="/reset" class="buttonStyle">Play Again?</a>
			</div>
		</c:when>
		<c:when test="${ lose }">
			<div class="lose">
				<h2>Oh No!</h2>
				<p>You took too long. Better luck next time!</p>
				<a href="/reset" class="buttonStyle">Play Again?</a>
			</div>
		</c:when>
		<c:otherwise>
		<div class="response">
			<h3><c:out value="${ response }" escapeXml="false"/></h3>
		</div>
		<div class="categories">
			<div class="category">
			<a href="/category/science"> Science &#38 Nature </a>
			</div>
			<div class="category">
			<a href="/category/history"> History </a>
			</div>
			<div class="category">
			<a href="/category/celebrities"> Celebrities </a>
			</div>
			<div class="category">
			<a href="/category/politics"> Politics </a>
			</div>
			<div class="category">
			<a href="/category/general"> General Knowledge </a>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
	</div>
</body>
</html>