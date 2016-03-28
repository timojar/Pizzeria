package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PizzaDAO;
import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class MuokkaaPizza
 */
@WebServlet("/MuokkaaPizza")
public class MuokkaaPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuokkaaPizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PizzaDAO kanta = new PizzaDAO();
		int pizzaId=0;
		String idstr=request.getParameter("muokkausid");
	
		try {
			pizzaId=Integer.parseInt(idstr);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
					}
		
		Pizza pizza=kanta.bringPizza(pizzaId);
	System.out.println(pizza.getNimi());
		
		request.setAttribute("pizza", "pizza");
		
		

		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PizzaDAO kanta = new PizzaDAO();
		
		
		
		
		
	}

}
