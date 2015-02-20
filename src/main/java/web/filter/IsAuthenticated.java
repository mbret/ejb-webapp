package web.filter;


import core.Config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Maxime on 2/20/2015.
 */
public class IsAuthenticated implements Filter {

    private final static Logger LOGGER = Logger.getLogger(IsAuthenticated.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        LOGGER.log(Level.INFO, "Requested Resource::" + uri);

        Object user = req.getSession().getAttribute("user");

        if( 
                // not a resource
                ! uri.startsWith("/assets") 
                // not in session
                && user == null 
                // not a autorized url
                && !(uri.endsWith("signin") || uri.endsWith("signup"))){
            
                LOGGER.log(Level.INFO, "Unauthorized access request");
                res.sendRedirect(Config.ROUTE_SIGNIN);
            
        }
        else{
            // pass the request along the filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
