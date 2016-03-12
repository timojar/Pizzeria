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

import org.apache.catalina.connector.Request;

import fi.omapizzeria.admin.bean.*;

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
		

		int noofPizzas, pizzasperPage, page, nextIndex, noofPages, startindex;
		
		PizzaDAO kanta = new PizzaDAO();
		TayteDAO taytehallinta= new TayteDAO();
		
		 noofPizzas=kanta.getnoofPizzas();
		pizzasperPage=5;
		page=1;
		try {
		page=Integer.parseInt(request.getParameter("page"));}
		
		
		catch (Exception e) {
			
		}
		
		if (request.getParameter("page")==null){page=1;
		
		}
			
		startindex=2;
		 nextIndex=(page-1)*pizzasperPage;
		  noofPages=noofPizzas/pizzasperPage+1;
		 
		List<Pizza>pizzalista = kanta.haePizzat(nextIndex, pizzasperPage);
		List<Tayte>taytelista=taytehallinta.haeTaytteet();
		
		if(noofPages>1){
			startindex=1;
		}
		
		request.setAttribute("startindex", startindex);
		request.setAttribute("taytelista", taytelista);
		request.setAttribute("noofPages", noofPages);
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
		double hinta=0;
		ArrayList<Pizza> pizzalista;
		

		String nimi = request.getParameter("nimi");
		String kuvaus = request.getParameter("kuvaus");
		String hintasana = request.getParameter("hinta");
		String poisto= request.getParameter("hide");
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
		
			kanta.lisaaPizza( nimi, hinta, kuvaus);
		}

		int	poistoid=1;
	
		if (request.getParameter("hide")!=null){
		
			try {
				poistoid = Integer.parseInt(poisto);
			kanta.piilotaPizza(poistoid);
			}

			catch (Exception e) {
				

			}}
		
		response.sendRedirect("/Sprintti/controller?added=true");

	

}}
