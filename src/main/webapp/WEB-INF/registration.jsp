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
<div class="navigation">
		<a href="/">login</a>
</div>
<div class="container">
	<h1>Trivial</h1>
	    
	   <div class="loginReg">
	    	<h2>Register</h2>
	    	 <p><form:errors path="user.*"/></p>
	    	<form:form method="POST" action="/registration" modelAttribute="user">
	    	    <div class="formGroup">
	    	        <form:label path="username">Username:</form:label>
	    	        <form:input type="text" path="username"/>
	    	    </div>
	    	    <div class="formGroup">
	    	        <form:label path="email">Email:</form:label>
	    	        <form:input type="email" path="email"/>
	    	    </div>
	    	    <div class="formGroup">
	    	        <form:label path="password">Password:</form:label>
	    	        <form:password path="password"/>
	    	    </div>
	    	    <div class="formGroup">
	    	        <form:label path="passwordConfirmation">Confirm:</form:label>
	    	        <form:password path="passwordConfirmation"/>
	    	    </div>
	    	    <input type="submit" value="Register!"/>
	    	</form:form>
	    </div>
</div>
</body>
</html>