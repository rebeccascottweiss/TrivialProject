<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trivial</title>
<link rel="stylesheet" href="/css/style.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gochi+Hand&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">

</head>
<body>
<div class="container">
	<h1 class="loginReg">Trivial</h1>
    <div class="loginReg">
    	<h2>Sign In</h2>
    	<p><c:out value="${error}" /></p>
    	<form method="POST" action="/login">
    	    <div class="formGroup">
    	        <label for="email">Email</label>
    	        <input type="text" id="email" name="email"/>
    	    </div>
    	    <div class="formGroup">
    	        <label for="password">Password</label>
    	        <input type="password" id="password" name="password"/>
    	    </div>
    	    <input type="submit" value="Login!"/>
    	</form> 
   	</div> 
   	<div class="reglink">
   		<a href="/registration">Register</a>
   	</div>
</div>  
</body>
</html>