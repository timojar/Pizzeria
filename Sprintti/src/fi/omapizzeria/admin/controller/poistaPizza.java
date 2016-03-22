package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PizzaDAO;

/**
 * Servlet implementation class poistaPizza
 */
@WebServlet("/poistaPizza")
public class poistaPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public poistaPizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PizzaDAO kanta = new PizzaDAO();

		String tunnus = request.getParameter("tunnus");
		int id = 0;
		if (tunnus != null) {
			try {
				id = Integer.parseInt(tunnus);

			}

			catch (Exception e) {
				System.out.println("Virhe");

			}

		}

		if (id > 0) {
			kanta.poistaPizza(id);
		}

		response.sendRedirect("/Sprintti/controller?added=true");

	}

}
