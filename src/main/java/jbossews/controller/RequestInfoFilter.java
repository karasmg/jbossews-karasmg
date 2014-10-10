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

/**
 * Servlet Filter implementation class BaseFilter
 */
@WebFilter("/*")
public abstract class RequestInfoFilter implements Filter{

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


	public void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String method = request.getMethod();
		String remoteAddr = request.getRemoteAddr();
		String queryString = request.getQueryString();
		String protocol = request.getProtocol();
		System.out.println(">>Проходим RequestInfoFilter:");
		System.out.println("  >>"+method);
		System.out.println("  >>"+remoteAddr);
		System.out.println("  >>"+queryString);
		System.out.println("  >>"+protocol);
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
