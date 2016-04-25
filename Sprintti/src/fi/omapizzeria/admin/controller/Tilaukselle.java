package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TilausRiviDao;
import fi.omapizzeria.admin.bean.Tilausrivi;

/**
 * Servlet implementation class Tilaukselle
 */
@WebServlet("/Tilaukselle")
public class Tilaukselle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tilaukselle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int TilausNro=0;
		String TilausNrostr= request.getParameter("numero");
		
		try {TilausNro=Integer.parseInt(TilausNrostr);
			
		} catch (Exception e) {e.printStackTrace();
			// TODO: handle exception
		}
		
		TilausRiviDao rivihallinta=new TilausRiviDao();
		
		List<Tilausrivi>rivit=rivihallinta.haeRivit(TilausNro);
		
		request.setAttribute("rivit", rivit);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
