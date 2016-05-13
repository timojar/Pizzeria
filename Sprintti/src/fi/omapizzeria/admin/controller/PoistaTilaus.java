package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TilausDao;
import dao.TilausRiviDao;
/**
 * @Timo Jarmala
 */
/**
 * Servlet implementation class PoistaTilaus
 */
@WebServlet("/PoistaTilaus")
public class PoistaTilaus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoistaTilaus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		TilausDao tilauskasittely=new TilausDao();
		TilausRiviDao rivihhalinta=new TilausRiviDao();
		String idstr=request.getParameter("id");	
		int tilausnro=0;
		try {
			tilausnro=Integer.parseInt(idstr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	
		
		
		
	
		rivihhalinta.poistaRiv(tilausnro);
		tilauskasittely.poistaTilaus(tilausnro);
			
		
		response.sendRedirect("/Sprintti/SelaaTilauksia");	
		
		
	}

}
