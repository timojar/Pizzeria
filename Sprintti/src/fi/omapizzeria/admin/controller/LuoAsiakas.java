package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AsiakasDAO;
import fi.omapizzeria.admin.bean.Asiakas;

/**
 * Servlet implementation class LuoAsiakas
 */
@WebServlet("/LuoAsiakas")
public class LuoAsiakas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuoAsiakas() {
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
		
		String etunimi=request.getParameter("enimi");
		String sukunimi=request.getParameter("snimi");
		String email=request.getParameter("email");
		String salattavaTeksti=request.getParameter("salasana");
		String puhelinstr=request.getParameter("numero");
		int numero=0;
		
		try {
			
			numero=Integer.parseInt(puhelinstr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		AsiakasDAO asiakashallinta=new AsiakasDAO();
		
		Asiakas asiakas=asiakashallinta.luoAsiakas(etunimi, sukunimi, email, salattavaTeksti, numero);
		
		
		HttpSession sessio = request.getSession(true);
		String logged="logged";
		sessio.setAttribute("logged", logged);
		sessio.setAttribute("tunnus", asiakas.getEmail());
		sessio.setAttribute("salasana", asiakas.getSalasana());
	
		response.sendRedirect("/Sprintti/menuController");
	}

}
