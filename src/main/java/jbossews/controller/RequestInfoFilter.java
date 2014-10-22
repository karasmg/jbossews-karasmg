package jbossews.controller;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BaseFilter
 */
@WebFilter("/*")
public class RequestInfoFilter implements Filter{

    /**
     * Default constructor. 
     */
    public RequestInfoFilter() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
	 
		String method = hsr.getMethod();
		hsr.getCookies();
		HttpSession session = hsr.getSession(true);
		String remoteAddr = hsr.getRemoteAddr();
		String queryString = hsr.getQueryString();
		String protocol = hsr.getProtocol();
		hsr.setAttribute("method", method);
		hsr.setAttribute("remoteAddr", remoteAddr);
		hsr.setAttribute("queryString", queryString);
		hsr.setAttribute("protocol", protocol);
			// pass the request along the filter chain
			//отдаем управление дальше
			chain.doFilter(request, response);
			//альтернативные варианты:
			//response.sendError(503);
			//response.sendRedirect("/what.jsp");
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
