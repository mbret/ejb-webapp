package web.servlet;


import core.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Subscribe extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
        // Check auth
        if(null == request.getSession().getAttribute("user")){
            response.sendRedirect( Config.ROUTE_SIGNIN );
            return;
        }

        this.getServletContext().getRequestDispatcher(Config.ROUTES_PARTIALS + "/index.jsp" ).forward(request, response);
    }
}
