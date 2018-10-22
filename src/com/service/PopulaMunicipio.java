package com.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.EstadoDao;
import com.dao.MunicipioDao;
import com.domain.Estado;
import com.domain.Municipio;

public class PopulaMunicipio extends HttpServlet {

	public void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException,
												IOException {

		String nomeEstado = req.getParameter("estado");
		Estado estado = new EstadoDao().buscarEstadoPorNome(nomeEstado);
		
		List<Municipio> municipios = new MunicipioDao().
					buscarMunicipiosPorUfEstado(estado.getUf());
		
		OutputStream out = resp.getOutputStream();
		out.write(municipios.toString().getBytes());
	}
	
	public void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, 
												IOException {
		doPost(req, resp);
	}
}
