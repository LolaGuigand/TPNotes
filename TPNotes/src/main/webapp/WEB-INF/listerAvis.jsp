<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/style.css">
<meta charset="ISO-8859-1">
<title>Liste des notes</title>
</head>
<body>
<h1>Liste des notes</h1>

<form action="./" method="POST"> 
<c:if test="${!empty listeAvis}">

<ul>
	<c:forEach items="${listeAvis}" var="avis"  varStatus="status">
			<li>
				${avis.note} - ${avis.description}
			</c:forEach>
</ul>
</c:if>
<c:if test="${empty listeAvis}">

<p>Vous n'avez pas encore de note.</p>
</c:if>

</form>
</body>
</html>