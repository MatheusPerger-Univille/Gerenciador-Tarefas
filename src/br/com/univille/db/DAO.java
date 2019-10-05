package br.com.univille.db;

import java.sql.Connection;

public class DAO {

	public Connection getConnection() {
		return FabricaDeConexoes.getInstance().getConnection();
	}
}
