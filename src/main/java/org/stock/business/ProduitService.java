package org.stock.business;

import java.util.List;

import org.stock.models.Produit;

public interface ProduitService {

	public List<Produit> getProduits();

	public int add(Produit produit);

	public int remove(int id);

	public int update(Produit produit);

	public Produit get(int id);

}
