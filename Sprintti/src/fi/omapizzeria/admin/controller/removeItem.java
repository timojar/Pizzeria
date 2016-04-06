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

import fi.omapizzeria.admin.bean.Pizza;

/**
 * Servlet implementation class removeItem
 */
@WebServlet("/removeItem")
public class removeItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession muistiostoslistasta= request.getSession(false);
		String clear=request.getParameter("tyhjennys");
		List<Pizza> ostoslista=null;
		if (clear!=null) {
			ostoslista=new ArrayList<Pizza>();
			muistiostoslistasta.setAttribute("ostoslista", ostoslista);
		}
		
		response.sendRedirect("/Sprintti/menuController");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession muistiostoslistasta= request.getSession(false);
		List<Pizza> ostoslista=(List<Pizza>)muistiostoslistasta.getAttribute("ostoslista");
		int index=0;
		
		String indexstr=request.getParameter("index");
		
		
		try {
			index=Integer.parseInt(indexstr);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ostoslista.remove(index);
		
		muistiostoslistasta.setAttribute("ostoslista", ostoslista);
		
		response.sendRedirect("/Sprintti/removeItem");
	}

}
