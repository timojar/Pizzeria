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
import fi.omapizzeria.admin.bean.PizzaTayte;
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
		
		
		boolean vahvistus=false;
		/**
		 * Pizzan muokkaus: Otetaan vanha sessio k‰yttˆˆn, josta otetaan muokatun pizzan id
		 */	
		HttpSession muistipizzasta= request.getSession(false);
		
		vahvistus= tunnistaKayttaja(request, response);
		
		if (vahvistus == true) {

		}

		else if (vahvistus == false) {
			request.getRequestDispatcher("Login.jsp").forward(request,
					response);
		}
		
		PizzaDAO kanta = new PizzaDAO();
		int pizzaId=0;
		
		/**
		 * Pizzan muokkaus: Otetaan pizzaid parametrina list.jsp:lt‰ vastaan. 
		 * Jos parametri ei ole tyhj‰, luodaan uusi sessio, johon laitetaan pizzaid.
		 */	
	
		String idstr=request.getParameter("muokkausid");
		
		if(idstr!=null){
			
		muistipizzasta=request.getSession(true);
		muistipizzasta.setAttribute("pizzaid", idstr);
			
		}
		
		/**
		 * Jos parametri on tyhj‰ otetaan pizza sessiosta.
		 * Tehd‰‰n t‰m‰ try-lohkon, jotta ohjelma ei kaadu nullpointer-poikkeukseen.
		 * Poikkeus tapahtuu jos sessio-aika umpeutuu ja silloin selain ohjataan virhesivulle.
		 */	
		
		try {
		if(idstr==null){
		idstr=(String) muistipizzasta.getAttribute("pizzaid");	
		
		}}
		
		catch(NullPointerException e){
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
		
		/**
		 * Pizzan muokkaus: K‰‰nnet‰‰n pizzaid merkkijonosta int -muuttujaksi
		 */	
		try {
			pizzaId=Integer.parseInt(idstr);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
					}
		/**
		 * Inventaario: * saatavuusyli15 on vaan ehto, jos arvo on false dao palauttaa ryhmitellen pizzat,  joiden
		 * saatavuus on alle 15, listaksi jota k‰ytet‰‰n pizzojen piiloitukseen. Admin ei pysty lis‰‰m‰‰n ruokalistaan
		 * ennen kuin t‰ytteit‰ on v‰hint‰‰n 15
		 * 
		 * Jos arvo on true, niill‰ palautetaan kaikki pizzat‰ytteet pizzoissa joiden saatavuus on alle 30.
		 * T‰t‰ k‰ytet‰‰ Pizza listaukseen, jotta admin n‰kisi v‰hiss‰ olevat t‰ytteet ennen piiloitusta
		 */	
		
		Boolean saatavuusyli15=false;
		List<PizzaTayte>noSalepizzas=kanta.naytaLopppuvatPizzatTaytteet(saatavuusyli15);
		
		poistaMenusta(noSalepizzas);
		TayteDAO taytehallinta= new TayteDAO();
		
		
		/**
		 * Pizzan muokkaus: Haetaan pizza pizzaid:n avulla int-muuttujana
		 */	
		
		Pizza pizza=kanta.bringPizza(pizzaId);
		Pizza p=null;
		List<Pizza> pizzalista=new ArrayList<Pizza>();
		
		/**
		 * Pizzan muokkaus: Lista vain yhdelle, jonka tiedot tulostetaan muokkaus.jsp:ss‰
		 */	
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
		TayteDAO taytehallinta= new TayteDAO();
		PizzaDAO kanta = new PizzaDAO();
		Pizza pizza=null;
		
		List<Tayte>taytelista=new ArrayList<Tayte>();
		boolean numerotarkistus=true;
		double hinta=0;
		int pizzaId=0;
		int tayteId=0;
		String tayteNimi;
		
		/**
		 * Pizzan muokkaus: otetaan parametrit vastaan
		 */	
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
			tayteId=Integer.parseInt(taytteet[i]);
			taytelista.add(taytehallinta.tuoTayte(tayteId));
						
			
		}
		
		}
		
		catch(NullPointerException e){
		
		
		}
		
		
		/**
		 * Pizzan muokkaus: Jos t‰ytteit‰ ei ole valittu check boolean-arvo
		 *  ei anna  pizza kuvauksen muuttua
		 */	
		
		if(taytelista.size()==0){
		
		
		
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
			
			taytehallinta.MuokkaaPizzaTayte(nimi, pizzaId, taytelista);;
			kanta.muokkaaPizza(id, nimi, hinta, kuvaus, taytelista, check);
			
			
		}
		
		
		
		response.sendRedirect("/Sprintti/MuokkaaPizza");
	}
	
	
	
	
	
	
	
	
	
	
	private boolean tunnistaKayttaja(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		
		boolean vahvistus = false;
		AdminDao admintiedot = new AdminDao();
		String Kayttajanimi = "";
		String Salasana = "";
		
		HttpSession sessio = request.getSession(false);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				if ("kayttunnus".equals(cookies[i].getName())) {
					String logged = "logged";
					Kayttajanimi = cookies[i].getValue();
					request.setAttribute("logged", logged);
					request.setAttribute("tunnus", Kayttajanimi);
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
			

		}

		catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
		return vahvistus;
	}
	
	
	
	
	
	

	private void poistaMenusta(List<PizzaTayte>noSalepizzas){
		PizzaDAO kanta = new PizzaDAO();
			
	for(int i=0; i<noSalepizzas.size(); i++)	{
		
	PizzaTayte pt=noSalepizzas.get(i);
		int piiloitusid=pt.getPizzaid();
		kanta.piilotaPizza(piiloitusid);
		
		
	}
			
			
	
			
			
		}
		
		
	
	
	
	
	

}
