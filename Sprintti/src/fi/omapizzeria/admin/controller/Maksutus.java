package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TilausDao;
import dao.TilausRiviDao;
import email.SahkoPosti;
import fi.omapizzeria.admin.bean.Tilaus;
import fi.omapizzeria.admin.bean.Tilausrivi;
/**
 * @Timo Jarmala
 */
/**
 * Servlet implementation class Maksutus
 */
@WebServlet("/Maksutus")
public class Maksutus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Maksutus() {
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
		
		String vahvistusstr=request.getParameter("maksutus");	
		int tilausnro=0;
		try {
			tilausnro=Integer.parseInt(vahvistusstr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int tilausNro=tilausnro;
	
		String item="";
		
		
		String status="maksettu";
		
		tilauskasittely.vahvistaTilaus(tilausnro,status);
		;
		
		
		
		response.sendRedirect("/Sprintti/SelaaTilauksia?status=vahvistettu");	
		
		
		
		
	}

}
