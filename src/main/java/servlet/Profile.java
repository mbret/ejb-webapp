package servlet;

import bean.*;
import service.*;
import core.Config;
import core.ServletAbstract;
import model.AuthUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Profile extends ServletAbstract {

    public Profile() {
        this.view = Config.getViews().get(Config.ROUTE_PROFILE);
    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        UserBean userBean = new UserBean(AuthService.getUser(request).getId(), AuthService.getUser(request).getEmail(), true );
        request.setAttribute("user", userBean);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);
    }
}
