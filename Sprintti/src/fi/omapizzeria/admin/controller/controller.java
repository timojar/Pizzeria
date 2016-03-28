package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import fi.omapizzeria.admin.bean.*;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controller() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AdminDao admintiedot= new AdminDao();
		
		boolean vahvistus=false;
		String Kayttajanimi="";
		String Salasana="";
		
		
		HttpSession sessio = request.getSession(false);
		Cookie[] cookies= request.getCookies();
		if(cookies!=null){
			
			for(int i=0; i<cookies.length; i++){
				
				
				if("kayttunnus".equals(cookies[i].getName())){
					Kayttajanimi=cookies[i].getValue();
				}
				
				
				if("password".equals(cookies[i].getName())){
					Salasana=cookies[i].getValue();
				}
				
				
			}
		}
		
		
		if(Salasana.equals("") && Kayttajanimi.equals("")){
		try {
			
	    Kayttajanimi=(String)sessio.getAttribute("tunnus");
		Salasana=(String)sessio.getAttribute("salasana");
		
		
		}
		catch(Exception e){
			
		}
		}
		
		try {

			
			vahvistus=admintiedot.vahvistaTunnus(Salasana, Kayttajanimi);
				
				if(vahvistus==true){
					
								
			
					System.out.println("Testi");
				}
		
				else {
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
	
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("Login.jsp").forward(request, response);	
		}
		
		
		
		int noofPizzas, pizzasperPage, page, nextIndex, noofPages, startindex;
		
		PizzaDAO kanta = new PizzaDAO();
		TayteDAO taytehallinta= new TayteDAO();
		
		 noofPizzas=kanta.getnoofPizzas();
		pizzasperPage=5;
		page=1;
		try {
		page=Integer.parseInt(request.getParameter("page"));}
		
		
		catch (Exception e) {
			
		}
		
		if (request.getParameter("page")==null){page=1;
		
		}
			
		ServletContext context=getServletContext();
		String v=(String)request.getAttribute("visible");
		
		
			System.out.println(v);
	
		startindex=2;
		 nextIndex=(page-1)*pizzasperPage;
		  noofPages=noofPizzas/pizzasperPage+1;
		 
		List<Pizza>pizzalista = kanta.haePizzat(nextIndex, pizzasperPage);
		List<Tayte>taytelista=taytehallinta.haeTaytteet();
		
		if(noofPages>1){
			startindex=1;
		}
		
		request.setAttribute("startindex", startindex);
		request.setAttribute("taytelista", taytelista);
		request.setAttribute("noofPages", noofPages);
		request.setAttribute("lista", pizzalista);
		request.getRequestDispatcher("list.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Piilotiusu");
		
		ArrayList<Pizza> pizzalista;
		

		AdminDao admintiedot= new AdminDao();

		String Salasana=request.getParameter("Salasana");
		String Kayttajanimi=request.getParameter("Kayttajanimi");
		String muisti=request.getParameter("memory");
		Boolean vahvistus=false;
		
		HttpSession sessio = request.getSession(false);
		
		
		if(request.getParameter("Kayttajanimi")!=null){
			
			
			vahvistus=admintiedot.vahvistaTunnus(Salasana, Kayttajanimi);}
	
		if(vahvistus==true){
			
			System.out.println("Cookie tstaus");
			 sessio = request.getSession(true);	
			 sessio.setAttribute("tunnus", Kayttajanimi);
				sessio.setAttribute("salasana", Salasana);
			if(muisti!=null){
				
			Cookie ck=new Cookie("kayttunnus", Kayttajanimi);
			ck.setMaxAge(60*60*24*365);
			response.addCookie(ck);
			
			ck=new Cookie("password", Salasana);
			ck.setMaxAge(60*60*24*365);
			response.addCookie(ck);
				
			}
			
		}
		
		else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}
		
	
		
		
		
		response.sendRedirect("/Sprintti/controller?added=true");

	

}}
