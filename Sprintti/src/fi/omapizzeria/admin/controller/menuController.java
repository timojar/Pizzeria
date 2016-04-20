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
import fi.omapizzeria.admin.bean.Asiakas;
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
		

	HttpSession muistiostoslistasta= request.getSession(false);	
	HttpSession sessio= request.getSession(false);	
	List<Pizza> ostoslista=null;
	Asiakas asiakas=null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {

		for (int i = 0; i < cookies.length; i++) {

			if ("kayttunnus".equals(cookies[i].getName())) {
				String logged = "logged";
				String Kayttajanimi = cookies[i].getValue();
				request.setAttribute("logged", logged);
				request.setAttribute("tunnus", Kayttajanimi);
			}

		
		}}

	try {
		asiakas=(Asiakas)sessio.getAttribute("asiakas");
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	try {ostoslista=(List<Pizza>)muistiostoslistasta.getAttribute("ostoslista");	
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	List<Asiakas>asiakastiedot=new ArrayList<Asiakas>();
	asiakastiedot.add(asiakas);
	
	
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
