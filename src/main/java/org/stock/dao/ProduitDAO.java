package org.stock.dao;

import java.util.List;

import org.stock.models.Produit;

public interface ProduitDAO {

	public int insert(Produit produit);

	public List<Produit> select();

	public int delete(int id);

	public int update(Produit produit);

	public Produit select(int id);

}
