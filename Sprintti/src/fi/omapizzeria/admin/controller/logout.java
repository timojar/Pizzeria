package fi.omapizzeria.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
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
		String logout=request.getParameter("logout");
	
		
		
		HttpSession sessio = request.getSession(false);
		Cookie [] cookies=request.getCookies();
		if(request.getParameter("logout")!=null){
			
			
			if(sessio!=null){
			sessio.invalidate();
			}
			
			
			if(cookies!=null){
				
			for(int i=0; i<cookies.length; i++)	{
				
				Cookie ck=cookies[i];
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
				cookies[i].setValue(null);;
				cookies[i].setMaxAge(0);
					
				response.addCookie(ck);
			}
			
				
			}
			
				
		}
		
		response.sendRedirect("/Sprintti/controller?added=true");
				
	}

}
