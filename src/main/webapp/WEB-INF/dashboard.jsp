<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>trivial</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gochi+Hand&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">

</head>
<body>
<div class="navigation">
		<a href="/logout">logout</a>
</div>
	<div class="container2">
		<div class="wrapper">
			<h1>Welcome <c:out value="${ user.username }"/></h1>
			<a href="/game" class="buttonStyle">Start a Game!</a>
		</div>
		<div class="wrapper stats">
			<h2>Stats</h2>
			<hr>
			<p>Wins: </p>
			<p>Losses: </p>
			<p>Incomplete: </p>
		</div>
		
	</div>
	
	
	
</body>
</html>