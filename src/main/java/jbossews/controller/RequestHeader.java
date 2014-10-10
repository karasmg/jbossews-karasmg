package jbossews.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeader
 */
@WebServlet("/viewusers.html")
public class RequestHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Enumeration e = request.getHeaderNames();

        while (e.hasMoreElements()) {

        String name = (String)e.nextElement();

        String value = request.getHeader(name);
        
        
	}
        out.println("Plushki vot Post");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Enumeration e = request.getHeaderNames();

        while (e.hasMoreElements()) {

        String name = (String)e.nextElement();

        String value = request.getHeader(name);
        
	}
        out.println("Plushki vot Get");
	}
}
