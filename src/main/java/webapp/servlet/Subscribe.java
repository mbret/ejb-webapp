package webapp.servlet;


import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.model.AuthUser;
import webapp.service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Subscribe extends ServletAbstract {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        AuthUser user = (AuthUser)request.getSession().getAttribute("user");
        
        FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_SUBSCRIBED);
        response.sendRedirect(Config.ROUTE_PROFILE);
    }
}
