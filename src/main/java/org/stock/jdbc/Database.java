package org.stock.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.stock.models.Produit;

public class Database {
	private DataSource dataSource;
	private Connection db;

	public Database() {
	}

	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db = dataSource.getConnection();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public String[][] executeSelect(String query) {
		try {
			Statement sql = db.createStatement();// permet d'executer a query
			// DDL, DML, DCL, ...
			ResultSet rs = sql.executeQuery(query);
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();

			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			String data[][] = new String[rows + 1][cols];
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			int row = 0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}
			}
			rs.close();
			return data;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	public String[][] select() {
		return executeSelect("SELECT * FROM Produits");
	}

	public String[][] select(int id) {
		String query = "SELECT * FROM Produits WHERE id = " + 16;
		System.out.println(query);
		return executeSelect(query);
	}

	public int insert(Produit produit) {
		String sql = "INSERT INTO Produits VALUES ('', ?, ?, ?)";

		PreparedStatement statement;
		try {
			statement = db.prepareStatement(sql);
			statement.setString(1, produit.getNom());
			statement.setInt(2, produit.getQuantite());
			statement.setDouble(3, produit.getPrix());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new produit was inserted successfully!");
			}
			return rowsInserted;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int delete(int id) {
		String sql = "DELETE FROM Produits WHERE id=?";

		PreparedStatement statement;
		try {
			statement = db.prepareStatement(sql);
			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A produit was deleted successfully!");
			}
			return rowsDeleted;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public int update(Produit produit) {
		String sql = "UPDATE Produits SET nom=?, quantite=?, prix=? WHERE id=?";

		PreparedStatement statement;
		try {
			statement = db.prepareStatement(sql);
			statement.setString(1, produit.getNom());
			statement.setInt(2, produit.getQuantite());
			statement.setDouble(3, produit.getPrix());
			statement.setInt(4, produit.getId());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing produit was updated successfully!");
			}
			return rowsUpdated;
		} catch (SQLException e) {
			return -1;
		}

	}

}
