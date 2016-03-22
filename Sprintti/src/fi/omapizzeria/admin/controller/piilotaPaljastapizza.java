package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PizzaDAO;

/**
 * Servlet implementation class piilotaPaljastapizza
 */
@WebServlet("/piilotaPaljastapizza")
public class piilotaPaljastapizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public piilotaPaljastapizza() {
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
		
		/**
		 * Pizzan piiloitus: Pizzan id otetaan vastaan parametrina merkkijono-muodossa. 
		 */	
				
		
		String piiloitus= request.getParameter("hide");
		String paljasta= request.getParameter("reveal");
			
		
			
		
		int	piiloitusid, paljastaid;
		piiloitusid=1;
		paljastaid=1;
		
		
		/**
		 * Pizzan piiloitus: Jos saatu parametri ei ole tyhj‰, Se k‰‰nnet‰‰n Merkkijonosta int-numeroon ja
		 *  v‰litet‰‰n metodissa "piilotaPizza(piiloitusid)" parametrina.
		 */	
		PizzaDAO kanta = new PizzaDAO();
		
		
		
		if (request.getParameter("hide")!=null){
		
			try {
				piiloitusid = Integer.parseInt(piiloitus);
			kanta.piilotaPizza(piiloitusid);
			}

			catch (Exception e) {
			
			}}
		
		
		if (request.getParameter("reveal")!=null){
			
			try {
				paljastaid = Integer.parseInt(paljasta);
			kanta.poistaPiiloitus(paljastaid);
			}

			catch (Exception e) {
			
			}}
		
		System.out.println(piiloitus);
		
		response.sendRedirect("/Sprintti/controller?added=true");
		
	}

}
