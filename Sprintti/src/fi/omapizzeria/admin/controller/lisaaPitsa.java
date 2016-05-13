package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import dao.PizzaDAO;
import dao.TayteDAO;
import fi.omapizzeria.admin.bean.Tayte;
/**
 * @Timo Jarmala
 */
/**
 * Servlet implementation class lisaaPitsa
 */
@WebServlet("/lisaaPitsa")
public class lisaaPitsa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lisaaPitsa() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TayteDAO taytehallinata = new TayteDAO();
		List<Tayte> taytelista = new ArrayList<Tayte>();
		double hinta = 0;

		/**
		 * Pizzan lis‰ys: Otetaan parametrit list.jsp:lt‰ vastaan
		 */

		String nimi = request.getParameter("nimi");
		String kuvaus = request.getParameter("kuvaus");
		String hintasana = request.getParameter("hinta");
		String tayteNimi;
		int pizzaId = 0;
		int tayteId = 0;
		boolean hintavirhe = false;

		/**
		 * Pizzan lis‰ys: taytevirhe boolean-muuttuja arvo kertoo onko t‰ytteit‰
		 * valittu ollenkaan tai onko t‰ytteit‰ yli 7. Jos niit‰ ei ole tai on
		 * oli 7, taytevirhe on true. Jos arvo on true, pizzaa ei voi luoda.
		 */

		boolean taytevirhe = false;
		String[] taytteet = request.getParameterValues("taytteet");

		/**
		 * Pizzan lis‰ys: tayteId:eet tulevat taulukkona merkkijonoissa. K‰yd‰‰n
		 * taulukko l‰pi for-loopissa ja k‰‰nnet‰‰n ne int-muuttujiksi. For-loop
		 * laitetaan try-lohkon, jotta ohjelma ei kaadu Nullpointer-poikkeukseen
		 */

		try {
			for (int i = 0; i < taytteet.length; i++) {
				tayteId = Integer.parseInt(taytteet[i]);
				taytelista.add(taytehallinata.tuoTayte(tayteId));

			}

			if (taytteet.length > 7) {
				taytevirhe = true;
			}

		} catch (NullPointerException e) {
			taytevirhe = true;
		}

		PizzaDAO kanta = new PizzaDAO();

		try {
			hinta = Double.parseDouble(hintasana);
		}

		/**
		 * Pizzan lis‰ys: Hintavirhe true-arvo kertoo ett‰ syˆtett‰ ei ole
		 * annettu numerona oikeassa muodossa
		 */

		catch (Exception e) {
			hintavirhe = true;
			System.out.println("Hinta ei oo numero");
		}

		/**
		 * Pizzan lis‰ys: Metodi-lisaaPizza(nimi, hinta, taytelista) lis‰‰ uuden
		 * pizzan jos hintavirhe ja taytevirhe on false. Samalla se palauttaa
		 * pizzaId arvon int-muuttujasta. pizzaId-arvoa tarvitaan
		 * pizzat‰ytteiden (iventaariota varten) luomisessa.
		 */
		if (hintavirhe == false && taytevirhe == false) {

			pizzaId = kanta.lisaaPizza(nimi, hinta, taytelista);
			taytehallinata.luoPizzaTayte(nimi, pizzaId, taytelista);
			response.sendRedirect("/Sprintti/controller?added=true");
		}

		/**
		 * Pizzan lis‰ys: Jos hintavirhe on true selain ohjataan get:st‰ list.jsp:lle, jossa k‰ytt‰j‰ 
		 * saa viestin "Laita hinta numerona. Desimaalina k‰yt‰ .-merkint‰‰" hinta-parametrin v‰lityksell‰
		 */
		
		
		else if (hintavirhe == true) {
			response.sendRedirect("/Sprintti/controller?hinta=true");
		}
		/**
		 * Pizzan lis‰ys: Jos taytevirhe on true selain ohjataan get:st‰ list.jsp:lle, jossa k‰ytt‰j‰ 
		 * saa viestin "V‰hint‰‰n 1 t‰yte pit‰‰ olla pitsassa ja t‰ytteit‰ korkeintaan 7" taytemaara-parametrin
		 *  v‰lityksell‰
		 */

		else if (taytevirhe == true) {
			response.sendRedirect("/Sprintti/controller?taytemaara=true");
		}

	}

}
