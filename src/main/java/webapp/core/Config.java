package webapp.core;

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
    public static String ROUTE_ARTICLES = "/index";
    public static String ROUTE_ARTICLE = "/articles/detail";
    public static String ROUTE_ARTICLE_WRITE = "/articles/write";
    public static String ROUTE_FOLDERS = "/folders";
    public static String ROUTE_SUBSCRIBE = "/subscribe";
    public static String ROUTE_COMMENT_POST = "/articles/comments/post";
    public static String ROUTE_PROFILE = "/profile";

    public static String MESSAGE_LOGGED = "You have been logged in!";
    public static String MESSAGE_SIGNUP = "You have been register!";
    public static String MESSAGE_LOGOUT = "You have been logged out!";
    public static String MESSAGE_WROTE = "Article created!";
    public static String MESSAGE_COMMENT_POSTED = "Comment posted!";
    public static String MESSAGE_SUBSCRIBED = "You are now a gold member, well done!";

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
        routes.put("article", ROUTE_ARTICLE.substring(1));
        routes.put("logout", ROUTE_LOGOUT.substring(1));
        routes.put("postComment", ROUTE_COMMENT_POST.substring(1));
        routes.put("profile", ROUTE_PROFILE.substring(1));
    }

    static {
        views = new HashMap<String, String>();
        views.put(ROUTE_SIGNIN, ROUTES_PARTIALS + "/signin.jsp");
        views.put(ROUTE_SIGNUP, ROUTES_PARTIALS + "/signup.jsp");
        views.put(ROUTE_ARTICLES, ROUTES_PARTIALS + "/index.jsp");
        views.put(ROUTE_FOLDERS, ROUTES_PARTIALS + "/folders.jsp");
        views.put(ROUTE_ARTICLE_WRITE, ROUTES_PARTIALS + "/articles-write.jsp");
        views.put(ROUTE_ARTICLE, ROUTES_PARTIALS + "/articles-detail.jsp");
        views.put(ROUTE_PROFILE, ROUTES_PARTIALS + "/profile.jsp");
    }

    public static HashMap<String, String> getRoutes()
    {
        return routes;
    }

    public static HashMap<String, String> getViews() {
        return views;
    }
}
