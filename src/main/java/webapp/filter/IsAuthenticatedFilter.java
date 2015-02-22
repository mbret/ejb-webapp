package webapp.filter;


import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import webapp.bean.UserBean;
import webapp.core.Config;
import webapp.model.AuthUser;
import webapp.service.AuthService;
import webapp.service.EjbService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Maxime on 2/20/2015.
 */
public class IsAuthenticatedFilter implements Filter {

    private final static Logger LOGGER = Logger.getLogger(IsAuthenticatedFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        LOGGER.log(Level.INFO, "Requested Resource::" + uri);

        // Auto log for debug
//        try {
//            UserRemote userRemote = (UserRemote) EjbService.loadEJB(UserRemote.class);
//            UserShared user = userRemote.findOne(10);
//            AuthService.logIn(new AuthUser(user.getId(), user.getMail(), user.getPassword(), user.getSubscriber()), req);
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
        
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
            // pass the request along the webapp.filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
