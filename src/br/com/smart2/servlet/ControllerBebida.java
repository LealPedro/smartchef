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

import com.google.gson.Gson;

import br.com.smart2.dao.BebidaDao;
import br.com.smart2.model.Bebida;

@WebServlet({ "/excluir", "/editar", "/buscarBebida", "/adicionar", "/listar" })
public class ControllerBebida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerBebida() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		if (request.getServletPath().equals("/excluir")) { // url para DELETAR

			int id = Integer.parseInt(request.getParameter("id"));

			BebidaDao dao = new BebidaDao();

			dao.delete(id);

			response.sendRedirect("cadastroBebida.jsp");

		} else if (request.getServletPath().equals("/buscarBebida")) { // buscar bebida
			HttpSession session2 = request.getSession();

			Integer id = Integer.parseInt(request.getParameter("id"));
			BebidaDao dao = new BebidaDao();

			try {
				Bebida bebida1 = dao.buscaID(id);

				session2.setAttribute("bebida1", bebida1);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("updateBebida.jsp");
			rd.forward(request, response);

		} else if (request.getServletPath().equals("/editar")) { // URL para editar

			int id = Integer.parseInt(request.getParameter("id"));

			String nome = request.getParameter("nome");

			String tamanho = request.getParameter("tamanho");

			Double valor = Double.parseDouble(request.getParameter("valor"));

			Bebida bebida = new Bebida();

			bebida.setId(id);
			bebida.setNome(nome);
			bebida.setTamanho(tamanho);
			bebida.setValor(valor);

			BebidaDao dao = new BebidaDao();

			try {
				dao.update(bebida);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.sendRedirect("cadastroBebida.jsp");

		} else if (request.getServletPath().equals("/adicionar")) {

			try {
				new BebidaDao().inserir(new Gson().fromJson(request.getReader(), Bebida.class));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect("cadastroBebida.jsp");

		} else if (request.getServletPath().equals("/listar")) {
			BebidaDao bebidaDao = new BebidaDao();

			//request.setAttribute("bebida", new Gson().toJson(bebidaDao.listar()));
			response.getWriter().append(new Gson().toJson(bebidaDao.listar()));
		}
	}
}
