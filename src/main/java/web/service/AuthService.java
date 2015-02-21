package web.service;

import bean.UserBean;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Maxime on 2/21/2015.
 */
public class AuthService {
    
    public static void logIn(UserBean user, HttpServletRequest request){
        request.getSession().setAttribute("user", user);
        request.getSession().setMaxInactiveInterval(300);
    }
}
