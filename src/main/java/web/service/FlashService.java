package web.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Maxime on 2/20/2015.
 */
public class FlashService {

    private static HttpServletRequest request;
    
    private FlashService(){
        
    }

    private static FlashService INSTANCE;

    public static void attach(HttpServletRequest request){
        FlashService.request = request;
    }
    
    public static FlashService getInstance()
    {	
        if(INSTANCE == null){
            INSTANCE = new FlashService();
        }
        return INSTANCE;
    }

    public static void addMessage( String level, Object message ){
        getInstance().request.getSession().setAttribute( level, message);
    }
    
    public static  Object getMessage( String level ){
        Object message = getInstance().request.getSession().getAttribute( level );
        getInstance().request.getSession().removeAttribute( level );
        return message;
    }
    
    public static class FlashLevel{
        public static String INFO = "info";
        public static String ERROR = "errors";
        public static String WARNING = "warnings";
        public static String SUCCESS = "success";

    }
}
