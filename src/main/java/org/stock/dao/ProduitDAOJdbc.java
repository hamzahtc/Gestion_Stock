package org.stock.dao;

import java.util.List;
import java.util.Vector;

import org.stock.dao.mapping.ProduitMapper;
import org.stock.jdbc.Database;
import org.stock.models.Produit;

public class ProduitDAOJdbc implements ProduitDAO {

	private Database db;

	public ProduitDAOJdbc(Database db) {
		super();
		this.db = db;
	}

	@Override
	public List<Produit> select() {
		String data[][] = db.select();
		// Mapping Objet/relationnel
		Vector<Produit> produits = new Vector<Produit>();
		for (int i = 1; i < data.length; i++) {
			produits.add(ProduitMapper.getProduit(data[i]));
		}
		return produits;
	}

	@Override
	public int insert(Produit produit) {
		return db.insert(produit);
	}

	@Override
	public int delete(int id) {
		return db.delete(id);
	}

	@Override
	public int update(Produit produit) {
		return db.update(produit);
	}

	@Override
	public Produit select(int id) {
		String data[][] = db.select(id);
		// Mapping Objet/relationnel
		return ProduitMapper.getProduit(data[1]);
	}

}
