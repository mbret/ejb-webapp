package webapp.servlet.Auth;


import webapp.bean.UserBean;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.form.SigninForm;
import webapp.model.AuthUser;
import webapp.service.AuthService;
import webapp.service.FlashService;

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
