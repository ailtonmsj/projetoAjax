package com.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EstadoDao;
import com.domain.Estado;

public class Redirect extends HttpServlet {

	public void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, 
												IOException {

		List<Estado> estados = new EstadoDao().buscarEstados();
		
		req.setAttribute("estados", estados);
		
		RequestDispatcher view = req.getRequestDispatcher
											("view/selecao.jsp");
		view.forward(req, resp);
	}
}