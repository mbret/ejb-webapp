package webapp.service;

import webapp.model.AuthUser;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Maxime on 2/21/2015.
 */
public class AuthService {
    
    public static void logIn(Object user, HttpServletRequest request){
        request.getSession().setAttribute("user", user);
        request.getSession().setMaxInactiveInterval(300);
    }
    
    public static AuthUser getUser(HttpServletRequest request){
        return (AuthUser) request.getSession().getAttribute("user");
    }
}
