package webapp.core;


import webapp.service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public abstract class ServletAbstract extends HttpServlet {

    protected String view;

    /**
     * doGet by default. Redirect to the view specified in children.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        if( this.view == null){
            throw new ServletException("You have to initialize the view attribute in order to use parent doGet(). If you did that maybe look at the route config!");
        }
        
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);

    }
}
