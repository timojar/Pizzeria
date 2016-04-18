package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.RaakaAineDAO;

/**
 * Servlet implementation class raakaAineet
 */
@WebServlet("/raakaAineet")
public class raakaAineet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public raakaAineet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("raakaaineet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RaakaAineDAO ainehallinta= new RaakaAineDAO();
		
		String nimi =request.getParameter("RaakaNimi");	
		
		String saatavuusstr=request.getParameter("saatavuus");
		int saatavuus=0;
		boolean correct=false;
		
		try {
			saatavuus=Integer.parseInt(saatavuusstr);
			correct=true;
		}
		
		catch (Exception e){
			System.out.println("Saatavuus pit‰‰ ilmoittaa numerona");	
		}
		
		
		if(correct==true && nimi!=null){
			
		ainehallinta.luoRaakaaine(nimi, saatavuus);
			
		}
		
		
	}

}
