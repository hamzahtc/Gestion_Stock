package org.stock.dao.mapping;

import org.stock.models.Produit;

public class ProduitMapper {

	public ProduitMapper() {
	}

	public static Produit getProduit(String... row) {
		return new Produit(getInt(row[0]), row[1], getInt(row[2]), getDouble(row[3]));
	}

	public static int getInt(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static int getInt(String value) {
		return getInt(value, 0);
	}

	public static double getDouble(String value, double defaultValue) {
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static double getDouble(String value) {
		return getDouble(value, 0);
	}
}
