package filter;

import core.Config;

import javax.servlet.*;

public class ConfigInjectorFilter implements Filter  {
   
    public void  init(FilterConfig config) throws ServletException{

    }
    
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        request.setAttribute("routes", Config.getRoutes());

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }
    
    public void destroy( ){

    }
}
