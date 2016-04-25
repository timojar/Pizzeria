

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.SahkoPosti;

/**
 * Servlet implementation class email1
 */
@WebServlet("/email1")
public class email1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public email1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		SahkoPosti email=new SahkoPosti();

		String lahettajanGoogleEmail= "88juslin@gmail.com";

		String lahettajanGoogleSalasana="88juslin!";

		String vastaanottajanEmail="timo_jarmala@luukku.com";

		String otsikko="Moro";

		String emailinSisalto="Tämä on vaan testi";
		  email.lahetaSahkoposti(lahettajanGoogleEmail, lahettajanGoogleSalasana, vastaanottajanEmail, 
				otsikko, emailinSisalto);
			
				
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
