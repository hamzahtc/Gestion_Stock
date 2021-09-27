<%@page import="org.stock.models.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</head>
<style>
.container{
	margin : 40px;
}
.formulaire{
	padding : 25px;
	background-color: #DCDCDC;
}

input {
	border: 1px solid black;
}

</style>
<body>


	<% Produit produit = (Produit) request.getAttribute("produit"); %>
	<div class="container">
	<h3><center>Gestion de stock</center></h3>
		<div class="container formulaire border border-dark rounded">
	<form action="ProduitController/updateP/<%=produit.getId() %>" method="post">
	<div class="mb-3">
	  <label for="nom" class="form-label">Nom</label>
	  <input value="<%= produit.getNom() %>" type="text" class="form-control" id="nom" placeholder="Imprimante" name="nom">
	</div>
	<div class="mb-3">
	  <label for="quantite" class="form-label">Quantité</label>
	  <input value="<%= produit.getQuantite() %>"  type="text" class="form-control" id="quantite" placeholder="500" name="quantite">
	</div>
	<div class="mb-3">
	  <label for="prix" class="form-label">Prix</label>
	  <input value="<%= produit.getPrix() %>"  type="text" class="form-control" id="prix" placeholder="100.99" name="prix">
	</div>
	<input class="btn btn-warning"type="submit" value="Modifier" />
	</form>
	</div>
	</div>
</body>
</html>