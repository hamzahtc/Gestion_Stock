package org.stock.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stock.business.ProduitService;
import org.stock.business.ProduitServiceDefault;
import org.stock.dao.ProduitDAOJdbc;
import org.stock.jdbc.Database;
import org.stock.jdbc.MySQLDataSource;
import org.stock.models.Produit;

@WebServlet({ "/ProduitController", "/ProduitController/*" })
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProduitService produitService;
	private List<Produit> produits;

	@Override
	public void init(ServletConfig config) throws ServletException {
		produitService = new ProduitServiceDefault(new ProduitDAOJdbc(new Database(new MySQLDataSource("produitdb"))));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		List<String> list = Arrays.asList(uri.split("/"));
		if (list.contains("delete")) {
			produitService.remove(Integer.parseInt(list.get(list.size() - 1)));

		} else if (list.contains("edit")) {
			Produit produit = produitService.get(Integer.parseInt(list.get(list.size() - 1)));
			System.out.println(produit);
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("/jsp/editProduit.jsp").forward(request, response);
		} else {
			produits = produitService.getProduits();
			request.setAttribute("produits", produits);
			request.getRequestDispatcher("/jsp/produits.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		List<String> list = Arrays.asList(uri.split("/"));
		String nom = request.getParameter("nom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		float prix = Float.parseFloat(request.getParameter("prix"));
		if (list.contains("updateP")) {
			int id = Integer.parseInt(list.get(list.size() - 1));
			Produit p = new Produit(id, nom, quantite, prix);
			produitService.update(p);
		} else {
			Produit produit = new Produit(nom, quantite, prix);
			System.out.println(produit);
			produitService.add(produit);
		}
		response.sendRedirect(request.getContextPath() + "/ProduitController");
	}

}
