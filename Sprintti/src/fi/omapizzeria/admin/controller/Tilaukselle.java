package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import dao.TilausDao;
import dao.TilausRiviDao;
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
		
		try {tilausNro=Integer.parseInt(tilausNrostr);
			
		} catch (Exception e) {e.printStackTrace();
			// TODO: handle exception
		}
		
		TilausRiviDao rivihallinta=new TilausRiviDao();
		
		List<Tilausrivi>rivit=rivihallinta.haeRivit(tilausNro);
		
		for(Tilausrivi p : rivit) {
		   
		}
		
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
		
		for(int i=0; i<rivit.size(); i++){
			rivi=rivit.get(i);
			item=item+linebreak+rivi.getPizza().getNimi()+" "+rivi.getLkm()+" kpl "+desimaalit.format(rivi.getHinta())+
					" EUR";
		}
		
		
		tilauskasittely.vahvistaTilaus(tilausnro);
		Tilaus t=tilauskasittely.haeTilaus(tilausnro);
		
		String etunimi=t.getTilausAsiakas().getEtunimi();
		String sukunimi=t.getTilausAsiakas().getSukunimi();
		String viesti="Hei "+etunimi+" "+sukunimi+linebreak
				+ "Tilauksenne:"+linebreak
				+item+linebreak+linebreak+"Ystävällisin Terveisin"+linebreak+"Castello & Fior";
		
		
		System.out.println(viesti);
		
	}

	
	
	
}
