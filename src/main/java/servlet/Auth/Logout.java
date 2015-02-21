package servlet.Auth;

import core.Config;
import core.ServletAbstract;
import service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Logout extends ServletAbstract {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        if(null != request.getSession().getAttribute("user")){
            request.getSession().removeAttribute("user");
        }

        FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_LOGOUT);
        
        response.sendRedirect(Config.ROUTE_SIGNIN);
    }
}