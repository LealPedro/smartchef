package br.com.smart2.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.smart2.dao.BebidaDao;
import br.com.smart2.dao.PizzaDao;
import br.com.smart2.model.Bebida;
import br.com.smart2.model.Pizza;

@WebServlet({ "/inserir", "/deletar", "/atualizar", "/buscarPizza" })
public class ControllerPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerPizza() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/deletar")) {
			try {
				deletar(request, response);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} else if (request.getServletPath().equals("/buscarPizza")) {
			try {
				buscarPizza(request, response);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/inserir")) {
			try {
				adicionar(request, response);
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}else if (request.getServletPath().equals("/atualizar")) {
			try {
				update(request, response);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} 
	}

	// Método para buscar
	private void buscarPizza(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		HttpSession sessionp = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PizzaDao dao = new PizzaDao();
		
		Pizza pizza = dao.buscaID(id);
		
		sessionp.setAttribute("pizza", pizza);
		
		RequestDispatcher rd = request.getRequestDispatcher("updatePizza.jsp");
		
		rd.forward(request, response);
		
		
		
		
	}

	// Método para atualizar
	private void update(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String sabor = request.getParameter("sabor");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		String tamanho = request.getParameter("tamanho");
		String descricao = request.getParameter("descricao");
		
		//instanciando a classe model PIZZA
		Pizza pizza = new Pizza();
		
		pizza.setDescricao(descricao);
		pizza.setId(id);
		pizza.setSabor(sabor);
		pizza.setTamanho(tamanho);
		pizza.setValor(valor);
		
		PizzaDao dao = new PizzaDao();
		
		dao.update(pizza);
		
		response.sendRedirect("cadastroPizza.jsp");
		
		
	}

	// Método para adicionar
	private void adicionar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		// Pegando os parametros
		String sabor = request.getParameter("sabor");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		String tamanho = request.getParameter("tamanho");
		String descricao = request.getParameter("descricao");
		int bebida = Integer.parseInt(request.getParameter("bebida"));
		
		PizzaDao dao = new PizzaDao();
		// Instanciando a classe DAO
		Pizza pizza = new Pizza();
		BebidaDao daob = new BebidaDao();

		Bebida b = daob.buscaID(bebida);
		pizza.setDescricao(descricao);
		pizza.setBebida(b);
		pizza.setSabor(sabor);
		pizza.setTamanho(tamanho);
		pizza.setValor(valor);

		try {
			dao.inserir(pizza);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("cadastroPizza.jsp");

	}

	// Método para deletar
	private void deletar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {

			int id = Integer.parseInt(request.getParameter("id"));
			PizzaDao dao = new PizzaDao();
			
			dao.delete(id);
			
			response.sendRedirect("cadastroPizza.jsp");
	}

}
