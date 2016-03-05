package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controller() {
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
		HttpSession sessio = request.getSession(false);
		List<Pizza> pizzalista = null;

		PizzaDAO kanta = new PizzaDAO();

		pizzalista = kanta.haePizzat(pizzalista);

		request.setAttribute("lista", pizzalista);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double hinta;
		List<Pizza> pizzalista = null;
		DecimalFormat desimaalit = new DecimalFormat("0.00");

		String nimi = request.getParameter("nimi");

		String hintasana = request.getParameter("hinta");

		try {
			hinta = Double.parseDouble(hintasana);
		}

		catch (Exception e) {
			hinta = 0;

		}

/**
 * pizzanpoisto: Pizzan id otetaan vastaan parametrina. Se käännetään Merkkijonosta int-numeroon
 */

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

		PizzaDAO kanta = new PizzaDAO();
		
		/**
		 * pizzanpoisto: Int-numero välitetään parametrina PizzaDAO-luokalle, joka lähettää käskyn tietokantaan.
		 */


		if (id > 0) {
			kanta.poistaPizza(id);
		}

		if (nimi != null) {
			pizzalista = kanta.haePizzat(pizzalista);
			id = pizzalista.size() + 1;
			kanta.lisaaPizza(id, nimi, hinta);
		}

		response.sendRedirect("/Sprintti/controller?added=true");

	}

}
