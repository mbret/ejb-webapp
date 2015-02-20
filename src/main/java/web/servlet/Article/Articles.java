package web.servlet.Article;


import core.Config;
import core.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Articles extends Servlet {

    public Articles() {
        this.view = Config.getViews().get(Config.ROUTE_ARTICLES);
    }
}
