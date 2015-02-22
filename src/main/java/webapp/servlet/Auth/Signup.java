package webapp.servlet.Auth;

import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.form.SigninForm;
import webapp.form.SignupForm;
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
public class Signup extends ServletAbstract {

    private UserRemote userbean;

    public Signup() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_SIGNUP);
        this.userbean = (UserRemote) EjbService.loadEJB(UserRemote.class);
    }
    
    /**
     * Process webapp.form
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
        // Create and populate the webapp.form
        SignupForm form = new SignupForm();
        form.populate( request );

        // Check webapp.form
        if( ! form.isValid() ){
            request.setAttribute( FlashService.FlashLevel.ERROR, form.getErrors());
            this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
        }
        else{
            
            // Check email
            if(this.userbean.emailExist(form.getValues().get(SignupForm.FIELD_EMAIL))){
                request.setAttribute( FlashService.FlashLevel.ERROR, "Emeail arleady exist");
                this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
            }

            // Create user
            UserShared user = null;
            try {
                user = this.userbean.save(form.getValues().get(SigninForm.FIELD_EMAIL), form.getValues().get(SigninForm.FIELD_PASSWORD));
            } catch (Exception e) {
                throw new ServletException(e);
            }

            // log in
            AuthService.logIn(new AuthUser(user.getId(), user.getMail(), user.getPassword(), user.isSubscriber()), request);

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_SIGNUP);
            
            response.sendRedirect( "/index" );
        }
    }
}
