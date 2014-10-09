

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
@WebFilter(asyncSupported = true, urlPatterns = { "/BaseFilter" })
public class RequestInfoFilter extends BaseFilter{

    /**
     * Default constructor. 
     */
    public RequestInfoFilter() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	String method = request.getMethod();
	String remoteAddr = request.getRemoteAddr();
	String queryString = request.getQueryString();
	String protocol = request.getProtocol();

		// pass the request along the filter chain
		//отдаем управление дальше
		chain.doFilter(request, response);
		//альтернативные варианты:
		//response.sendError(503);
		//response.sendRedirect("/what.jsp");
	}

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
