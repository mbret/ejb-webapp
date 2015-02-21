package servlet.Auth;

import bean.UserBean;
import core.Config;
import core.ServletAbstract;
import form.SignupForm;
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
public class Signup extends ServletAbstract {

    public Signup() {
        this.view = Config.getViews().get(Config.ROUTE_SIGNUP);
    }

    /**
     * Process form
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
        // Create and populate the form
        SignupForm form = new SignupForm();
        form.populate( request );

        // Check form
        if( ! form.isValid() ){
            request.setAttribute( FlashService.FlashLevel.ERROR, form.getErrors());
            this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
        }
        else{
            AuthService.logIn(new AuthUser(12, "user@gmail.com", "password"), request);

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_SIGNUP);
            
            response.sendRedirect( "/index" );
        }
    }
}
