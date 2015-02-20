package web.filter;


import web.service.FlashService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Maxime on 2/20/2015.
 */
public class FlashFilter implements Filter {

    private final static Logger LOGGER = Logger.getLogger(FlashFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        
        FlashService.attach(req);
        
        req.setAttribute( FlashService.FlashLevel.ERROR, FlashService.getMessage(FlashService.FlashLevel.ERROR));
        req.setAttribute( FlashService.FlashLevel.SUCCESS, FlashService.getMessage(FlashService.FlashLevel.SUCCESS));
        req.setAttribute( FlashService.FlashLevel.INFO, FlashService.getMessage(FlashService.FlashLevel.INFO));
        req.setAttribute( FlashService.FlashLevel.WARNING, FlashService.getMessage(FlashService.FlashLevel.WARNING));

        // pass the request along the filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
