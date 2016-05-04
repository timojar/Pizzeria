package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DecimalFormat;

import dao.TayteDAO;
import dao.TilausDao;
import dao.TilausRiviDao;
import email.SahkoPosti;
import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.bean.PizzaTayte;
import fi.omapizzeria.admin.bean.Tayte;
import fi.omapizzeria.admin.bean.Tilaus;
import fi.omapizzeria.admin.bean.Tilausrivi;

/**
 * Servlet implementation class Tilaukselle
 */
@WebServlet("/Tilaukselle")
public class Tilaukselle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tilaukselle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tilausNro=0;
		String tilausNrostr= request.getParameter("numero");
		int tilausnro=0;
		try {tilausNro=Integer.parseInt(tilausNrostr);
			tilausnro=tilausNro;
		} catch (Exception e) {e.printStackTrace();
			// TODO: handle exception
		}
		TilausDao tilauskasittely = new TilausDao();
		TilausRiviDao rivihallinta=new TilausRiviDao();
		
		List<Tilausrivi>rivit=rivihallinta.haeRivit(tilausNro);
		
		for(Tilausrivi p : rivit) {
		   
		}
		Tilaus tilaus=tilauskasittely.haeTilaus(tilausnro);
		
		request.setAttribute("tilauksenstatus", tilaus.getStatus());
		request.setAttribute("tilausid", tilausNro);
		request.setAttribute("rivit", rivit);
		
		request.getRequestDispatcher("tilaus.jsp").forward(request, response);
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DecimalFormat desimaalit=new DecimalFormat("0.00");
		TilausRiviDao rivihallinta=new TilausRiviDao();
		TilausDao tilauskasittely=new TilausDao();
		TayteDAO taytehallinta=new TayteDAO();
		String vahvistusstr=request.getParameter("vahvistus");	
		int tilausnro=0;
		try {
			tilausnro=Integer.parseInt(vahvistusstr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int tilausNro=tilausnro;
		List<Tilausrivi>rivit=rivihallinta.haeRivit(tilausNro);
		
		String item="";
		Tilausrivi rivi=null;
		String linebreak=System.getProperty("line.separator");
		rivi=rivit.get(0);
		
		kulutaTaytteet(rivit);
		
		for(int i=0; i<rivit.size(); i++){
			rivi=rivit.get(i);
			item=item+linebreak+rivi.getPizza().getNimi()+" "+rivi.getLkm()+" kpl "+desimaalit.format(rivi.getHinta())+
					" EUR";
			
			
			
			
			
			}
			
			
			
			
			
			
		
		String status="vahvistettu";
		tilauskasittely.vahvistaTilaus(tilausnro,status);
		Tilaus t=tilauskasittely.haeTilaus(tilausnro);
		
		String etunimi=t.getTilausAsiakas().getEtunimi();
		String sukunimi=t.getTilausAsiakas().getSukunimi();
		String emailinSisalto="Hei "+etunimi+" "+sukunimi+linebreak
				+ "Tilauksenne:"+linebreak
				+item+linebreak+linebreak+"toimitetaan 30-60 minuutin kuluttua."+linebreak+linebreak+"Ystävällisin Terveisin"+linebreak+"Castello & Fior";
		String otsikko="Tilauksenne";
		String lahettajanGoogleEmail= "88juslin@gmail.com";
		String lahettajanGoogleSalasana="88juslin!";
		String vastaanottajanEmail=t.getTilausAsiakas().getEmail();
		
		SahkoPosti sposti=new SahkoPosti();
		
		sposti.lahetaSahkoposti(lahettajanGoogleEmail, lahettajanGoogleSalasana, vastaanottajanEmail, otsikko, emailinSisalto);
		
		System.out.println(emailinSisalto);
		
		
		response.sendRedirect("/Sprintti/SelaaTilauksia");
		
	}

	private void kulutaTaytteet(List<Tilausrivi>rivit){
		
		

		TayteDAO taytehallinta=new TayteDAO();
		List<Tayte>kulutetutTaytteet=new ArrayList<Tayte>();
		List<PizzaTayte>pizzaTaytteet=new ArrayList<PizzaTayte>();
		
		for (int t=0; t<rivit.size(); t++){
	Tilausrivi r=rivit.get(t);
		for (int e=0; e<r.getLkm(); e++){
			int pizzaid=r.getPizzaid();	
			pizzaTaytteet=taytehallinta.haePizzaTaytteet(pizzaid);
				
			
			for(PizzaTayte piz: pizzaTaytteet){
			
				int id=piz.getTayteid();
				String tayteNimi=piz.getPizzanimi();
				
			kulutetutTaytteet.add(new Tayte(id ,tayteNimi))	;
				
			}
		}}
		
		taytehallinta.maaranVahennys(kulutetutTaytteet);
		
		
	}
	
	
}
