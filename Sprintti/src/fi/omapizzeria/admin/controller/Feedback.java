package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.SahkoPosti;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String otsikko=request.getParameter("group1")+" palaute";
		String emailinSisalto=request.getParameter("palaute");
		String lahettajanGoogleEmail= "88juslin@gmail.com";
		String lahettajanGoogleSalasana="88juslin!";
		String vastaanottajanEmail="Castellopalaute@gmail.com";
	

		SahkoPosti sposti=new SahkoPosti();
		
		sposti.lahetaSahkoposti(lahettajanGoogleEmail, lahettajanGoogleSalasana, vastaanottajanEmail, otsikko, emailinSisalto);
		
	}

}
