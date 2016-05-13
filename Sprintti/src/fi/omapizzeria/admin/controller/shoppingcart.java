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
 * @Timo Jarmala
 */
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
		
			
			
			
			
			
		response.sendRedirect("/Sprintti/menuController");
		
			
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
		

		HttpSession muistiostoslistasta= request.getSession(false);
		PizzaDAO kanta = new PizzaDAO();
		List<Pizza> ostoslista=null;
		boolean noError=true;
		
		try { ostoslista=(List<Pizza>)muistiostoslistasta.getAttribute("ostoslista");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
        double yhteishinta=0;
        Pizza p=null;
		int lkm=0;
		int index=0;
	
		
		
		if(ostoslista==null){
		ostoslista=new ArrayList<Pizza>();}
		
		String idstr=request.getParameter("pizzaid");
		String lkmstr=request.getParameter("lkm");
		int pizzaId=0;	
		
		
			try {
				
			pizzaId=Integer.parseInt(idstr);
			lkm=Integer.parseInt(lkmstr);
			
			}
			
			catch(Exception e){
				
			}
			
			index=ostoslista.size();
			p=kanta.bringPizza(pizzaId);
			yhteishinta=(double)lkm*p.getHinta();
			p.setYhteishinta(yhteishinta);
			p.setLkm(lkm);
			
			
			if(request.getParameter("pizzaid")!=null){
			
			
			
			
			
		
			
			ostoslista.add(p);
			
			if(ostoslista.size()==0){
				muistiostoslistasta= request.getSession(true);
								
			}
			
			
			
			
			try {
			muistiostoslistasta.setAttribute("ostoslista", ostoslista);
			}
			catch (NullPointerException e){
				
			noError=false;	
				
			}
			
			
			if(noError==true){
			
			response.sendRedirect("/Sprintti/shoppingcart");}
			
			
			
			else if(noError==false){
				
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);	
			}
			
			
					
			
			}
			
			
				
		
		
		
	}

}
