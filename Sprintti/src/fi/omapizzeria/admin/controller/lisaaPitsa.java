package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import dao.PizzaDAO;
import fi.omapizzeria.admin.bean.Tayte;

/**
 * Servlet implementation class lisaaPitsa
 */
@WebServlet("/lisaaPitsa")
public class lisaaPitsa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lisaaPitsa() {
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
		List<Tayte>taytelista=new ArrayList<Tayte>();
		double hinta=0;
		String nimi = request.getParameter("nimi");
		String kuvaus = request.getParameter("kuvaus");
		String hintasana = request.getParameter("hinta");
		String tayteNimi;
		String [] taytteet=request.getParameterValues("taytteet");
		
	
		for(int i=0; i<taytteet.length; i++){
			tayteNimi=taytteet[i];
			taytelista.add(new Tayte(tayteNimi));
		}
		
		PizzaDAO kanta = new PizzaDAO();
		
		try {
			hinta = Double.parseDouble(hintasana);
		}

		catch (Exception e) {
			hinta = 0;

		}
		
		
		if (nimi != null) {
			
			kanta.lisaaPizza( nimi, hinta,  taytelista);
		}	
		
		
		response.sendRedirect("/Sprintti/controller?added=true");
		
	}

}
