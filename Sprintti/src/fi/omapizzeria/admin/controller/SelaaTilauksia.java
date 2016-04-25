package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.*;
import dao.AsiakasDAO;
import dao.TilausDao;
import dao.TilausRiviDao;

/**
 * Servlet implementation class SelaaTilauksia
 */
@WebServlet("/SelaaTilauksia")
public class SelaaTilauksia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelaaTilauksia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		AsiakasDAO a=new AsiakasDAO();
		Asiakas tilausAsiakas =null;
		TilausDao tilauskasittely=new TilausDao();
		Tilaus tilaus=null;
		List<Tilaus>tilaukset=tilauskasittely.haeTilaukset();
		List<Tilaus>tilaustiedot=new ArrayList<Tilaus>();
		int asiakasnumero=0;
		 
for(Tilaus t : tilaukset) {
		    
	asiakasnumero=t.getAsiakasnumero();	
	
	
	tilausAsiakas=a.tuoTilaaja(asiakasnumero);
	System.out.println(tilausAsiakas.getEmail());
	t.setTilausAsiakas(tilausAsiakas);
			
	tilaustiedot.add(t);
	
		}
		
		
		 
		
		
		request.setAttribute("tilaukset", tilaukset);
		
		
		
		
		
		request.getRequestDispatcher("tilaukset.jsp").forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
