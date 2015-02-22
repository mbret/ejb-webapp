package webapp.servlet;


import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.model.AuthUser;
import webapp.service.AuthService;
import webapp.service.EjbService;
import webapp.service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Subscribe extends ServletAbstract {

    private UserRemote userRemote;

    public Subscribe() throws Exception {
        this.userRemote = (UserRemote)EjbService.loadEJB(UserRemote.class);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        // Get complete user from db
        UserShared user = this.userRemote.findOne(AuthService.getUser(request).getId());
        
        // update subscription
        user.setSubscriber( true );
        
        // save new state
        this.userRemote.update( user );
        
        FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_SUBSCRIBED);
        response.sendRedirect(Config.ROUTE_PROFILE);
    }
}
