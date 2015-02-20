package web.servlet.Auth;


import core.Config;
import core.Servlet;
import form.SigninForm;
import web.service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Signin extends Servlet {

    public Signin() {
        this.view = Config.getViews().get(Config.ROUTE_SIGNIN);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        SigninForm form = new SigninForm();
        form.populate( request );

        if( ! form.isValid() ){
            request.setAttribute( FlashService.FlashLevel.ERROR, form.getErrors() );
            this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
        }
        else{
            request.getSession().setAttribute("user", "µPower user motherfucker");
            request.getSession().setMaxInactiveInterval(300);

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_LOGGED);
            
            response.sendRedirect( Config.ROUTE_INDEX );
        }
    }

}
