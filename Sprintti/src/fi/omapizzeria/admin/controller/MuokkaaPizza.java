package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.PizzaDAO;
import dao.TayteDAO;
import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.bean.Tayte;

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
		
		
		
		
		HttpSession muistipizzasta= request.getSession(false);
		HttpSession sessio= request.getSession(false);
		
		AdminDao admintiedot = new AdminDao();

		boolean vahvistus = false;
		String Kayttajanimi = "";
		String Salasana = "";

		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("kayttunnus".equals(cookies[i].getName())) {
					Kayttajanimi = cookies[i].getValue();
				}

				if ("password".equals(cookies[i].getName())) {
					Salasana = cookies[i].getValue();
				}

			}
		}

		if (Salasana.equals("") && Kayttajanimi.equals("")) {
			try {

				Kayttajanimi = (String) sessio.getAttribute("tunnus");
				Salasana = (String) sessio.getAttribute("salasana");

			} catch (Exception e) {

			}
		}

		try {

			vahvistus = admintiedot.vahvistaTunnus(Salasana, Kayttajanimi);

			if (vahvistus == true) {

			}

			else if(vahvistus == false) {
				request.getRequestDispatcher("Login.jsp").forward(request,
						response);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("Login.jsp")
					.forward(request, response);
		}
		
		
		PizzaDAO kanta = new PizzaDAO();
		int pizzaId=0;
		
	
		String idstr=request.getParameter("muokkausid");
		
		if(idstr!=null){
			
		muistipizzasta=request.getSession(true);
		muistipizzasta.setAttribute("pizzaid", idstr);
			
		}
		try {
		if(idstr==null){
		idstr=(String) muistipizzasta.getAttribute("pizzaid");	
		
		}}
		
		catch(NullPointerException e){
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
		
	
		try {
			pizzaId=Integer.parseInt(idstr);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
					}
		TayteDAO taytehallinta= new TayteDAO();
		Pizza pizza=kanta.bringPizza(pizzaId);
		Pizza p=null;
		List<Pizza> pizzalista=new ArrayList<Pizza>();
		
		
		List<Pizza> menu=new ArrayList<Pizza>();
		pizzalista.add(pizza);
		
		List<Tayte>taytelista=taytehallinta.haeTaytteet();
		
		request.setAttribute("pizza", pizzalista);
		
		request.setAttribute("taytelista", taytelista);
		
	if(vahvistus==true){
		request.getRequestDispatcher("muokkaus.jsp").forward(request, response);
	}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PizzaDAO kanta = new PizzaDAO();
		Pizza pizza=null;
		
		List<Tayte>taytelista=new ArrayList<Tayte>();
		boolean numerotarkistus=true;
		double hinta=0;
		int pizzaId=0;
		String tayteNimi;
		String idstr=request.getParameter("id");
		String nimi=request.getParameter("nimi").trim();
		String hintastr= request.getParameter("hinta").trim();
		String kuvaus="";
		boolean check=true;
		
String [] taytteet=request.getParameterValues("taytteet");
		
	try {
		pizzaId=Integer.parseInt(idstr);
		
	}
	catch (Exception e){
		e.printStackTrace();
	}
	
	
	try {
	hinta=Double.parseDouble(hintastr);
		
	} catch (Exception e) {
		numerotarkistus=false;
	}
	
	
		try {
		for(int i=0; i<taytteet.length; i++){
			tayteNimi=taytteet[i];
			taytelista.add(new Tayte(tayteNimi));
			System.out.println(taytteet[i]);
		}
		
		}
		
		catch(NullPointerException e){
		
		
		}
		
		if(taytelista.size()==0){
		
		taytelista.add(new Tayte("kebab"));	
		
		check=false;
			
		}
		
			
		if(idstr!=null){
			
			
			
			pizza=kanta.bringPizza(pizzaId);
			
			if(nimi.equals("")){
			nimi=pizza.getNimi();	
			
			}
			
			
			if(hintastr.equals("") || numerotarkistus==false){
			hinta=pizza.getHinta();
			}
			
			try {
				kuvaus=pizza.getKuvaus();
			} catch (Exception e) {
				kuvaus="";
			}
			
			int id=pizzaId;
			
			kanta.muokkaaPizza(id, nimi, hinta, kuvaus, taytelista, check);
			
		}
		
		
		
		response.sendRedirect("/Sprintti/MuokkaaPizza");
	}

}
