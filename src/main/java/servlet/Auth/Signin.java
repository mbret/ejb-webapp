package servlet.Auth;


import bean.UserBean;
import core.Config;
import core.ServletAbstract;
import form.SigninForm;
import model.AuthUser;
import service.AuthService;
import service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Signin extends ServletAbstract {

    public Signin(){
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
            AuthService.logIn(new AuthUser(12, "user@gmail.com", "password"), request);

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_LOGGED);
            
            response.sendRedirect( Config.ROUTE_INDEX );
        }
    }

}
