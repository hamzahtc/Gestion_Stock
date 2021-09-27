package org.stock.business;

import java.util.List;

import org.stock.dao.ProduitDAO;
import org.stock.models.Produit;

public class ProduitServiceDefault implements ProduitService {

	private ProduitDAO produitDAO;

	public ProduitServiceDefault(ProduitDAO produitDAO) {
		super();
		this.produitDAO = produitDAO;
	}

	@Override
	public List<Produit> getProduits() {
		return produitDAO.select();
	}

	@Override
	public int add(Produit produit) {
		return produitDAO.insert(produit);
	}

	@Override
	public int remove(int id) {
		return produitDAO.delete(id);
	}

	@Override
	public int update(Produit produit) {
		return produitDAO.update(produit);
	}

	@Override
	public Produit get(int id) {
		return produitDAO.select(id);
	}

}
