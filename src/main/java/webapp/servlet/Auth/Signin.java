package webapp.servlet.Auth;


import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.form.SigninForm;
import webapp.model.AuthUser;
import webapp.service.AuthService;
import webapp.service.EjbService;
import webapp.service.FlashService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Signin extends ServletAbstract {

    private UserRemote userbean;

    public Signin() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_SIGNIN);
        this.userbean = (UserRemote) EjbService.loadEJB(UserRemote.class);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        SigninForm form = new SigninForm();
        form.populate( request );

        if( ! form.isValid() ){
            request.setAttribute( FlashService.FlashLevel.ERROR, form.getErrors() );
            this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
        }
        else{
            
            UserShared user = this.userbean.getUser( form.getValues().get(SigninForm.FIELD_EMAIL), form.getValues().get(SigninForm.FIELD_PASSWORD));
            
            // invalid credentials
            if(user == null){
                request.setAttribute( FlashService.FlashLevel.ERROR, "Invalid credentials" );
                this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
            }
            else{
                AuthService.logIn(new AuthUser(user.getId(), user.getMail(), user.getPassword(), user.isSubscriber()), request);

                FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_LOGGED);

                response.sendRedirect( Config.ROUTE_INDEX );
            }
        }
    }

}
