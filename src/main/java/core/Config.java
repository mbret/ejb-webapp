package core;

import java.util.HashMap;

/**
 * Created by Maxime on 2/20/2015.
 */
public class Config {

    private static HashMap<String, String> routes;
    private static HashMap<String, String> views;
    
    public static String ROUTES_PARTIALS = "/views/partials";
    public static String ROUTE_SIGNIN = "/signin";
    public static String ROUTE_SIGNUP = "/signup";
    public static String ROUTE_INDEX = "/index";
    public static String ROUTE_LOGOUT = "/logout";
    public static String ROUTE_ARTICLES = "/articles";
    public static String ROUTE_ARTICLE_WRITE = "/articles/write";
    public static String ROUTE_FOLDERS = "/folders";
    public static String ROUTE_SUBSCRIBE = "/subscribe";

    public static String MESSAGE_LOGGED = "You have been logged in!";
    public static String MESSAGE_SIGNUP = "You have been register!";
    public static String MESSAGE_LOGOUT = "You have been logged out!";

    // Used in views
    // substring remove the first /
    static {
        routes = new HashMap<String, String>();
        routes.put("index", ROUTE_INDEX.substring(1));
        routes.put("signin", ROUTE_SIGNIN.substring(1));
        routes.put("articles", ROUTE_ARTICLES.substring(1));
        routes.put("folders", ROUTE_FOLDERS.substring(1));
        routes.put("subscribe", ROUTE_SUBSCRIBE.substring(1));
        routes.put("writeArticle", ROUTE_ARTICLE_WRITE.substring(1));
        routes.put("logout", ROUTE_LOGOUT.substring(1));
    }

    static {
        views = new HashMap<String, String>();
        views.put(ROUTE_SIGNIN, ROUTES_PARTIALS + "/signin.jsp");
        views.put(ROUTE_SIGNUP, ROUTES_PARTIALS + "/signup.jsp");
        views.put(ROUTE_ARTICLES, ROUTES_PARTIALS + "/articles.jsp");
        views.put(ROUTE_FOLDERS, ROUTES_PARTIALS + "/folders.jsp");
        views.put(ROUTE_SUBSCRIBE, ROUTES_PARTIALS + "/subscribe.jsp");
        views.put(ROUTE_ARTICLE_WRITE, ROUTES_PARTIALS + "/articles-write.jsp");
    }

    public static HashMap<String, String> getRoutes()
    {
        return routes;
    }

    public static HashMap<String, String> getViews() {
        return views;
    }
}
