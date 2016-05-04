package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PizzaDAO;
import dao.TayteDAO;
import fi.omapizzeria.admin.bean.*;
/**
 * Servlet implementation class Taytteelle
 */
@WebServlet("/Taytteelle")
public class Taytteelle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Taytteelle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tayteId=0;
		
		
		HttpSession sessio= request.getSession(false);
		
		String idstr=request.getParameter("id");
		
		if(idstr!=null){
			
			sessio=request.getSession(true);
			sessio.setAttribute("id", idstr);
				
			}
			try {
			if(idstr==null){
			idstr=(String) sessio.getAttribute("id");	
			
			}}
			
			catch(NullPointerException e){
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);
			}
			
		
	try{	
	tayteId=Integer.parseInt(idstr);	
		
	}catch(Exception e) {
		
	}
	TayteDAO taytehallinta=new TayteDAO();
	Tayte tayte=taytehallinta.tuoTayte(tayteId);
	
	request.setAttribute("tayte", tayte); 
	request.getRequestDispatcher("tayte.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TayteDAO taytehallinta=new TayteDAO();
		PizzaDAO kanta = new PizzaDAO();
		String idstr=request.getParameter("id");
		String nimi=request.getParameter("nimi").trim();
		String maarastr= request.getParameter("maara").trim();
		int id=0;
		int maara=0;
		
		try {
			id=Integer.parseInt(idstr);
			maara=Integer.parseInt(maarastr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("id"+id);
		taytehallinta.muokkaaTayte(nimi, maara, id);
		
		boolean saatavuusyli15=false;

		List<PizzaTayte>noSalepizzas=kanta.naytaLopppuvatPizzatTaytteet(saatavuusyli15);
				
				poistaMenusta(noSalepizzas);
		
		
		response.sendRedirect("/Sprintti/Taytteelle");
		
		
		
		
	}


	private void poistaMenusta(List<PizzaTayte>noSalepizzas){
		PizzaDAO kanta = new PizzaDAO();
			
	for(int i=0; i<noSalepizzas.size(); i++)	{
		
	PizzaTayte pt=noSalepizzas.get(i);
		int piiloitusid=pt.getPizzaid();
		kanta.piilotaPizza(piiloitusid);
		
		
	}
			
			
	
			
			
		}
	
	
}
