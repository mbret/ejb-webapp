package web.servlet;


import core.Config;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Index extends Main {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        this.getServletContext().getRequestDispatcher(Config.ROUTES_PARTIALS + "/index.jsp" ).forward(request, response);
    }
}
