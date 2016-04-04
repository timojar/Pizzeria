package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import dao.MenuDao;
import dao.PizzaDAO;
import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class shoppingcart
 */
@WebServlet("/shoppingcart")
public class shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession muistiostoslistasta= request.getSession(false);
		PizzaDAO kanta = new PizzaDAO();
		List<Pizza> ostoslista=new ArrayList<Pizza>();
		Pizza p=null;
		
		ostoslista=(List<Pizza>)muistiostoslistasta.getAttribute("ostoslista");
		String idstr=request.getParameter("pizzaid");
		int pizzaId=0;	
		
		
			try {
				
			pizzaId=Integer.parseInt(idstr);	
			System.out.println("Pizza id on"+pizzaId );
			}
			
			catch(Exception e){
				
			}
			
			
			if(request.getParameter("pizzaid")!=null){
			p=kanta.bringPizza(pizzaId);
			
			ostoslista.add(p);
			
			if(ostoslista.size()==0){
				muistiostoslistasta= request.getSession(true);
								
			}
			
			
			
			
			
			muistiostoslistasta.setAttribute("ostoslista", ostoslista);
			
			
			
			
			
			
					
			
			}
			
			
			
			
			
			
			request.setAttribute("ostos", ostoslista);
			
			request.getRequestDispatcher("ostoskori.jsp").forward(request, response);
		
			
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
		
		
		
		
		
	}

}
