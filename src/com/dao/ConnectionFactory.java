package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao banco");
			// Use suas configuracoes de banco de dados
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "projeto_ajax", "root", "root");
		} catch (ClassNotFoundException e) {
			System.out.println("Nao conectado");
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
	}

	public static void fecharConexao(Statement stmt, ResultSet rs) {
		try {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			System.out.println("erro ao tentar " + "fechar a conexao: " + e.getMessage());
		}
	}
}