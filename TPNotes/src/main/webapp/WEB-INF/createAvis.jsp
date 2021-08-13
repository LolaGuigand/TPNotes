<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creer Avis</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

<a href="./">retour accueil</a>

<h2>Nouvelle Note</h2>

<c:if test="${!empty succes}">
	<span class="success">La création a été effectuée avec succès</span>
</c:if>

<c:if test="${!empty erreur}">
	<span class="error"> ${erreur}</span>
</c:if>

<!-- si jamais on veut faire un POST sur le même Servlet que celui qui nous a redirigé la requête GET, on peut se passer du paramètre action ou mettre : action="./creerAvis"  -->
<form method="POST" > 
	<label for="note"> Note (entre 1 et 5): </label> 
	<input type="number" name="note" id="note" min="1" max="5" required/> <br /><br />
	
	<textarea name="description" id="description" cols="30" rows="10" maxlength="150" placeholder="commentaires sur la note"></textarea> <br /><br />
	
	<button type="submit">Valider</button>
	
</form>

</body>
</html>