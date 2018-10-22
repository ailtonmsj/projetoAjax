package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.Estado;

public class EstadoDao {

	private Connection connection;

	Statement stmt = null;
	ResultSet rs = null;

	public EstadoDao() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro ao tentar criar uma conexao!!!");
		}
	}

	public List<Estado> buscarEstados() {

		ArrayList<Estado> estados = new ArrayList<Estado>();

		String sql = "SELECT id, uf, nome FROM Estado";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String uf = rs.getString("uf");
				String nome = rs.getString("nome");

				estados.add(new Estado(id, uf, nome));
			}

		} catch (SQLException e) {
			System.out.println("erro buscando os estados: " + e.getMessage());

		} finally {
			ConnectionFactory.fecharConexao(stmt, rs);
		}
		return estados;
	}

	public Estado buscarEstadoPorNome(String nomeEstado) {

		Estado estado = null;

		// Otimo lugar para um SQL injection!!!
		String sql = "SELECT id, uf, nome FROM Estado WHERE nome=" + "'" + nomeEstado + "';";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String uf = rs.getString("uf");
				String nome = rs.getString("nome");

				estado = new Estado(id, uf, nome);
			}
		} catch (SQLException e) {
			System.out.println("erro buscando estados por nome: " + e.getMessage());

		} finally {
			ConnectionFactory.fecharConexao(stmt, rs);
		}
		return estado;
	}
}