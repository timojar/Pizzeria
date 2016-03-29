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
		
	
		request.getRequestDispatcher("muokkaus.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PizzaDAO kanta = new PizzaDAO();
		Pizza pizza=null;
		
		List<Tayte>taytelista=new ArrayList<Tayte>();
		double hinta=0;
		int pizzaId=0;
		String tayteNimi;
		String idstr=request.getParameter("id");
		String nimi=request.getParameter("nimi").trim();
		String hintastr= request.getParameter("hinta");
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
		System.out.println("Ei toimi prkl");
		check=false;
			
		}
		
			
		if(idstr!=null){
			
			
			
			pizza=kanta.bringPizza(pizzaId);
			
			if(nimi.equals("")){
			nimi=pizza.getNimi();	
			
			}
			
			
			if(hintastr==null){
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
