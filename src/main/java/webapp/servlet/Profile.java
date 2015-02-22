package webapp.servlet;

import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import webapp.bean.*;
import webapp.service.*;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.model.AuthUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Profile extends ServletAbstract {

    private UserRemote userRemote;
    
    public Profile() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_PROFILE);
        this.userRemote = (UserRemote) EjbService.loadEJB(UserRemote.class);
    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        UserShared user;
        UserBean userBean;
        try {
            user = this.userRemote.findOne( AuthService.getUser(request).getId() );
            userBean = BeanFactory.convert(UserBean.class, user);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        request.setAttribute("user", userBean);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);
    }
}
