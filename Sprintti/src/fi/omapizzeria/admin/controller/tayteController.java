package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TayteDAO;

/**
 * Servlet implementation class tayteController
 */
@WebServlet("/tayteController")
public class tayteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tayteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.getRequestDispatcher("luoTayte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	TayteDAO dao=new TayteDAO();	
		
	String nimi =request.getParameter("tayteNimi");	
	
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
		
	dao.luoTayte(nimi, saatavuus);	
		
	}
	
	System.out.println(nimi+" "+saatavuusstr);
	response.sendRedirect("/Sprintti/tayteController?added=true");
	}

	
}
