<%@page import="org.stock.models.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>

<title>Produits</title>
<style>
table, th, td {
  border:1px solid black;
}
.container{
	margin : 40px;
}
th{
	background-color: black;
}
</style>
</head>
<% List<Produit> produits = (List<Produit>) request.getAttribute("produits"); %>
<body>

	<div class="container">
	<form action="ProduitController" method="post">
	<div class="mb-3">
	  <label for="nom" class="form-label">Nom</label>
	  <input type="text" class="form-control" id="nom" placeholder="Imprimante" name="nom">
	</div>
	<div class="mb-3">
	  <label for="quantite" class="form-label">Quantité</label>
	  <input type="text" class="form-control" id="quantite" placeholder="500" name="quantite">
	</div>
	<div class="mb-3">
	  <label for="prix" class="form-label">Prix</label>
	  <input type="text" class="form-control" id="prix" placeholder="100.99" name="prix">
	</div>	
		<input class="btn btn-success"type="submit" value="Ajouter" />
	</form>
	</div>
	
	<div class="container">
	<table class="table table-hover">
	  <tr>
	    <th class="table-dark">Nom</th>
	    <th class="table-dark">Quantité</th>
	    <th class="table-dark">Prix</th>
	    <th class="table-dark"></th>	    
	  </tr>
	  <%
	  	for(Produit produit : produits){
	  %>
	  <tr>
	    <td><%= produit.getNom() %></td>
	    <td><%= produit.getQuantite() %></td>
	    <td><%= produit.getPrix() %></td>
	    <td><a class="btn btn-danger" href="/Gestion_Stock/ProduitController/delete/<%= produit.getId() %>">Supprimer</a>
			<a class="btn btn-warning" href="/Gestion_Stock/ProduitController/edit/<%= produit.getId() %>">Modifier</a></td>
	  </tr>
	  <%	
		}	
	  %>
	</table>
	
	</div>
	
</body>
</html>