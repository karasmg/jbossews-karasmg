package jbossews.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbossews.model.DaoFactory;
import jbossews.model.MySqlDataFactory;
import jbossews.model.MySqlUserDao;
import jbossews.model.User;

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


        MySqlDataFactory daoFactory = new MySqlDataFactory();
        try {
			Connection con = daoFactory.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        List<User> users = null;
		try {
			users = new MySqlUserDao(null).getAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
     /*   String url = "jdbc:mysql://127.0.0.1:/db4";

        Class.forName("org.gjt.mm.mysql.Driver");

        Connection cn = null;

        try {

     cn = DriverManager.getConnection(url, "root", "");

         PreparedStatement st = null;

          try {

       st = cn.prepareStatement(*/
        out.println(users);
	}
      
    
        
        
}

