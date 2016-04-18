package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.RaakaAineDAO;
import dao.TayteDAO;
import fi.omapizzeria.admin.bean.RaakaAine;

/**
 * Servlet implementation class tayteController
 */
@WebServlet("/tayteController")
public class tayteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tayteController() {
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
		System.out.println("testi2121 "+Kayttajanimi);
		
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
		
		
		RaakaAineDAO ainehalinnta=new RaakaAineDAO();
		
		List<RaakaAine> aineet=ainehalinnta.tuoRaakaAineet();
		request.setAttribute("aineet", aineet);
		
		request.getRequestDispatcher("luoTayte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	TayteDAO dao=new TayteDAO();	
		
	String nimi =request.getParameter("tayteNimi");	
	
	String maarasstr=request.getParameter("maara");
	String raakaAine=request.getParameter("aineid");
	int aineId=0;
	int maara=0;
	boolean correct=false;
	
	try {
		aineId=Integer.parseInt(raakaAine);
		maara=Integer.parseInt(maarasstr);
		correct=true;
	}
	
	catch (Exception e){
		System.out.println("Saatavuus pit‰‰ ilmoittaa numerona");	
	}
	
	
	if(correct==true && nimi!=null){
		
	dao.luoTayte(nimi, aineId, maara);	
		
	}
	
	
	response.sendRedirect("/Sprintti/tayteController?added=true");
	}

	
}
