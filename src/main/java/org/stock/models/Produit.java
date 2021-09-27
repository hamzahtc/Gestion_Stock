package org.stock.models;

public class Produit {

	private int id;
	private String nom;
	private int quantite;
	private double prix;

	public Produit() {

	}

	public Produit(String nom, int quantite, double prix) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Produit(int id, String nom, int quantite, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + "]";
	}

}
