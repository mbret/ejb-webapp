package core;

import java.util.HashMap;

/**
 * Created by Maxime on 2/20/2015.
 */
public class Config {

    private static HashMap<String, String> routes;
    
    public static String ROUTES_PARTIALS = "/views/partials";
    public static String ROUTE_SIGNIN = "/signin";
    public static String ROUTE_INDEX = "/";

    // Used in views
    // substring remove the first /
    static {
        routes = new HashMap<String, String>();
        routes.put("index", ROUTE_INDEX.substring(1));
        routes.put("signin", ROUTE_INDEX.substring(1));
        routes.put("articles", ROUTE_INDEX.substring(1));
        routes.put("folders", ROUTE_INDEX.substring(1));
        routes.put("subscribe", ROUTE_INDEX.substring(1));
        routes.put("writeArticle", ROUTE_INDEX.substring(1));
        routes.put("logout", ROUTE_INDEX.substring(1));
    }

    public static HashMap<String, String> getRoutes()
    {
        return routes;
    }
    
}
