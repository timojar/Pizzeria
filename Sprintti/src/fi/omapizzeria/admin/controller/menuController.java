package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.MenuDao;
import fi.omapizzeria.admin.bean.Pizza;


/**
 * Servlet implementation class menuController
 */
@WebServlet("/menuController")
public class menuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
AdminDao admintiedot= new AdminDao();
		
		boolean vahvistus=false;
		String Kayttajanimi="";
		String Salasana="";
		
		
		HttpSession sessio = request.getSession(false);
		Cookie[] cookies= request.getCookies();
		System.out.println("testi2121 "+Kayttajanimi);
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
		
		
	
	MenuDao menukanta= new MenuDao();
	
	Pizza pizza=null;
	int pizzaNo, id;
	String nimi, kuvaus;
	double hinta;
	List<Pizza>pizzalista=menukanta.haePizzat();
	List<Pizza>pizzamenu=new ArrayList<Pizza>();
	for(int i=0; i<pizzalista.size(); i++){
		
	pizza=pizzalista.get(i);
	id=pizza.getId();
	nimi=pizza.getNimi();
	kuvaus=pizza.getKuvaus();
	hinta=pizza.getHinta();
	pizzaNo=i+1;
	pizzamenu.add(new Pizza( id,  nimi,  hinta,  kuvaus, pizzaNo));
		
	}
	
	request.setAttribute("menu", pizzamenu);
	
	request.getRequestDispatcher("menu.jsp").forward(request, response);
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
