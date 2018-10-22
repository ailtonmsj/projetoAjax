package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.Municipio;

public class MunicipioDao {

	private Connection connection;

	public MunicipioDao() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException ex) {
			System.out.println("Erro ao tentar estabelecer conexao com o banco!!!");
		}
	}

	public List<Municipio> buscarMunicipiosPorUfEstado(String ufEstado) {

		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Municipio> municipios = new ArrayList<Municipio>();

		// Otimo lugar para um SQL injection!!!
		String sql = "SELECT id, uf, nome FROM Municipio WHERE " + "uf=" + "'" + ufEstado + "';";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String uf = rs.getString("uf");
				String nome = rs.getString("nome");

				municipios.add(new Municipio(id, uf, nome));
			}

		} catch (SQLException e) {
			System.out.println("erro buscando municipios: " + e.getMessage());

		} finally {
			ConnectionFactory.fecharConexao(stmt, rs);
		}
		return municipios;
	}
}
