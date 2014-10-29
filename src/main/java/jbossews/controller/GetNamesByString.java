package jbossews.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import jbossews.model.CommodityDao;
import jbossews.model.DaoFactory;
import jbossews.model.MySqlCommodityDao;
import jbossews.model.MySqlDaoFactory;
import jbossews.model.MySqlStoreDao;
import jbossews.model.MySqlUserDao;
import jbossews.model.Store;
import jbossews.model.StoreDao;
import jbossews.model.User;

/**
 * Servlet implementation class RequestHeader
 */
@WebServlet("/findforms")
public class GetNamesByString extends HttpServlet {
	static final Logger log = LogManager.getLogger(GetNamesByString.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetNamesByString() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//настраиваем выходной поток клиенту
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        
        JSONArray arrayObj=new JSONArray();
        
        String query = request.getParameter("term");
        //query = query.toLowerCase();
        log.error("query = "+query);
        DaoFactory df = new MySqlDaoFactory();
		CommodityDao cd = null;
		
		//пытаемся получить коннекшин
		try {
			cd = new MySqlCommodityDao(df.getConnection());
		} catch (SQLException e1) {
			log.error("cd = new MySqlCommodityDao(df.getConnection()): "+e1.getMessage());
			e1.printStackTrace();
		}
		List<String> jArray = null;
		try {
			jArray = cd.getNamesCommoditiesByString(query);
		} catch (SQLException e) {
			log.error("jArray = cd.getNamesCommoditiesByString(query): "+e.getMessage());
			e.printStackTrace();
		}
		
		arrayObj.addAll(jArray);	
		
		PrintWriter out = response.getWriter();
		out.println(arrayObj.toString());
        out.close();
		
	}
}
